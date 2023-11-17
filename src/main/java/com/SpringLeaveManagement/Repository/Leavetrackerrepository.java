package com.SpringLeaveManagement.Repository;

import com.SpringLeaveManagement.Model.Leavetracker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Leavetrackerrepository extends CrudRepository<Leavetracker,Integer>
{

    List<Leavetracker> findByEmail(String email);

    List<Leavetracker> findAllByEmail(String email);
}
