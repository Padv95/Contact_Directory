package com.example.rubricademo.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rubricademo.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
		public List<Contact> findAllByOrderByFirstNameAsc();
		
		public List<Contact> findByFirstNameAndLastName(String firstName, String lastName);
}
