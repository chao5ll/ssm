package com.example.ssm.util;

public class Page {
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private int pageNO;//当前页
    private int pageSize=3;//每页大小
    private int startP;//开始的位置

    public Page() {
    }

    public Page(int pageNO, int totalCount) {
        this.pageNO = pageNO;
        this.totalCount = totalCount;
    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNO() {
        return pageNO;
    }

    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartP() {
        return startP;
    }

    public void setStartP(int startP) {
        this.startP = startP;
    }
}
