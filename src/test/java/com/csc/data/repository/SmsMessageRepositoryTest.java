package com.csc.data.repository;

import static org.junit.Assert.assertTrue;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.csc.SmsBrowserApplication;
import com.csc.data.domain.SmsMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmsBrowserApplication.class)
@WebAppConfiguration
public class SmsMessageRepositoryTest {

	@Autowired
	SmsMessageRepository smsMessageRepository;
	
	@Test
	public void saveTest(){
		SmsMessage smsMessage = new SmsMessage();
		smsMessage.setContactId(1);
		smsMessage.setContent("Hello");
		smsMessageRepository.save(smsMessage);
		
		List<SmsMessage> list = smsMessageRepository.findAll();
		assertTrue(list.get(0).getContent().equals("Hello"));
		
	}
}
