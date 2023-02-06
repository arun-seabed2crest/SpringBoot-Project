package com.Springboot.Springboot.doa;

import com.Springboot.Springboot.Entity.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<EmployeeDTO, Long> {
}
