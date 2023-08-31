package com.infy.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infy.config.SpringConfiguration;
import com.infy.service.Calculator;
import com.infy.service.Person;
import com.infy.service.VoterService;

public class TestAop {

	public static void main(String[] args) throws InterruptedException {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
//		Calculator calc = context.getBean(Calculator.class);
//		Integer res = calc.sum(12, 17);
//		calc.Addition(10L, 15L);
		
		VoterService voterService = context.getBean(VoterService.class);
		Person ram = new Person(10, "Ram", 21, "Canada");
		voterService.doVote(ram);
	}
}
