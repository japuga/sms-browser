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
import com.csc.data.domain.PhoneNumber;
import com.csc.data.domain.SmsContact;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmsBrowserApplication.class)
@WebAppConfiguration
public class SmsContactRepositoryTest {

	@Autowired
	private SmsContactRepository smsContactRepository;
	
	
	@Test
	public void test(){
		List<SmsContact> list = smsContactRepository.findAll();
		assertTrue(list.size()>0);
			
	}
	
	@Test
	public void findByFirstNameTest(){
		List<SmsContact> list = smsContactRepository.findByFirstName("Javier");
		SmsContact contact = list.get(0);
		for(PhoneNumber phoneNumber : contact.getPhoneNumbers()){
			System.out.println(phoneNumber.getPk().getPhoneNumber());
		}
	}
}
