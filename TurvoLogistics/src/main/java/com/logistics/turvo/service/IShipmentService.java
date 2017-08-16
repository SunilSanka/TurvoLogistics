package com.logistics.turvo.service;


import java.util.List;

import com.logistics.turvo.model.Shipment;

public interface IShipmentService {

	boolean addShipment(Shipment shipment);

	boolean updateShipment(Shipment shipment);

	List<Shipment> getAllShipments();

	Shipment getShipmentById(Long id);

	void deleteShipment(Long id);

}
