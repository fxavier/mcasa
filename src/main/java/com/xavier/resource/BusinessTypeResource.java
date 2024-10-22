package com.xavier.resource;


import java.util.List;

import com.xavier.constants.Routes;
import com.xavier.dto.BusinessTypeDTO;
import com.xavier.service.BusinessTypeService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path(Routes.BUSINESS_TYPES)
public class BusinessTypeResource {
    
    @Inject
    private BusinessTypeService businessTypeService;


    @POST

    public Response createBusinessType(@Valid BusinessTypeDTO businessTypeDTO) throws Exception{
        businessTypeService.createBusinessType(businessTypeDTO);
        return Response.status(Response.Status.CREATED).entity(businessTypeDTO).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBusinessTypes() {
        return Response.ok(businessTypeService.getAllBusinessTypes()).build();
        
    }

    @GET
    @Path(Routes.BUSINESS_TYPE)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(businessTypeService.getBusinessTypeById(id)).build();
    }

    @GET
    @Path(Routes.BUSINESS_TYPE_BY_DESCRIPTION)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBusinessTypeByDescription(@PathParam("description")  String description) {
        return Response.ok(businessTypeService.findByDescription(description)).build();
       
    }

    @DELETE
    @Path(Routes.BUSINESS_TYPE)
    public Response deleteBusinessType(@PathParam("id") Long id) {
        businessTypeService.deleteBusinessType(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path(Routes.BUSINESS_TYPE)
    public Response updateBusinessType(@PathParam("id") Long id, @Valid BusinessTypeDTO businessTypeDTO) {
        businessTypeService.updateBusinessType(id, businessTypeDTO);
        return Response.status(Response.Status.OK).build();
    }

    
}
