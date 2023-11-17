package com.SpringLeaveManagement.Repository;

import com.SpringLeaveManagement.Model.Leavetracker;
import com.SpringLeaveManagement.Model.userLeave;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface userLeaveRepository extends CrudRepository<userLeave,Integer>
{
    userLeave findByEmail(String email);

}
