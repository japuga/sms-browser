package com.csc.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc.data.domain.SmsContact;

public interface SmsContactRepository extends JpaRepository<SmsContact, Integer>{

	public List<SmsContact> findAll();
	
	public List<SmsContact> findByFirstName(String firstName);
	
}
