package com.logistics.turvo;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.repository.ShipmentReposiroty;
import com.logistics.turvo.service.NotificationHelper;
import com.logistics.turvo.service.ShipmentService;


public class ShipmentServiceTest{
	
	@InjectMocks
	private ShipmentService shipmentService; 
	
	@Mock
	private ShipmentReposiroty shipmentRepo;
	
	@Mock
	private NotificationHelper helper;

		

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipmentGetOne(){
		
		Shipment shipmentMock = new Shipment();
		shipmentMock.setShipmentId(100L);
		shipmentMock.setShipmentCode(10010L);
			
		when(shipmentRepo.findOne(100L)).thenReturn(shipmentMock);
				
		Shipment shipment = shipmentService.getShipmentById(100L);
		verify(shipmentRepo).findOne(100L);
				
		assertThat(shipment.getShipmentId(), is(100L));
		
	}
	
	@Test
	public void testShipmentGetAll(){
		
		Shipment shipmentMock1 = new Shipment();
		shipmentMock1.setShipmentId(100L);
		shipmentMock1.setShipmentCode(10010L);
	

		
		Shipment shipmentMock2 = new Shipment();
		shipmentMock2.setShipmentId(200L);
		shipmentMock2.setShipmentCode(10020L);
		

	
		List<Shipment> shipmentList = new ArrayList<>();
		shipmentList.add(shipmentMock1);
		shipmentList.add(shipmentMock2);

		when(shipmentRepo.findAll()).thenReturn(shipmentList);
		
		
		List<Shipment> shipmentReturnList = shipmentService.getAllShipments();
		verify(shipmentRepo).findAll();
		
		assertThat(shipmentReturnList.size(), is(2));
		
	}
	
	@Test
	public void testShipmentSave(){
		
		Shipment shipmentMock = new Shipment();
		shipmentMock.setShipmentId(100L);
		shipmentMock.setShipmentCode(10010L);
		
		when(shipmentRepo.save(shipmentMock)).thenReturn(shipmentMock);
		
		boolean shipmentAdded = shipmentService.addShipment(shipmentMock);
		
		verify(shipmentRepo).save(shipmentMock);
		verify(shipmentRepo).findByShipmentCode(10010L);
		
		assertThat(shipmentAdded, is(true));
 }
	
	@Test
	public void testShipmentUpdate(){
		
		Shipment shipmentMock = new Shipment();
		shipmentMock.setShipmentId(100L);
		shipmentMock.setShipmentCode(10010L);
	
		when(shipmentRepo.saveAndFlush(shipmentMock)).thenReturn(shipmentMock);
		
		
		boolean shipmentAdded = shipmentService.updateShipment(shipmentMock);
		verify(shipmentRepo).saveAndFlush(shipmentMock);
				
		assertThat(shipmentAdded, is(true));
		
	}
	
	@Test
	public void testShipmentDelete(){
		
		doNothing().when(shipmentRepo).delete(100L);
			
		shipmentService.deleteShipment(100L);
		
		verify(shipmentRepo).delete(100L);
				
	}
	
}
