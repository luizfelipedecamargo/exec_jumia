package com.jumia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -7236548111196830939L;

	@Id
	@Column(name="customer_id")	
	private long customerId;

	@NotNull(message = "Customer Name is mandatory")
	@Length(min = 5, max = 100, message = "Customer Name must be between 5 and 100 characters")
	@Column(name="customer_name")	
	private String customerName;

	@Length(min = 7, max = 9, message = "Customer Phone must be between 7 and 9 chacarters")
	@Column(name="customer_phone")
	private String customerPhone;

	@Column(name="country_id")	
	private long countryId;
	
	@NotNull(message = "State id is mandatory")
	@Length(min = 1, max = 3, message = "State id must be between 1 and 3 chacarters")
	@Column(name="state_id")	
	private String stateId;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="country_id", referencedColumnName="country_id", insertable=false, updatable=false),
		@JoinColumn(name="state_id", referencedColumnName="state_id", insertable=false, updatable=false)
	})
	private State state;

}