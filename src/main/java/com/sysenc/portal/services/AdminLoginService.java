package com.sysenc.portal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sysenc.portal.SysencUserPrincipal;
import com.sysenc.portal.model.AdminLogin;
import com.sysenc.portal.repository.LoginRepository;

@Service
public class AdminLoginService  implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminLogin adminLogin = loginRepository.findByUserName(username);
		if(null==adminLogin) {
			throw new UsernameNotFoundException(adminLogin+"ユーザーが存在しません");
		}
		return new SysencUserPrincipal(adminLogin);
	}


}
