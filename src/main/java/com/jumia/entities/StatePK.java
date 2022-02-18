package com.jumia.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@Data
@EqualsAndHashCode(callSuper = false)
public class StatePK implements Serializable {
	
	private static final long serialVersionUID = -7900447654055874556L;

	@NotBlank(message = "Country Id is mandatory (StatePK)")
	@Digits(integer = 3, fraction = 0, message = "Country Id should not be greater then 3 digits (StatePK)")
	@Column(name="country_id")
	private long countryId;

	@NotBlank(message = "State Id is mandatory (StatePK)")
	@Max(value = 3, message = "State id should not be greater then 3 characters (StatePK)")
	@Column(name="state_id")
	private String stateId;

	public StatePK() {
	}
	
	public StatePK(long countryId, String stateId) {
		this.countryId = countryId;
		this.stateId = stateId;
	}	

}