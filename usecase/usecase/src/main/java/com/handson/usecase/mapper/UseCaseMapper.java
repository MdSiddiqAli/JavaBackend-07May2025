package com.handson.usecase.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.handson.usecase.dto.OrganizationDTO;
import com.handson.usecase.entity.Organization;

@Mapper(componentModel = "spring")
public interface UseCaseMapper {
	@Mapping(source="name",target = "name")
	@Mapping(source="employee",target = "employee")
	Organization convertDtoToEntity(OrganizationDTO organizationDTO);
	
	OrganizationDTO convertEntityToDto(Organization organization);
	
	List<OrganizationDTO> convertListOfEntitiesToDtos(List<Organization> iterable);

}
