package com.logistics.turvo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.repository.ShipmentReposiroty;

@Service
public class ShipmentService implements IShipmentService {

	private static final Logger logger = LoggerFactory.getLogger(ShipmentService.class);
	
	@Autowired
	private ShipmentReposiroty shipmentRepository;
	
	@Autowired
	private NotificationHelper helper;
	
	@Override
	public boolean addShipment(Shipment shipment) {
		Shipment existingShipment  = shipmentRepository.findByShipmentCode(shipment.getShipmentCode());
		if(existingShipment != null){ 
			return false;
		}else{
			shipmentRepository.save(shipment);
			helper.notify(shipment);
			logger.info("New Shipment Number:"+shipment.getShipmentId());
		}
		return true;
	}

	@Override
	public boolean updateShipment(Shipment shipment) {
		Shipment existingShipment  = shipmentRepository.findByShipmentCode(shipment.getShipmentCode());
		if(existingShipment != null){ 
			if(!existingShipment.getStatus().equalsIgnoreCase(shipment.getStatus())){
				shipmentRepository.saveAndFlush(shipment);
				helper.notify(shipment);
				return true;
			}else{
				logger.info("Shipment with same status had requested for update :"+shipment.getStatus());
				return false;
			}
		}else{
			shipmentRepository.saveAndFlush(shipment);
			helper.notify(shipment);
		}
		return true;
	}
	

	@Override
	public List<Shipment> getAllShipments() {
		return shipmentRepository.findAll();
	}

	@Override
	public Shipment getShipmentById(Long id) {
		return shipmentRepository.findOne(id);
	}

	@Override
	public void deleteShipment(Long id) {
		shipmentRepository.delete(id);
	}

}
