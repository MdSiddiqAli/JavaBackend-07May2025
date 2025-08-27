package com.handson.usecase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.handson.usecase.entity.Organization;

@Repository
public interface UseCaseRepository extends JpaRepository<Organization, Long>  {
	
	Organization findByName(String name);
	
	
	Integer deleteByName(String name);

}