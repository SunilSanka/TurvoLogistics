package com.logistics.turvo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.repository.ShipmentReposiroty;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShipmentRepositoryIntegrationTest {

	@Autowired
	private ShipmentReposiroty shipmentRepository;
	
	
	
	@Test
	public void findShipments(){
		List<Shipment> shipmetList = shipmentRepository.findAll();
		assertThat(shipmetList.size(), is(greaterThan(0)));
	}
	
	@Test
	public void findShipmentById(){
		Shipment shipment = shipmentRepository.findOne(101L);
		assertThat(shipment.getShipmentCode(), is(10010L));
	}
	
	
	@Test(expected=DataIntegrityViolationException.class)
	public void addShipmentFalied(){
		Shipment shipment = new Shipment();
		shipment.setShipmentId(100L);
		shipment.setShipmentCode(10010L);
		shipment.setTitle("Documents");
		shipment.setShipmentMethod("Air");
		shipment.setFromAddress("address 1");
		shipment.setToAddress("address 2");
		shipment.setExpectedDate("2017-8-16");
		shipment.setStatus("Created");
		shipment.setMessage("Test Message");
		
		Shipment savedShipment = shipmentRepository.save(shipment);
		assertThat(savedShipment, null);
		
	}
	
	@Test
	public void addShipment(){
		Shipment shipment = new Shipment();
		shipment.setShipmentCode(40010L);
		shipment.setTitle("Test Title");
		shipment.setShipmentMethod("Air");
		shipment.setFromAddress("address 1");
		shipment.setToAddress("address 2");
		shipment.setExpectedDate("2017-8-16");
		shipment.setStatus("Created");
		shipment.setMessage("Test Message");
		
		Shipment savedShipment = shipmentRepository.save(shipment);
		assertThat(savedShipment.getShipmentId(), is(105L));
		
	}
	
	@Test
	public void findByCodeShipment(){
		Shipment savedShipment = shipmentRepository.findByShipmentCode(10010L);
		assertThat(savedShipment.getShipmentId(), is(101L));
	}

	@Test(expected=NullPointerException.class)
	public void findByCodeShipmentFail(){
		Shipment savedShipment = shipmentRepository.findByShipmentCode(20010L);
		assertThat(savedShipment.getShipmentId(), null);
	}

	@Test(expected=NullPointerException.class)
	public void deleteShipment(){
		Shipment savedShipment1 = shipmentRepository.findByShipmentCode(10010L);
		assertThat(savedShipment1.getShipmentId(), is(101L));
		shipmentRepository.delete(101L);
		Shipment savedShipment2 = shipmentRepository.findByShipmentCode(10010L);
		assertThat(savedShipment2.getShipmentId(), null);
	}
}
