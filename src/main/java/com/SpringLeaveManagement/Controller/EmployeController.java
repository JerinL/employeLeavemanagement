package com.SpringLeaveManagement.Controller;

import com.SpringLeaveManagement.Model.*;
import com.SpringLeaveManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeController
{

    @Autowired
    UserService userService;

    @RequestMapping(value = "getuser")
    public List<UserEmployee> getuser()
    {
        return userService.getUser();
    }
    @RequestMapping(value = "/getuser/{id}")
    public Optional<UserEmployee> getuserbyid(@PathVariable("id") Integer userid)
    {
         return userService.getuserbyid(userid);
    }
    @RequestMapping(value = "/updateuser",method = RequestMethod.PUT)
    public UserEmployee userUpdate(@RequestBody UserEmployee newUser)
    {
        return userService.userUpdate(newUser);
    }
    @RequestMapping(value = "/deleteuser/{id}",method = RequestMethod.DELETE)
    public String deleteuserbyId(@PathVariable("id") Integer id)
    {
        return userService.deluser(id);
    }

    //register
    @RequestMapping(value = "adduser",method = RequestMethod.POST)//register
    public String addUser(@Valid @RequestBody UserEmployee userEmployee)
            //@RequestBody --
    {
        return userService.addUser(userEmployee);
    }
    //Login
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public profile loginuser(@Valid @RequestBody login login)
    {
        return userService.loginuser(login);
    }
    //Forgot password
    @RequestMapping(value = "forgotpass",method = RequestMethod.PUT)
    public String forgotpass(@RequestBody login forgotpass)
    {
        return userService.forgotpass(forgotpass);
    }
    //Request Leave
    @PostMapping(value = "addleave")
    public String addLeave(@RequestBody Leavetracker leavetracker)
    {
        return userService.addLeave(leavetracker);
    }
    //User Leave
    @RequestMapping(value = "noofleaves")
    public int noofLeaves(@RequestParam String email)
    {
        return userService.noofLeaves(email);
    }
    @RequestMapping(value = "availableleave")
    public int Availableleave(@RequestParam String email)
    {
        return userService.Availableleave(email);
    }
    @RequestMapping(value = "lossofpay")
    public int Lossofpay(@RequestParam String email)
    {
        return userService.Lossofpay(email);
    }
    @RequestMapping(value = "noofleavesTaken")
    public  int noofleavesTaken(@RequestParam String email)
    {
        return userService.noofleavesTaken(email);
    }
    @GetMapping(value = "gethistory")
    public List<Leavetracker> getHistory(@RequestParam String email)
    {
        return userService.getHistory(email);
    }

}
