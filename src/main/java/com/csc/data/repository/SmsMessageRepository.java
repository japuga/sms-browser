package com.csc.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csc.data.domain.SmsMessage;

public interface SmsMessageRepository extends JpaRepository<SmsMessage, Integer>{

}
