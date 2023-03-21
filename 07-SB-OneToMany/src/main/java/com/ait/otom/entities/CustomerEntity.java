package com.ait.otom.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {
	@Id
	private Integer customerId;
	
	@Column(length = 20)
	private String cutomerName;
	
	@Column(length = 25)
	private String email;
	
	/*
	 * Defines strategies for fetching data from the database.
	 * The EAGER strategy is a requirement on the persistence provider runtime
	 * that data must be eagerly fetched. 
	 * The LAZY strategy is a hint to the persistence provider runtime that 
	 * data should be fetched lazily when it is first accessed
	 */
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)    /* The default fetch type is LAZY */
	@JoinColumn(name = "CUSTOMER_ID_FK")
	private List<OrderEntity> lstOfOrdersOfCustomer;
	

}
