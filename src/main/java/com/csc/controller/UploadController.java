package com.csc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.service.FakeUpload;

@Controller
public class UploadController {


	@Autowired
	FakeUpload fakeUpload;
	
	
	@RequestMapping(path="/upload")
	public String upload(){
		fakeUpload.upload();
		return "index";
	}
	
	//@RequestMapping(path="/upload")
	public String uploadScreen(){
		return "upload";
	}
}
