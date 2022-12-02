package com.ab.springboot.reto.backend.sophos.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ab.springboot.reto.backend.sophos.model.appointments;


public interface AppointmentsDao extends JpaRepository<appointments, Integer>{
	
	@Query("select a from appointments a where a.date like :var_parm order by a.affiliates.id")
	public List<appointments> getByDate(@Param("var_parm") LocalDate date);
	
	@Query("select a from appointments a where a.affiliates.id = :var_parm")
	public List<appointments> getByAffiliate(@Param("var_parm") Integer id_affiliate);
}
