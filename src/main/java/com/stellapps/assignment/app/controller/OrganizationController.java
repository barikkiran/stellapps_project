package com.stellapps.assignment.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stellapps.assignment.app.model.Organization;
import com.stellapps.assignment.app.service.OrganizationService;

@RestController
@RequestMapping(path = "/api/v1/organization")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	@PostMapping(path = "/create", consumes = "application/json")
	public ResponseEntity<Object> createOrganization(@RequestBody Organization organization) {

		return organizationService.saveOrganization(organization);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<Object> deleteOrganization(@PathVariable Integer id) {

		return organizationService.deleteOrganization(id);
	}

	//error on fetching organization(json problem because of infinite loop going on
	//resolve using @JsonBackReference - ManyToOne  , @JsonManageReference
	@GetMapping(path = "/get/{id}", produces = "application/json")
	public Organization getOrganizationById(@PathVariable("id") Integer id) {

		return organizationService.getOrganizationById(id);
	}

	//error on fetching organization
	//resolve
	@GetMapping(path = "/get/all", produces = "application/json")
	public List<Organization> getOrganizations() {

		return organizationService.getAllOrganizations();
	}

	@PutMapping(path = "/update/{id}", consumes = "application/json")
	public ResponseEntity<Object> updateOrganization(@PathVariable("id") Integer id,
			@RequestBody Organization organization) {

		return organizationService.updateOrganization(id, organization);
	}

}
