package com.traxcrm1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traxcrm1.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
