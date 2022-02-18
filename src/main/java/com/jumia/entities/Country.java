package com.jumia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	
	private static final long serialVersionUID = -5015916854896820834L;

	@Id
	@Column(name="country_id")
	private long countryId;

	@NotNull(message = "Country Name is mandatory")
	@Length(min = 5, max = 100, message = "Country Name must be between 5 and 100 characters")	
	@Column(name="country_name")
	private String countryName;

}