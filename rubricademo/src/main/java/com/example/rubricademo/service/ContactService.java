package com.example.rubricademo.service;

import java.util.List;

import com.example.rubricademo.entity.Contact;



public interface ContactService {
	List<Contact> findAll();
	
	Contact findById(int theId);
	
	void save(Contact theContact);
	
	void deleteById(int theId);
	
	List<Contact> findByFirstNameAndLastNAme(String firstName, String lastName);
}
