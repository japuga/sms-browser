package com.csc.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.csc.SmsBrowserApplication;
import com.csc.data.domain.SmsMessage;
import com.csc.data.repository.SmsMessageRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SmsBrowserApplication.class)
@WebAppConfiguration
public class SmsExcelParserTest {

	String filename ="C:/allfiles/backup/sms-20161024-141132.xls";
	
	@Autowired
	SmsExcelParser smsExcelParser;
	
	@Autowired
	SmsMessageRepository smsMessageRepository;
	
	@Before
	public void setup(){
	
	}
	
	@Test
	public void openFileTest(){
	
		Workbook wb = smsExcelParser.openFile(filename);
		org.junit.Assert.assertTrue("Sheet1".equalsIgnoreCase(wb.getSheetName(0)));
		
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void validateHeaderColumnsTest(){
		
	}
	
	@Test
	public void parseFileTest(){
		smsExcelParser.parseFile(filename);
		List<SmsMessage> list = smsMessageRepository.findAll();
		for(SmsMessage smsMessage : list){
			System.out.println("From:" +smsMessage.getSenderName());
			System.out.println(("Message:" +smsMessage.getContent()));
		}
	}
}
