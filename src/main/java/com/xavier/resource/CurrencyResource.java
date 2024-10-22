package com.xavier.resource;

import com.xavier.constants.Routes;
import com.xavier.service.CurrencyService;

import com.xavier.dto.CurrencyDTO;

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
@Path(Routes.CURRENCIES)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CurrencyResource {

    @Inject
    private CurrencyService currencyService;

    @POST
    public Response create(CurrencyDTO currencyDTO) {
        CurrencyDTO createdCurrency = currencyService.create(currencyDTO);
        return Response.status(Response.Status.CREATED).entity(createdCurrency).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(currencyService.findAll()).build();
    }

    @GET
    @Path(Routes.CURRENCY_BY_NAME)
    public Response findByName(@PathParam("name") String name) {
        return Response.ok(currencyService.findByName(name)).build();
    }

    @GET
    @Path(Routes.CURRENCY)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(currencyService.findById(id)).build();
    }

    @PUT
    @Path(Routes.CURRENCY)
    public Response update(@PathParam("id") Long id, CurrencyDTO currencyDTO) {
        return Response.ok(currencyService.update(id, currencyDTO)).build();
    }

    @DELETE
    @Path(Routes.CURRENCY)
    public Response delete(@PathParam("id") Long id) {
        currencyService.delete(id);
        return Response.noContent().build();
    }
}
