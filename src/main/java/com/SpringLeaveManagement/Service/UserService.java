package com.SpringLeaveManagement.Service;

import com.SpringLeaveManagement.Model.*;
import com.SpringLeaveManagement.Repository.Employerepository;
import com.SpringLeaveManagement.Repository.Leavetrackerrepository;
import com.SpringLeaveManagement.Repository.userLeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UserService
{
    @Autowired
    private Employerepository employerepository; //Repository interface obj creation
    @Autowired
    private Leavetrackerrepository leavetrackerrepository;
    @Autowired
    private userLeaveRepository userLeaveRepository;

    //read user
    public List<UserEmployee> getUser()
    {
        List<UserEmployee> userList = new ArrayList<>();
        employerepository.findAll().forEach(user ->userList.add(user)); //get all values from the db and store all the values in the userlist
        return userList;
    }
    //create user

    public String addUser(UserEmployee userEmployee) //Register
    {
        UserEmployee obj;
        obj = employerepository.findByEmail(userEmployee.getEmail());
        if(obj != null)
       {
           return "email already exist";
       }else{
            employerepository.save(userEmployee);
            userLeave updateleave = new userLeave();
            updateleave.setEmail(userEmployee.getEmail());
            updateleave.setNoofleaves(12);
            updateleave.setAvailableleave(12);
            updateleave.setLossofPay(0);
            updateleave.setNoofleavesTaken(0);
            updateLeave(updateleave);
            return "Ok";

       }

    }
    //get user by id (single value)
    public Optional<UserEmployee> getuserbyid(Integer userid)
    {
        return employerepository.findById(userid);
    }
//update user
    public UserEmployee userUpdate(UserEmployee newUser)
    {
       return employerepository.save(newUser);
    }
//Delete user by id
public String deluser(Integer id) {
    employerepository.deleteById(id);
    return "Entry Deleted !!!";
}
      //Login
    public profile loginuser(login login)
    {
        UserEmployee obj;
        obj = employerepository.findByEmail(login.getEmail());
        if(obj != null)
        {
            if(obj.getPassword().equals(login.getPassword()))
            {
                profile pro = new profile();
                pro.setName(obj.getName());
                pro.setEmail(obj.getEmail());
                pro.setContactNumber(obj.getContactNumber());
                pro.setDept(obj.getDept());
                return pro;

            }else {
                return null;
            }
        }else{

            return null;
        }
    }

    public String forgotpass(login forgotpass)
    {
        UserEmployee obj;
        obj = employerepository.findByEmail(forgotpass.getEmail());
        if(obj != null)
        {
           obj.setPassword(forgotpass.getPassword());
           employerepository.save(obj);
           return "Ok";
        }else{

            return "Email not exist";
        }
    }

    public String addLeave(Leavetracker leavetracker)
    {
        leavetrackerrepository.save(leavetracker);
        long duration  =  leavetracker.getToDate().getTime()-leavetracker.getFromdate().getTime();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(duration);
        userLeave userleaveobj =userLeaveRepository.findByEmail(leavetracker.getEmail());
        if(userleaveobj.getAvailableleave() >= diffInDays)
        {
            userleaveobj.setAvailableleave((int) (userleaveobj.getAvailableleave() - diffInDays));
            userleaveobj.setNoofleavesTaken((int) (userleaveobj.getNoofleavesTaken() + diffInDays));
        }else
        {
            userleaveobj.setLossofPay((int) (diffInDays - userleaveobj.getAvailableleave()));
            userleaveobj.setNoofleavesTaken((int) (userleaveobj.getNoofleavesTaken() + diffInDays));
            userleaveobj.setAvailableleave(0);

        }
        userLeaveRepository.save(userleaveobj);
        return "Ok";
    }
    public void updateLeave(userLeave userleave)
    {
        userLeaveRepository.save(userleave);
    }

    public int noofLeaves(String email)
    {
        userLeave obj = userLeaveRepository.findByEmail(email);
        return obj.getNoofleaves();

    }
    public  int Availableleave(String email)
    {
        userLeave userleave = userLeaveRepository.findByEmail(email);
        return userleave.getAvailableleave();
    }

    public int Lossofpay(String email)
    {
        userLeave userlev = userLeaveRepository.findByEmail(email);
        return userlev.getLossofPay();
    }

    public int noofleavesTaken(String email)
    {
        userLeave obj = userLeaveRepository.findByEmail(email);
        return obj.getNoofleavesTaken();
    }
    public List<Leavetracker> getHistory(String email)
    {
        List<Leavetracker> obj = leavetrackerrepository.findAllByEmail(email);
        return obj;
    }
}
