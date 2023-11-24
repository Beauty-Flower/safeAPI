package br.com.fiap.safe.controller;

import java.util.ArrayList;

import br.com.fiap.safe.model.entity.EnderecoHospital;
import br.com.fiap.safe.model.repository.EnderecoHospitalRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/enderecoHospital")
public class EnderecoHospitalResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid EnderecoHospital enderecoHospital) {
		EnderecoHospital resposta = EnderecoHospitalRepository.save(enderecoHospital);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<EnderecoHospital> resposta = EnderecoHospitalRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid EnderecoHospital enderecoHospital) {
		EnderecoHospital resposta = EnderecoHospitalRepository.update(enderecoHospital);
		ResponseBuilder response = null;
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		if (EnderecoHospitalRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(404);
			return response.build();
		}
	}
}
