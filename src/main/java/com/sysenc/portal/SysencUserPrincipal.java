package com.sysenc.portal;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sysenc.portal.model.AdminLogin;

public class SysencUserPrincipal implements UserDetails{

	private AdminLogin adminLogin;

	public SysencUserPrincipal(AdminLogin adminLogin) {
		super();
		this.adminLogin = adminLogin;
	}

	@Override
	public Collection<?extends GrantedAuthority> getAuthorities(){
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return this.adminLogin.getPassword();
	}

	@Override
	public String getUsername() {
		return this.adminLogin.getUserName();
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
