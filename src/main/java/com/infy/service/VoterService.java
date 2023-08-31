package com.infy.service;

import org.springframework.stereotype.Component;

import com.infy.exception.InvalidVoterException;

@Component
public class VoterService {

	public void doVote(Person person) {
		
		if(isValidVoter(person)) {
			System.out.println(person.getName()+ " is valid to do the vote..!!!");
		}
		else
			System.out.println("Not allowed to vote..!!");
	}

	private boolean isValidVoter(Person person) {
		boolean result = false;
		
		if(person.age >= 18) {
			if(person.getCountry().equalsIgnoreCase("INDIA"))
			result = true;
			else 
				throw new InvalidVoterException("Country is not valid..!!");
		}
		else {
			throw new InvalidVoterException("Age is not valid..!!");
		}
		return result;
	}
}
