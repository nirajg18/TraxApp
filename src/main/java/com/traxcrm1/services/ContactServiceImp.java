package com.traxcrm1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traxcrm1.entities.Contact;
import com.traxcrm1.repositories.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	public void saveContact(Contact contact) {

		contactRepo.save(contact);
	}

	@Override
	public List<Contact> listAll() {
		List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contact findContactById(long id) {
		Optional<Contact> contactBy = contactRepo.findById(id);
		Contact contact = contactBy.get();
		return contact;
	}

}
