package com.handson.usecase.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handson.usecase.dto.OrganizationDTO;
import com.handson.usecase.entity.Organization;
import com.handson.usecase.mapper.UseCaseMapper;
import com.handson.usecase.repository.UseCaseRepository;

@Service
public class UseCaseService {
	
	@Autowired
	UseCaseRepository useCaseRepository;
	
	@Autowired
	UseCaseMapper useCaseMapper;
	
	public OrganizationDTO save(OrganizationDTO organizationDTO) {
		return useCaseMapper
				.convertEntityToDto(useCaseRepository.save(useCaseMapper.convertDtoToEntity(organizationDTO)));
	}
	
	public OrganizationDTO getByOrgName(String orgName) {
		return useCaseMapper
				.convertEntityToDto(useCaseRepository.findByName(orgName));
	}

	public OrganizationDTO update(OrganizationDTO organizationDTO) {
		Long id = Optional.ofNullable(useCaseRepository.findByName(organizationDTO.getName()))
			.map(Organization::getId).orElse(null);
		if(null != id) {
			Organization organization = useCaseMapper.convertDtoToEntity(organizationDTO);
			organization.setId(id);
			return useCaseMapper
					.convertEntityToDto(useCaseRepository.save(organization));
		}
		return null;
	}
	
	@Transactional
	public OrganizationDTO deleteByOrgName(String orgName) {
		Organization organization = Optional.ofNullable(useCaseRepository.findByName(orgName))
					     .orElse(null);
		if(null != organization) {
			useCaseRepository.deleteByName(orgName);
			return useCaseMapper
					.convertEntityToDto(organization);
		}
		return null;
	}
	
}
