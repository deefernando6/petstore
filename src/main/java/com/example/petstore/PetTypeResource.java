package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/v1/petType")
@Produces("application/json")
public class PetTypeResource {

	private static List<String> petTypes = new ArrayList<>();

	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "All Pets Types", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
	@GET
	public Response getPets() {
		List<String> allPetTypes = new ArrayList<String>();
		if(petTypes.size() > 0){
			allPetTypes = petTypes;
		}
		return Response.ok(allPetTypes).build();
	}

	@APIResponses(value = {
			@APIResponse(responseCode = "201", description = "Pet Type Added", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet")))})
	@POST
	@Path("/add")
	public Response createPetType(String petType) {
		int[] value = {0};
		petTypes.forEach(type -> {
			if(type == petType) {
				value[0] = value[0]+1;
			}
		});
		if(value[0] == 0) {
			petTypes.add(petType);
		} else {
			return Response.status(400).build();			
		}
		return Response.ok(petType).build();
	}


	@APIResponses(value = {
			@APIResponse(responseCode = "200", description = "Pet Type Deleted Succesfully", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(ref = "Pet"))),
			@APIResponse(responseCode = "404", description = "No Pet Type found for the pet type.")})
	@DELETE
	public Response deletePetType(String petType) {
		int[] value = {0};
		petTypes.forEach(type -> {
			if(type == petType) {
				value[0] = value[0]+1;
			}
		});
		if(value[0] > 0) {
			petTypes.remove(petType);
		} else {
			return Response.status(400).build();			
		}
		return Response.status(200).build();
	}
}
