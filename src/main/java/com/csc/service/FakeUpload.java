package com.csc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FakeUpload {

	String filename ="C:/allfiles/backup/sms-20161024-141132.xls";
	
	@Autowired
	SmsExcelParser smsExcelParser;
	
	public void upload(){
		smsExcelParser.parseFile(filename);
	}
}
