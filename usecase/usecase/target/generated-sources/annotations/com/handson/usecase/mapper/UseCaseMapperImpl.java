package com.handson.usecase.mapper;

import com.handson.usecase.dto.AssetDTO;
import com.handson.usecase.dto.EmployeeDTO;
import com.handson.usecase.dto.OrganizationDTO;
import com.handson.usecase.entity.Asset;
import com.handson.usecase.entity.Employee;
import com.handson.usecase.entity.Organization;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-27T14:38:19+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.34.0.v20230523-1233, environment: Java 17.0.7 (Eclipse Adoptium)"
)
@Component
public class UseCaseMapperImpl implements UseCaseMapper {

    @Override
    public Organization convertDtoToEntity(OrganizationDTO organizationDTO) {
        if ( organizationDTO == null ) {
            return null;
        }

        Organization organization = new Organization();

        organization.setName( organizationDTO.getName() );
        organization.setEmployee( employeeDTOToEmployee( organizationDTO.getEmployee() ) );

        return organization;
    }

    @Override
    public OrganizationDTO convertEntityToDto(Organization organization) {
        if ( organization == null ) {
            return null;
        }

        OrganizationDTO organizationDTO = new OrganizationDTO();

        organizationDTO.setName( organization.getName() );
        organizationDTO.setEmployee( employeeToEmployeeDTO( organization.getEmployee() ) );

        return organizationDTO;
    }

    @Override
    public List<OrganizationDTO> convertListOfEntitiesToDtos(List<Organization> iterable) {
        if ( iterable == null ) {
            return null;
        }

        List<OrganizationDTO> list = new ArrayList<OrganizationDTO>( iterable.size() );
        for ( Organization organization : iterable ) {
            list.add( convertEntityToDto( organization ) );
        }

        return list;
    }

    protected Asset assetDTOToAsset(AssetDTO assetDTO) {
        if ( assetDTO == null ) {
            return null;
        }

        Asset asset = new Asset();

        asset.setAssetNumber( assetDTO.getAssetNumber() );
        asset.setName( assetDTO.getName() );

        return asset;
    }

    protected Set<Asset> assetDTOSetToAssetSet(Set<AssetDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Asset> set1 = new HashSet<Asset>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AssetDTO assetDTO : set ) {
            set1.add( assetDTOToAsset( assetDTO ) );
        }

        return set1;
    }

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setEmpId( employeeDTO.getEmpId() );
        employee.setName( employeeDTO.getName() );
        employee.setAssets( assetDTOSetToAssetSet( employeeDTO.getAssets() ) );

        return employee;
    }

    protected AssetDTO assetToAssetDTO(Asset asset) {
        if ( asset == null ) {
            return null;
        }

        AssetDTO assetDTO = new AssetDTO();

        assetDTO.setAssetNumber( asset.getAssetNumber() );
        assetDTO.setName( asset.getName() );

        return assetDTO;
    }

    protected Set<AssetDTO> assetSetToAssetDTOSet(Set<Asset> set) {
        if ( set == null ) {
            return null;
        }

        Set<AssetDTO> set1 = new HashSet<AssetDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Asset asset : set ) {
            set1.add( assetToAssetDTO( asset ) );
        }

        return set1;
    }

    protected EmployeeDTO employeeToEmployeeDTO(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmpId( employee.getEmpId() );
        employeeDTO.setName( employee.getName() );
        employeeDTO.setAssets( assetSetToAssetDTOSet( employee.getAssets() ) );

        return employeeDTO;
    }
}
