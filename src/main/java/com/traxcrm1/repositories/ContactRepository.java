package com.traxcrm1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traxcrm1.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
