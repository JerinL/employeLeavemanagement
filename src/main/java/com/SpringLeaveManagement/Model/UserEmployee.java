package com.SpringLeaveManagement.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UserEmployee
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        @NotNull(message = "Username Required ")
        private String name;
        @NotNull(message = "email Required")
        @Email(message = "mail should be correct")
        private String email;
        @NotNull(message ="Contact number Required" )
        private long contactNumber;
        @NotNull(message = "dept feild dont be blank")
        private String dept;
        @NotNull(message ="password required" )
        private String password;

    public UserEmployee() {
    }

    public UserEmployee(String name, String email, long contactNumber, String dept, String password) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dept = dept;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
