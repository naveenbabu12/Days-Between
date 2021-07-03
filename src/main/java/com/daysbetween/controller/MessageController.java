package com.daysbetween.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.daysbetween.entity.Message;
import com.daysbetween.repository.MessageRepository;
import com.daysbetween.service.DaysbetweenService;

@Controller
public class MessageController {

	@Autowired
	DaysbetweenService daysService;

	@Autowired
	MessageRepository daysRepo;
	
	
	@GetMapping("/inputdates")
	public String sendForm(Message messages) {
		return "inputDates";
	}
	
	@PostMapping("/inputdates")
	public String processForm(Message message) {
		String dateFrom = message.getInputInfo().split("\\s")[0];//splits the string based on whitespace 
		String dateTo = message.getInputInfo().split("\\s")[1];// 
		
		String formatOutput = daysService.prepareOutput(dateFrom, dateTo);
		message.setOutput("<b><u>Input: " + message.getInputInfo() + "</u></b><br /><br /> ".concat(formatOutput));
		daysRepo.save(message);

		StringBuilder history = new StringBuilder();
		daysRepo.findAll().forEach(x -> {
			history.append(x.getOutput());
			System.out.println(x.getOutput());
		});

		message.setHistory(history.toString());
		return "showDatesMessages";
	}
	
	@PostMapping("/error")
	public String processError(Message message) {
		return "showError";

	}
}
