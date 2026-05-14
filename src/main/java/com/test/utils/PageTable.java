package com.test.utils;

import java.util.List;

public class PageTable<T> {

    public Integer page;  //当前页码
    public Integer pages; //可用的页面总数
    public Integer perpage; //每页总记录数
    public Long total;// 合计服务器中可用的所有记录编号
    public List<T> data;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerpage() {
        return perpage;
    }

    public void setPerpage(Integer perpage) {
        this.perpage = perpage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public PageTable(List<T> data, long count) {
        this.data = data;
//        this.page = data.getNumber();
//        this.pages = data.getTotalPages();
//        this.perpage = data.getSize();
        this.total = count;
    }

    public PageTable() {
    }
}
