package com.stellapps.assignment.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.stellapps.assignment.app.model.Organization;

public interface OrganizationService {

	
   ResponseEntity<Object> saveOrganization(Organization organization);
   
   ResponseEntity<Object> deleteOrganization(Integer id);
   
   Organization getOrganizationById(Integer id);
   
   List<Organization> getAllOrganizations();
   
   ResponseEntity<Object> updateOrganization(Integer id,Organization organization);
   
   
   
	
}
