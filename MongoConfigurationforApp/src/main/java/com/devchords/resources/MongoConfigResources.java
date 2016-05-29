package com.devchords.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.bson.Document;

import com.devchords.logic.MongoConfigLogic;
import com.devchords.model.MongoConfigAppProperty;

@Path("/mongoconfig")
@Produces(MediaType.APPLICATION_JSON)
public class MongoConfigResources {
	

	
	@GET
	public List<MongoConfigAppProperty> getAllData() {
		
		return MongoConfigLogic.getAll();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postData(MongoConfigAppProperty property) {
		
		
		boolean status = MongoConfigLogic.checkValidityandSave(property);
		if(status==true){
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.BAD_REQUEST).build();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateData(MongoConfigAppProperty property) {
		
		System.out.println("prop is "+property.getDescription());
		boolean status = MongoConfigLogic.checkValidityandUpdate(property);
		if(status==true){
			return Response.status(Status.ACCEPTED).build();
		}
		return Response.status(Status.BAD_REQUEST).build();

	}
	
	@DELETE
	@Path("/{name}")
	public Response deleteData(@PathParam("name") String name){
		MongoConfigLogic.deleteEntry(name);
		return Response.status(Status.NO_CONTENT).build();
		
	}

}
