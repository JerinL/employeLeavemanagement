package com.SpringLeaveManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class userLeave
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  int noofleaves;
    private  int noofleavesTaken;
    private int  availableleave;
    private int lossofPay;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNoofleaves() {
        return noofleaves;
    }

    public void setNoofleaves(int noofleaves) {
        this.noofleaves = noofleaves;
    }

    public int getNoofleavesTaken() {
        return noofleavesTaken;
    }

    public void setNoofleavesTaken(int noofleavesTaken) {
        this.noofleavesTaken = noofleavesTaken;
    }

    public int getAvailableleave() {
        return availableleave;
    }

    public void setAvailableleave(int availableleave) {
        this.availableleave = availableleave;
    }

    public int getLossofPay() {
        return lossofPay;
    }

    public void setLossofPay(int lossofPay) {
        this.lossofPay = lossofPay;
    }


}
