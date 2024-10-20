package com.xavier.resource;


import java.util.List;

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

@Path("/api/v1/business-types")
public class BusinessTypeResource {
    
    @Inject
    private BusinessTypeService businessTypeService;


    @POST

    public Response createBusinessType(@Valid BusinessTypeDTO businessTypeDTO) throws Exception{
        businessTypeService.createBusinessType(businessTypeDTO);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BusinessTypeDTO> getAllBusinessTypes() {
        return businessTypeService.getAllBusinessTypes();
        
    }

    @GET
    @Path("/{description}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BusinessTypeDTO> getBusinessTypeByDescription(@PathParam("description")  String description) {
        return businessTypeService.findByDescription(description);
       
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBusinessType(@PathParam("id") Long id) {
        businessTypeService.deleteBusinessType(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBusinessType(@PathParam("id") Long id, @Valid BusinessTypeDTO businessTypeDTO) {
        businessTypeService.updateBusinessType(id, businessTypeDTO);
        return Response.status(Response.Status.OK).build();
    }

    
}
