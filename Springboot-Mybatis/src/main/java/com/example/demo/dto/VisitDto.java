package com.example.demo.dto;

/**
 * 拜访记录
 */
public class VisitDto {
    /**
     * 客户经理ID
     */
    private String clientID ;
    /**
     * 客户经理名称
     */
    private String clientName ;
    /**
     * 拜访时间
     */
    private String visitTime ;
    /**
     * 拜访地点
     */
    private String visitArea ;
    /**
     * 拜访人
     */
    private String visitPerson ;
    /**
     * 拜访标识
     */
    private String visitTag ;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitArea() {
        return visitArea;
    }

    public void setVisitArea(String visitArea) {
        this.visitArea = visitArea;
    }

    public String getVisitPerson() {
        return visitPerson;
    }

    public void setVisitPerson(String visitPerson) {
        this.visitPerson = visitPerson;
    }

    public String getVisitTag() {
        return visitTag;
    }

    public void setVisitTag(String visitTag) {
        this.visitTag = visitTag;
    }

    @Override
    public String toString() {
        return "VisitDto{" +
                "clientID='" + clientID + '\'' +
                ", clientName='" + clientName + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", visitArea='" + visitArea + '\'' +
                ", visitPerson='" + visitPerson + '\'' +
                ", visitTag='" + visitTag + '\'' +
                '}';
    }
}
