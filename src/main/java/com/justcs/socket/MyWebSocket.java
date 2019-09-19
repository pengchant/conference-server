package com.justcs.socket;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/wbsocket")
public class MyWebSocket {

    private static Logger logger =  LoggerFactory.getLogger(MyWebSocket.class);

    // 当前连接人数
    private static int onlineCount = 0;

    // 与某个客户连接会话
    private Session session;

    // concurrent包线程安全Set
    public static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();


    /**
     * 连接建立
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        addOnlineCount();
        logger.info("New session insert, sessionId is " + session.getId() + ", current online:" + MyWebSocket.onlineCount);

    }

    /**
     * 关闭连接
     */
    @OnClose
    public void onClose(){
        webSockets.remove(this);
        subOnlineCount();
        logger.info("A session removed, sessionId is " + session.getId() + ",current users:" + getOnlineCount());
    }

    /**
     * 接收前端传过来的数据
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session){
        logger.info(message + " from " + session.getId());
    }

    /**
     * 发生错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        logger.error("发生错误");
        error.printStackTrace();
    }


    /**
     * 发送消息(服务器推送)
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     * @param message
     */
    public static void sendInfo(String message){
        logger.info("群发消息");
        try {
            for (MyWebSocket item: webSockets){
                item.sendMessage(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("推送消息异常...");
        }
    }

    public static synchronized int getOnlineCount(){
        return onlineCount;
    }

    public static synchronized void addOnlineCount(){
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount(){
        MyWebSocket.onlineCount--;
    }


}
