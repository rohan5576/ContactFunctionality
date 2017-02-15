package com.example.admin.contactfunctionality.model;

import java.util.Date;

/**
 * Created by Admin on 15-02-2017.
 */

public class LogClass  {

    public String number;
    public String callType;
    public String CallDate;
    public String duration;
;

    public LogClass(String number, String callType, String callDate, String duration) {
        this.number = number;
        this.callType = callType;
        CallDate = callDate;

        this.duration = duration;
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getCallDate() {
        return CallDate;
    }

    public void setCallDate(String callDate) {
        CallDate = callDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
