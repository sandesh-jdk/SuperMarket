package com.supermarketinfo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.supermarketinfo.Entity.RegistrationTable;
import com.supermarketinfo.repository.RegistrationRepository;

@Service
public class RegisService 
{			
		@Autowired
		private RegistrationRepository regisrepo;
		
		public Long getuserid(long uid)
		{	

			return regisrepo.getuserid(uid);
		} 
		
		public String getpassword(long uid)
		{ 
			return regisrepo.getpassword(uid);
		}
		
		public RegistrationTable save(RegistrationTable r1)
		{
			return regisrepo.save(r1);
		}
}
