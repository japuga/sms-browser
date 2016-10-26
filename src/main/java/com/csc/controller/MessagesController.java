package com.csc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csc.data.domain.SmsMessage;
import com.csc.handler.MessagesControllerHandler;

@Controller
public class MessagesController {
	
	@Autowired
	MessagesControllerHandler messagesControllerHandler;
	
	@RequestMapping(path="/messages")
	public String findAllMessages(Model model){
		List<SmsMessage> messages = messagesControllerHandler.findAll();
		model.addAttribute("messages", messages);
		return "messages";
	}
}
