package com.unkownkoder.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unkownkoder.models.ApplicationUser;
import com.unkownkoder.models.Role;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Integer> {
	Optional<ApplicationUser> findByUsername(String username);
//	 List<ApplicationUser> findByAuthoritiesAuthority(String roleAuthority);
	 List<ApplicationUser> findByAuthoritiesAuthority(Role authority);
}
