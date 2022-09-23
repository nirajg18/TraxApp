package com.traxcrm1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traxcrm1.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}
