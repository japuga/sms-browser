package com.csc.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csc.data.domain.SmsMessage;
import com.csc.data.repository.SmsMessageRepository;
import com.csc.service.FakeUpload;

@Component
public class MessagesControllerHandler implements Handler {

	@Autowired
	SmsMessageRepository smsMessageRepository;
	
	
	@Override
	public void handle() {
	}

	public List<SmsMessage> findAll(){
		
		
		List<SmsMessage> messages = smsMessageRepository.findAll();
		return messages;

	}
}
