package com.unkownkoder.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="roles")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

    public Role(String string) {
		// TODO Auto-generated constructor stub
    	this.authority = string;
	}

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="role_id")
    private Integer roleId;

    private String authority;

   
}
