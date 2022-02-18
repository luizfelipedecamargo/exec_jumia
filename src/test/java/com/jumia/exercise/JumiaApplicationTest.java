package com.jumia.exercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jumia.controllers.CountryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JumiaApplicationTest {

	@Autowired
	private CountryController countryController;

	@Test
	public void contextLoads() {
		Assertions.assertThat(countryController).isNotNull();
	}

}
