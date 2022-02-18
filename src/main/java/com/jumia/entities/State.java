package com.jumia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name="state")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	
	private static final long serialVersionUID = -2395520086018074830L;

	@EmbeddedId
	private StatePK id;

	@NotNull(message = "State Name is mandatory")
	@Length(min = 5, max = 100, message = "State Name must be between 5 and 100 characters")	
	@Column(name="state_name")
	private String stateName;

	@Column(name="country_id", insertable=false, updatable=false)
	private long countryId;	
	
	@ManyToOne
	@JoinColumn(name="country_id", referencedColumnName="country_id", insertable=false, updatable=false)
	private Country country;
	
}