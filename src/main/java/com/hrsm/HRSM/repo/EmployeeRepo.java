package com.hrsm.HRSM.repo;

import com.hrsm.HRSM.entity.Employee;
import com.hrsm.HRSM.helper.EmployeeDepartmentCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, UUID>{
    Employee findByEmpId(String empId);

    @Query("SELECT COUNT(e.id) AS count, e.team AS team FROM Employee e GROUP BY e.team")
    List<EmployeeDepartmentCount> countEmployeesByAllTeams();


}
