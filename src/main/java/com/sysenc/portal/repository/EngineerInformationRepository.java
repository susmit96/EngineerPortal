package com.sysenc.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sysenc.portal.model.EngineerInformation;

@Repository
public interface EngineerInformationRepository extends JpaRepository<EngineerInformation,String>{

	@Query("SELECT ei FROM engineer_information ei WHERE ei.engineer_id=:engineerId")
	EngineerInformation findByEngineerId(@Param("engineerId")String engineerId);

//	@Query("SELECT ei FROM engineer_information ei WHERE ei.full_name LIKE :fullName% OR ei.address LIKE :address% OR ei.comment LIKE :comment%")
//	Page<EngineerInformation> findAll(@Param("fullName")String fullName, @Param("address")String address, @Param("comment")String comment,Pageable pageable);

	Page<EngineerInformation> findByFullNameOrAddressContaining(@Param("fullName")String fullName,@Param("address")String address,Pageable pageable);

}