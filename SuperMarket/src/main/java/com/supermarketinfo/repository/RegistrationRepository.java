package com.supermarketinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.supermarketinfo.Entity.RegistrationTable;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationTable, Integer>
{
	
	@Query("select r.u_id  from RegistrationTable r where r.u_id=?1")	
	public Long getuserid(long uid);

	@Query("select r.password from RegistrationTable r where r.u_id=?1")
	public String getpassword(long uid);
	
	
}



