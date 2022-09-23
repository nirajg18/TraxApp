package com.traxcrm1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.traxcrm1.entities.Contact;
import com.traxcrm1.entities.Lead;
import com.traxcrm1.services.ContactService;
import com.traxcrm1.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	
	private ContactService contactService;
	
	@RequestMapping("/")
	public String viewLeadPage() {
		
		return"view_lead_page";
	}
	
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead") Lead lead, ModelMap model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertedLead(@RequestParam("id") long id, ModelMap model) {
		
		Lead lead = leadService.getLeadById(id);
		
		Contact contact = new Contact();
		
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setLeadSource(lead.getLeadSource());
		contact.setGender(lead.getGender());
		
		contactService.saveContact(contact);
		
		leadService.deleteOneLead(id);
		
		List<Contact> contacts = contactService.listAll();
		model.addAttribute("contacts", contacts);
		
		return"contact_search_result";
	}
	
	@RequestMapping("/listall")
	public String getAllLeads(ModelMap model) {
		
		List<Lead> leads = leadService.listAll();
	    model.addAttribute("leads", leads);
		return"lead_search_result";
	}
	
	@RequestMapping("/getLeadById")
	public String getLeadById(@RequestParam("id") long id,ModelMap model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead",lead);
		return "lead_info";
	}
	
		
		
	
	
	

}
