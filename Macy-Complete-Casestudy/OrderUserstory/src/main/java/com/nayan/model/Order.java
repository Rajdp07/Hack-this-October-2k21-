package com.nayan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prfOrder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("deprecation")
public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "Order Id mus'nt be blank")
	@Column(name = "orderId")
	private long orderId;
	@NotNull(message = "Order Number mus'nt be blank")
	@Column(name = "orderNumber")
	private long orderNumber;
	@NotBlank(message = "Order Type mus'nt be blank")
	@Column(name = "orderType")
	private String orderType;
	@Column(name = "profileType")
	private String profileType;

	public Order(long orderId, long orderNumber, String orderType) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderType = orderType;
	}

}
