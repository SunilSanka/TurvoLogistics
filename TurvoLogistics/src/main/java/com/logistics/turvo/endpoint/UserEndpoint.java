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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logistics.turvo.model.Users;
import com.logistics.turvo.service.IUserService;

@Component
@Path("/user")
public class UserEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(UserEndpoint.class);
	
	@Autowired
	private IUserService userService;
	
	@GET
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserDetails(){
		List<Users> list = userService.getAllUsers();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") Long id) {
		Users user = userService.getUserById(id);
		return Response.ok(user).build();
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(Users user){
			boolean isAdded = userService.addUser(user);
			if(!isAdded){
				logger.info("User Already exists !");
				return Response.status(Status.CONFLICT).build();
			}
		return Response.created(URI.create("/sping-app/users")).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(Users user){
		boolean isupdated = userService.updateUser(user);
			if(!isupdated){
				logger.info("User details are not valid !");
				return Response.status(Status.BAD_REQUEST).build();
			}
			return Response.ok(user).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") Long id){
		userService.deleteUser(id);
		return Response.noContent().build();
	}
}
