package com.ait.otom.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
	@Id
	private Integer orderId;
	
	private LocalDate orderDate;
	
	@Column(length = 30)
	private String status;

}
