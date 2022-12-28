package com.te.ecommerce.ecommercebase.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(uniqueConstraints =@UniqueConstraint(columnNames = "email"))
@Entity
public class User {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer  userId;
	@Column (unique = true,nullable = false)
	private String username;
	@Email
	@Column (unique = true,nullable = false)
	private String  emailId;
	@Column(length = 8)
	@NotEmpty
	private String  password;
//	private boolean enabled;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn(referencedColumnName = "userId",name = "user_id"),
	inverseJoinColumns = @JoinColumn(referencedColumnName = "roleId",name = "role_id"))
	private List<Role>roles=Lists.newArrayList();
	
	

  
}
