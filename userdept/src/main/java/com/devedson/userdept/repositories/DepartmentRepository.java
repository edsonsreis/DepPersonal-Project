package com.devedson.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devedson.userdept.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
}
