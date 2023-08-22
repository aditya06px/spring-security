package com.unkownkoder.configuration;

import java.io.IOException;
import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

		if (roles.contains("ROLE_JOBSEEKER")) {
			System.out.println("user has role of jobseeker");
			response.sendRedirect("/admin/");
		} else if (roles.contains("ROLE_TEACHER")) {
			response.sendRedirect("/teacher/");
		} else {
			System.out.println("inside elsssss part");
			response.sendRedirect("/user/");
		}

	}

}
