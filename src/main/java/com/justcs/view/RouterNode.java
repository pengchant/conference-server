package com.justcs.view;

import java.util.List;

/**
 * Vue 的路由子节点数据结构
 */
public class RouterNode {

    // 添加的属性，router的编号
    private String id;

    // 父节点的编号
    private String parentid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 路径
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 跳转的路径
     */
    private String redirect;

    /**
     * name
     */
    private String name;

    /**
     * 节点的媒体信息
     */
    private Meta meta;


    /**
     * 子节点
     */
    private List<RouterNode> children;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<RouterNode> getChildren() {
        return children;
    }

    public void setChildren(List<RouterNode> children) {
        this.children = children;
    }
}
