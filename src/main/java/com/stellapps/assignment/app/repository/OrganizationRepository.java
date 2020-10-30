package com.stellapps.assignment.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stellapps.assignment.app.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer>{

}
