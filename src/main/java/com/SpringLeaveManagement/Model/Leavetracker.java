package com.SpringLeaveManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Leavetracker
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date fromdate;
    private Date toDate;
    private String duration;
    private String reason;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Leavetracker(Date fromdate, Date toDate, String duration, String reason, String email) {
        this.fromdate = fromdate;
        this.toDate = toDate;
        this.duration = duration;
        this.reason = reason;
        this.email = email;
    }

    public Leavetracker() {
    }
}
