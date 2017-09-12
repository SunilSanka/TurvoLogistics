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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ShipmentWebIntegrationTest {

	@Test
	public void testListAll() throws IOException{
		RestTemplate restTemplate = new RestTemplate();
		
		//GET
		ResponseEntity<String> response  = restTemplate.getForEntity("http://localhost:8080/turvo/logistics/details", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
	
		assertThat(responseJson.isMissingNode(), is(false));
	}
	
	@Test
	public void testListOne() throws IOException{
		String url = "http://localhost:8080/turvo/logistics/101";
		RestTemplate restTemplate = new RestTemplate();
		
		//GET
		ResponseEntity<Shipment> response = restTemplate.getForEntity(url, Shipment.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		
		assertThat(response.getBody().getShipmentCode(), is(10010L));
		assertThat(response.getBody().getShipmentMethod(), is("Air"));
		
	}
	
	@Test
	public void addShipment(){
		String url = "http://localhost:8080/turvo/logistics/add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("shipmentCode","12021");
		map.put("title","Spring Boot Getting Started - Part 3s");
		map.put("shipmentMethod","Water");
		map.put("fromAddress","address1");
		map.put("toAddress","address2");
		map.put("expectedDate","2017-08-11");
		map.put("status","Created");
		map.put("message","Have a nice day !");
		
		//POST
		ResponseEntity<Shipment> response = restTemplate.postForEntity(url, map,Shipment.class);
	
		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void addShipmentFail(){
		String url = "http://localhost:8080/turvo/logistics/add";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("shipmentCode","10010");
		map.put("title","Spring Boot Getting Started - Part 2");
		map.put("shipmentMethod","Water");
		map.put("fromAddress","address1");
		map.put("toAddress","address2");
		map.put("expectedDate","2017-08-11");
		map.put("status","Packed");
		map.put("message","Have a nice day !");
		
		//POST
		ResponseEntity<Shipment> response = restTemplate.postForEntity(url, map,Shipment.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.CONFLICT));
		
	}
	
	@Test
	public void updateShipment(){
		String url = "http://localhost:8080/turvo/logistics/update";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("shipmentId","103");
		map.put("shipmentCode","10012");
		map.put("title","Spring Boot Getting Started - Part 2");
		map.put("shipmentMethod","Water");
		map.put("fromAddress","address1");
		map.put("toAddress","address2");
		map.put("expectedDate","2017-08-11");
		map.put("status","Delivered");
		map.put("message","Have a nice day !");
		
		//PUT
		restTemplate.put(url, map);
		
		url = "http://localhost:8080/turvo/logistics/103";
		ResponseEntity<Shipment> response = restTemplate.getForEntity(url, Shipment.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		
		assertThat(response.getBody().getShipmentCode(), is(10012L));
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void updateShipmentFail(){
		String url = "http://localhost:8080/turvo/logistics/update";
		RestTemplate restTemplate = new RestTemplate();
		Map<String,String> map = new HashMap<String,String>();
		map.put("shipmentId","104");
		map.put("shipmentCode","10013");
		map.put("title","Spring Boot Getting Started - Part 2");
		map.put("shipmentMethod","Water");
		map.put("fromAddress","address1");
		map.put("toAddress","address2");
		map.put("expectedDate","2017-08-11");
		map.put("status","Shipped");
		map.put("message","Have a nice day !");
		
		//PUT
		restTemplate.put(url, map);
		
		url = "http://localhost:8080/turvo/logistics/102";
		ResponseEntity<Shipment> response = restTemplate.getForEntity(url, Shipment.class);
		
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		
		assertThat(response.getBody().getShipmentCode(), is(10011));
	}
	
	@Test
	public void deleteShipment(){
		String url = "http://localhost:8080/turvo/logistics/101";
		
		RestTemplate restTemplate = new RestTemplate();
		
		//DELETE
		restTemplate.delete(url);
		
		//GET
		ResponseEntity<Shipment> response = restTemplate.getForEntity(url, Shipment.class);
		assertThat(response.getStatusCode(), is(HttpStatus.OK));
		assertThat(response.getBody(), is(nullValue()));
	}
	
	
}
