package com.sysenc.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sysenc.portal.model.AdminLogin;

public interface LoginRepository extends JpaRepository<AdminLogin, String>{

	AdminLogin findByUserName(String userName);

}
