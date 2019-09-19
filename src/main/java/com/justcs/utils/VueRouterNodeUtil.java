package com.justcs.utils;

import com.justcs.entity.Privilege;
import com.justcs.view.Meta;
import com.justcs.view.RouterNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 转化为VueRouter的工具类
 */
public class VueRouterNodeUtil {


    private static final Logger logger = LoggerFactory.getLogger(VueRouterNodeUtil.class);

//
//    /**
//     * 将List<Privilege> 转化为 List<RouterNode>
//     *
//     * @param allPrivilege
//     * @return
//     */
//    public List<RouterNode> convertoobj(List<Privilege> allPrivilege) {
//        List<RouterNode> result = new ArrayList<>();
//        if (allPrivilege != null) {
//            for (Privilege privilege : allPrivilege) {
//                RouterNode routerNode = new RouterNode();
//                routerNode.setId(privilege.getId());
//                routerNode.setParentid(privilege.getParentid());
//                routerNode.setName(privilege.getName());
//                routerNode.setComponent(privilege.getKeyword());
//                routerNode.setPath(privilege.getUrl());
//                routerNode.setRedirect(privilege.getUrl());
//                routerNode.setMeta(new Meta(privilege.getDescription(), ""));
//                result.add(routerNode);
//            }
//        }
//        return result;
//    }
//
//
//    /**
//     * 构造树
//     *
//     * @param allprivileges 所有的权限
//     * @return
//     */
//    public Map<String, Object> findTree(List<Privilege> allprivileges) {
//        // 返回的结果
//        Map<String, Object> data = new HashMap<>();
//        try {
//            // 根节点
//            List<RouterNode> rootNodes = new ArrayList<>();
//            // 从数据库中查询到的数据集
//            List<RouterNode> allMenus = convertoobj(allprivileges);
//            // 获取父节点
//            for (RouterNode r : allMenus) {
//                if (StringUtils.equals(r.getParentid(), "0")) { // parentId 为0 的，为根节点
//                    rootNodes.add(r);
//                }
//            }
//            // 获取根节点上的所有子节点
//            for (RouterNode nav : rootNodes) {
//                List<RouterNode> childNodeList = getChild(nav.getId(), allMenus);
//                nav.setChildren(childNodeList);
//            }
//            data.put("flag", "true");
//            data.put("list", rootNodes);
//            return data;
//        } catch (Exception e) {
//            logger.info("生成树失败!");
//            data.put("flag", "fasle");
//            data.put("list", new ArrayList<>());
//            return data;
//        }
//    }
//
//
//    /**
//     * 获取编号为id下面的所有的子节点
//     *
//     * @param id      待查找的父节点编号
//     * @param allMenu 所有的菜单
//     * @return
//     */
//    public List<RouterNode> getChild(String id, List<RouterNode> allMenu) {
//        // 子菜单
//        List<RouterNode> childList = new ArrayList<>();
//        for (RouterNode nav : allMenu) {
//            // 遍历所有节点，若所有菜单的父id与当前id相同，则认为是子节点
//            if (StringUtils.equals(id, nav.getParentid())) {
//                childList.add(nav);
//            }
//        }
//
//        if(childList.size() == 0){
//            return new ArrayList<>();
//        }
//
//        // 递归调用当前节点->子节点的每一个节点->子节点
//        for (RouterNode nav : childList) {
//            nav.setChildren(getChild(nav.getId(), allMenu));
//        }
//
//        return childList;
//    }
}
