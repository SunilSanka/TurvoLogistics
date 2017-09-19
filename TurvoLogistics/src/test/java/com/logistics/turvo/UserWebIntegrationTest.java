package com.logistics.turvo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserWebIntegrationTest {

	@Test
	public void testListAll() throws IOException{
		RestTemplate restTemplate = new RestTemplate();
		
		//GET
		ResponseEntity<String> response  = restTemplate.getForEntity("http://localhost:8080/turvo/user/details", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
	
		assertThat(responseJson.isMissingNode(), is(false));
	}
	
	@Test
	public void testListOne() throws IOException{
		String url = "http://localhost:8080/turvo/user/101";
		RestTemplate restTemplate = new RestTemplate();
		
		//GET
		ResponseEntity<Users> response = restTemplate.getForEntity(url, Users.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		
		assertThat(response.getBody().getAadhar(), is("123456784321"));
		assertThat(response.getBody().getNumber(), is("+919505823652"));
		
	}
	
	@Test
	public void addUser(){
		String url = "http://localhost:8080/turvo/user/add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","SunilS");
		map.put("aadhar","111122223333");
		map.put("email","sunil.grt@gmail.com");
		map.put("number","+919505823652");
		map.put("by_Web","true");
		map.put("by_Email","false");
		map.put("by_SMS","false");
		map.put("shipment_Delivered","false");
		map.put("shipment_Created","true");
		map.put("shipment_Running_Late","false");
		map.put("shipment_Shipped","false");
		map.put("shipment_Packed","false");
	
		//POST
		ResponseEntity<Users> response = restTemplate.postForEntity(url, map,Users.class);
	
		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void addUserFail(){
		String url = "http://localhost:8080/turvo/user/add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("name","SunilS");
		map.put("aadhar","123456784321");
		map.put("email","sunil.grt@gmail.com");
		map.put("number","+919505823652");
		map.put("by_Web","true");
		map.put("by_Email","false");
		map.put("by_SMS","false");
		map.put("shipment_Delivered","false");
		map.put("shipment_Created","true");
		map.put("shipment_Running_Late","false");
		map.put("shipment_Shipped","false");
		map.put("shipment_Packed","false");
		
		//POST
		ResponseEntity<Users> response = restTemplate.postForEntity(url, map,Users.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.CONFLICT));
		
	}
	
	@Test
	public void updateUser(){
		String url = "http://localhost:8080/turvo/user/update";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "101");
		map.put("name","Sunil");
		map.put("aadhar","123456784321");
		map.put("email","");
		map.put("number","+919505823652");
		map.put("by_Web","true");
		map.put("by_Email","false");
		map.put("by_SMS","false");
		map.put("shipment_Delivered","true");
		map.put("shipment_Created","false");
		map.put("shipment_Running_Late","false");
		map.put("shipment_Shipped","false");
		map.put("shipment_Packed","false");
		
		
		//PUT
		restTemplate.put(url, map);
		
		url = "http://localhost:8080/turvo/logistics/101";
		ResponseEntity<Users> response = restTemplate.getForEntity(url, Users.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		
		assertThat(response.getBody().getEmail(), is(nullValue()));
		
		//assertThat(response.getBody().isShipment_Delivered(), is(true));
		
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void updateShipmentFail(){
		String url = "http://localhost:8080/turvo/user/update";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("userId", "102");
		map.put("name","Sunil");
		map.put("aadhar",null);
		map.put("email","sunil.grt@gmail.com");
		map.put("number","+919505823652");
		map.put("by_Web","true");
		map.put("by_Email","false");
		map.put("by_SMS","false");
		map.put("shipment_Delivered","true");
		map.put("shipment_Created","false");
		map.put("shipment_Running_Late","false");
		map.put("shipment_Shipped","false");
		map.put("shipment_Packed","false");
		
		
		//PUT
		restTemplate.put(url, map);
		
		url = "http://localhost:8080/turvo/logistics/102";
		ResponseEntity<Users> response = restTemplate.getForEntity(url, Users.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));
		
		
	}
	
	@Test
	public void deleteShipment(){
		String url = "http://localhost:8080/turvo/user/103";
		
		RestTemplate restTemplate = new RestTemplate();
		
		//DELETE
		restTemplate.delete(url);
		
		//GET
		ResponseEntity<Shipment> response = restTemplate.getForEntity(url, Shipment.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(nullValue()));
	}
	
	
}
