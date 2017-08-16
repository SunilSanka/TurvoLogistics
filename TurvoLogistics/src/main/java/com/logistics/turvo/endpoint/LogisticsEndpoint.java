package com.logistics.turvo.endpoint;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

import com.logistics.turvo.model.Shipment;
import com.logistics.turvo.service.IShipmentService;

@Component
@Path("/logistics")
public class LogisticsEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(LogisticsEndpoint.class);
	
	@Autowired
	private IShipmentService shipmentService;
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShipmentDetails(){
		List<Shipment> list = shipmentService.getAllShipments();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShipment(@PathParam("id") Long id) {
		Shipment  shipment = shipmentService.getShipmentById(id);
		return Response.ok(shipment).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShipment(Shipment shipment){
			boolean isAdded = shipmentService.addShipment(shipment);
			if(!isAdded){
				logger.info("Shipment Already exists !");
				return Response.status(Status.CONFLICT).build();
			}
		return Response.created(URI.create("/sping-app/logistics")).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateShipment(Shipment shipment){
		boolean isUpdated = shipmentService.updateShipment(shipment);
		if(!isUpdated){
			logger.info("Shipment Status has not changed !");
			return Response.status(Status.BAD_REQUEST).build();
		}
			return Response.ok(shipment).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteShipment(@PathParam("id") Long id){
		shipmentService.deleteShipment(id);
		return Response.noContent().build();
	}
	
}
