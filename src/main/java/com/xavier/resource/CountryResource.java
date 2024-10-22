package com.xavier.resource;


import com.xavier.constants.Routes;
import com.xavier.dto.CountryDTO;
import com.xavier.service.CountryService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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

@ApplicationScoped
@Path(Routes.COUNTRIES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CountryResource {
    @Inject
    private CountryService countryService;

    @GET
    public Response findAll() {
        return Response.ok(countryService.findAll()).build();
    }

    @GET
    @Path(Routes.COUNTRY)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(countryService.findById(id)).build();
    }

    @POST
    public Response create(CountryDTO countryDTO) {
        CountryDTO createdCountry = countryService.save(countryDTO);
        return Response.status(Response.Status.CREATED)
                       .entity(createdCountry)
                       .build();
    }

    @PUT
    @Path(Routes.COUNTRY)
    public Response update(@PathParam("id") Long id, CountryDTO countryDTO) {
        CountryDTO updatedCountry = countryService.update(id, countryDTO);
        return Response.ok(updatedCountry).build();
    }   

    @DELETE
    @Path(Routes.COUNTRY)
    public Response delete(@PathParam("id") Long id) {
        countryService.delete(id);
        return Response.noContent().build();
    }


    
}
