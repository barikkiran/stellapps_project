package com.stellapps.assignment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStellappsAssignment {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootStellappsAssignment.class, args);

		/*
		 * OrganizationRepository organizationRepository =
		 * applicationContext.getBean(OrganizationRepository.class);
		 * 
		 * List<Employee> list = new ArrayList<>();
		 * 
		 * Organization organization = new Organization();
		 * 
		 * organization.setName("Altimetric"); organization.setLocation("Chennai");
		 * organization.setEstablishedDate(LocalDate.now());
		 * 
		 * Employee emp1 = new Employee(); emp1.setName("Kiran Barik");
		 * emp1.setDesignation("Senior Product Engineer"); emp1.setAddress("Orissa");
		 * emp1.setSalary(893930); emp1.setOrganization(organization);
		 * 
		 * Employee emp2 = new Employee(); emp2.setName("Madhuri");
		 * emp2.setDesignation("Teamlead"); emp2.setAddress("Chennai");
		 * emp2.setSalary(10893930); emp2.setOrganization(organization);
		 * 
		 * list.add(emp1); list.add(emp2);
		 * 
		 * organization.setEmployees(list);
		 * 
		 * organizationRepository.save(organization);
		 */
	}

}
