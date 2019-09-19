package com.justcs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询的实体封装类
 * @param <T>
 */
@ApiModel
public class PagedQueryForm<T> {

    @ApiModelProperty(name = "当前页面")
    private int page;

    @ApiModelProperty(name = "每页记录数")
    private int pagesize;

    @ApiModelProperty(name = "排序的字段")
    private String sort;

    @ApiModelProperty(name = "排序的方式")
    private String order;

    @ApiModelProperty(name = "条件查询的条件表单")
    private T search;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public T getSearch() {
        return search;
    }

    public void setSearch(T search) {
        this.search = search;
    }
}
