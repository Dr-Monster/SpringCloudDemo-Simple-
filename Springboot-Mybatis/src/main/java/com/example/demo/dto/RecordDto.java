package com.example.demo.dto;

/**
 * 查询Dto(Visit,Call)
 */
public class RecordDto {
    /**
     * 客户经理ID
     */
    private String clientID ;
    /**
     * 客户姓名
     */
    private String custName ;
    /**
     * 开始时间
     */
    private String startTime ;
    /**
     * 结束时间
     */
    private String endTime ;
    /**
     * 查询月份
     */
    private String queryMonth ;
    /**
     * 每页条数
     */
    private int pageSize ;
    /**
     * 当前页码
     */
    private int index ;

    /**
     * 签到类型
     */
    private String visitTag ;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getQueryMonth() {
        return queryMonth;
    }

    public void setQueryMonth(String queryMonth) {
        this.queryMonth = queryMonth;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getVisitTag() {
        return visitTag;
    }

    public void setVisitTag(String visitTag) {
        this.visitTag = visitTag;
    }

    @Override
    public String toString() {
        return "RecordDto{" +
                "clientID='" + clientID + '\'' +
                ", custName='" + custName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", queryMonth='" + queryMonth + '\'' +
                ", pageSize=" + pageSize +
                ", index=" + index +
                ", visitTag='" + visitTag + '\'' +
                '}';
    }
}
