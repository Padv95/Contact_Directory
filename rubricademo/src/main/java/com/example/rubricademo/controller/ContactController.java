package com.example.rubricademo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.rubricademo.entity.Contact;
import com.example.rubricademo.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
private ContactService contactService;

	
	@Autowired
	public ContactController(ContactService theContactService) {
		this.contactService = theContactService;
	}



	@GetMapping("/list")
	public String listContacts(Model theModel) {
		
		List<Contact> theContacts = contactService.findAll();
		
		// add to the spring model
		theModel.addAttribute("contacts", theContacts); 

		return "contacts/list-contacts";
	}
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		
		Contact theContact = new Contact();
		
		// add to the spring model
		theModel.addAttribute("contact", theContact);

		return "contacts/contact-form";
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactId") int theId, Model theModel) {
		
		Contact theContact = contactService.findById(theId);
		
		theModel.addAttribute("contact", theContact);

		return "contacts/contact-form";
	}
	
	@GetMapping("/showFormForSearch")
	public String showFormForSearch(Model theModel){
		
		Contact theContact = new Contact();

		theModel.addAttribute("contact1", theContact);
		
		return "contacts/search-form";
	}
	
	@GetMapping("/showFormForSearch2")
	public String showFormForSearch2(Model theModel){
		
		Contact theContact = new Contact();
		
		theModel.addAttribute("contact2", theContact);
		
		return "contacts/search-form2";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("contactId") int theId) {
		
		contactService.deleteById(theId);
		

		return "redirect:/contacts/list";
	}
	
	@PostMapping("/save")
	public String saveContact(@ModelAttribute("contact") Contact theContact) {
		
		contactService.save(theContact);
		
		return "redirect:/contacts/list";
	}
	
	@GetMapping("/find")
	public String findContact(@ModelAttribute("contact1") Contact theContact, Model theModel) {
		
		
		
		Contact singleContact = contactService.findById(theContact.getId().intValue());
		
		theModel.addAttribute("contact1", singleContact);
		
		return "contacts/single-contact";
	}
	
	@GetMapping("/find2")
	public String findContact2(@ModelAttribute("contact2") Contact theContact, Model theModel) {
		
		List<Contact> theContacts = contactService.findByFirstNameAndLastNAme(theContact.getFirstName(), theContact.getLastName());
		
		// add to the spring model
		theModel.addAttribute("contacts2", theContacts); 
		
		return "contacts/foundbynamecontact";
	}

}
