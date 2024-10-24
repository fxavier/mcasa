package com.xavier.resource;

import com.xavier.constants.Routes;
import com.xavier.dto.PropertyTypeDTO;
import com.xavier.service.PropertyTypeService;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path(Routes.PROPERTY_TYPES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropertyTypeResource {

    @Inject
    private PropertyTypeService propertyTypeService;

    @POST
    public Response create (PropertyTypeDTO propertyTypeDTO) {
        return Response.status(Response.Status.CREATED)
            .entity(propertyTypeService.create(propertyTypeDTO))
            .build();
    }

    @GET
    public Response findAll() {
        return Response.ok(propertyTypeService.findAll()).build();
    }

    @GET
    @Path(Routes.PROPERTY_TYPE)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(propertyTypeService.findById(id)).build();
    }

    @GET
    @Path(Routes.PROPERTY_TYPE_BY_DESCRIPTION)
    public Response findByDescription(@PathParam("description") String description) {
        return Response.ok(propertyTypeService.findByDescription(description)).build();
    }

    @PUT
    @Path(Routes.PROPERTY_TYPE)
    public Response update(@PathParam("id") Long id, PropertyTypeDTO propertyTypeDTO) {
        return Response.ok(propertyTypeService.update(id, propertyTypeDTO)).build();
    }

    @DELETE
    @Path(Routes.PROPERTY_TYPE)
    public Response delete(@PathParam("id") Long id) {
        propertyTypeService.delete(id);
        return Response.noContent().build();
    }
}
