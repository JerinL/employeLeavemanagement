package com.SpringLeaveManagement.Repository;

import com.SpringLeaveManagement.Model.UserEmployee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employerepository extends CrudRepository<UserEmployee,Integer> {

    UserEmployee findByEmail(String email);
}
