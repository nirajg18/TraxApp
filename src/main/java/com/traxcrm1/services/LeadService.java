package com.traxcrm1.services;

import java.util.List;

import com.traxcrm1.entities.Lead;

public interface LeadService {

	public void saveLead(Lead lead);

	public Lead getLeadById(long id);

	public void deleteOneLead(long id);

	public List<Lead> listAll();


}
