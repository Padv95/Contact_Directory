package com.example.rubricademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rubricademo.dao.ContactRepository;
import com.example.rubricademo.entity.Contact;


@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactRepository contactRepository;
	
	
	@Autowired
	public ContactServiceImpl(ContactRepository theContactRepository) {
		this.contactRepository = theContactRepository;
	}
	
	
	@Override
	public List<Contact> findAll() {
		return contactRepository.findAllByOrderByFirstNameAsc();
	}
	
	@Override
	public void save(Contact theContact) {
		contactRepository.save(theContact);
	}

	@Override
	public void deleteById(int theId) {
		contactRepository.deleteById(theId);
	}
	
	@Override
	public Contact findById(int theId) {
		Optional<Contact> result = contactRepository.findById(theId);
		
		Contact theContact = null;
		
		if (result.isPresent()) {
			theContact = result.get();
		}
		else {
			// we didn't find the contact
			throw new RuntimeException("Did not find contact id - " + theId);
		}
		
		return theContact;
	}


	@Override
	public List<Contact> findByFirstNameAndLastNAme(String firstName, String lastName) {
		return contactRepository.findByFirstNameAndLastName(firstName, lastName);
	}


	
}
