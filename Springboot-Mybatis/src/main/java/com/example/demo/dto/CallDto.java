package com.example.demo.dto;

import java.util.Objects;

/**
 * 通话记录
 */
public class CallDto {
    
    /**
     * 客户经理ID
     */
    protected String clientID ;
    /**
     * 客户经理姓名
     */
    protected String clientName ;
    /**
     * 通话时间
     */
    protected String callTime ;
    /**
     * 通话时长
     */
    protected String callDura ;
    /**
     * 联络人
     */
    protected String callPerson ;


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

    public String getCallTime() {
        return callTime;
    }

    public void setCallTime(String callTime) {
        this.callTime = callTime;
    }

    public String getCallDura() {
        return callDura;
    }

    public void setCallDura(String callDura) {
        this.callDura = callDura;
    }

    public String getCallPerson() {
        return callPerson;
    }

    public void setCallPerson(String callPerson) {
        this.callPerson = callPerson;
    }

    @Override
    public String toString() {
        return "CallDto{" +
                "clientID='" + clientID + '\'' +
                ", clientName='" + clientName + '\'' +
                ", callTime='" + callTime + '\'' +
                ", callDura='" + callDura + '\'' +
                ", callPerson='" + callPerson + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CallDto)) {
            return false;
        }
        CallDto callDto = (CallDto) o;
        return Objects.equals(getClientID(), callDto.getClientID()) &&
                Objects.equals(getCallTime(), callDto.getCallTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClientID(), getCallTime());
    }


}
