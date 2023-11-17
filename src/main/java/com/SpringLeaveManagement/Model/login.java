package com.SpringLeaveManagement.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class login
{

    @NotBlank(message = "email Required")
    @Email(message = "email should be match")
    private String email;
    @NotBlank(message = "password Required")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
