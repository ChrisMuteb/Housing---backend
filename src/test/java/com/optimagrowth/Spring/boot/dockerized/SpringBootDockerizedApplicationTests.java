package com.optimagrowth.Spring.boot.dockerized;

import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootDockerizedApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void givenValidHousingLocationRequest_thenExpectedValueReturnedValue(){
		String name = "Lasuperbe.ltd";
		String city = "Paris";
		String state = "France";
		String photo = "chris.jpg";
		Integer availableUnits = 3;
		Boolean wifi = true;
		Boolean laundry = true;

		HousingLocationRequest housingLocationRequest = new HousingLocationRequest(1L, name, city, state, photo, availableUnits, wifi, laundry);
		HousingLocationRequest housingLocationRequest2 = new HousingLocationRequest(2L,name, city, state, photo, availableUnits, wifi, laundry);


		assertEquals(name, housingLocationRequest.name());
		assertEquals(housingLocationRequest, housingLocationRequest2);
	}

}
