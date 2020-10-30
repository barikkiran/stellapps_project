package com.stellapps.assignment.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stellapps.assignment.app.model.Employee;
import com.stellapps.assignment.app.model.Organization;
import com.stellapps.assignment.app.repository.EmployeeRepository;
import com.stellapps.assignment.app.repository.OrganizationRepository;
import com.stellapps.assignment.app.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Object> saveOrganization(Organization organization) {

		List<Employee> employees = null;
		Organization org = new Organization();

		org.setName(organization.getName());
		org.setLocation(organization.getLocation());
		org.setEstablishedDate(organization.getEstablishedDate());

		employees = organization.getEmployees();

		for (Employee employee : employees)
			employee.setOrganization(org);

		org.setEmployees(employees);

		Organization org2 = organizationRepository.save(org);

		if (organizationRepository.findById(org2.getId()).isPresent())
			return ResponseEntity.ok().body("Organization saved successfully...");

		return ResponseEntity.unprocessableEntity().body("Falied to save organization...");
	}

	@Override
	public ResponseEntity<Object> deleteOrganization(Integer id) {

		if (organizationRepository.findById(id).isPresent()) {

			organizationRepository.deleteById(id);

			if (organizationRepository.findById(id).isPresent())
				return ResponseEntity.unprocessableEntity().body("Failed to delete the given organization");

			else
				return ResponseEntity.ok().body("Successfully deleted the given organization");
		}

		else
			return ResponseEntity.unprocessableEntity().body("No organization found for the given id " + id);
	}

	@Override
	public Organization getOrganizationById(Integer id) {

		if (id != null) {

			if (organizationRepository.findById(id).isPresent())

				return organizationRepository.findById(id).get();
			else
				return null;
		}

		return null;
	}

	@Override
	public List<Organization> getAllOrganizations() {

		return organizationRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> updateOrganization(Integer id, Organization organization) {

		if (organizationRepository.findById(id).isPresent()) {

			Organization org = organizationRepository.findById(id).get();

			org.setName(organization.getName());
			org.setLocation(organization.getLocation());
			org.setEstablishedDate(organization.getEstablishedDate());

			Organization updatedOrganization = organizationRepository.save(org);

			List<Employee> oldEmployees = org.getEmployees();

			List<Employee> newEmployees = organization.getEmployees();

			for (int i = 0; i < newEmployees.size(); i++) {

				oldEmployees.get(i).setName(newEmployees.get(i).getName());
				oldEmployees.get(i).setDesignation(newEmployees.get(i).getDesignation());
				oldEmployees.get(i).setAddress(newEmployees.get(i).getAddress());
				oldEmployees.get(i).setSalary(newEmployees.get(i).getSalary());
				oldEmployees.get(i).setOrganization(updatedOrganization);

				employeeRepository.save(oldEmployees.get(i));
			}

			
			

			// org.getEmployees().addAll(oldEmployees);

			if (organizationRepository.findById(updatedOrganization.getId()).isPresent())
				return ResponseEntity.ok().body("Successfully updated the organization");
			else
				return ResponseEntity.unprocessableEntity().body("Failed to update given organization");

		}

		else

			return ResponseEntity.unprocessableEntity().body("Given Organization id is not found");
	}

}
