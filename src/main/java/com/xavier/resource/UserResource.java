package com.xavier.resource;


import com.xavier.constants.Routes;
import com.xavier.dto.UserDTO;
import com.xavier.service.UserService;

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
import jakarta.ws.rs.core.Response.Status;


@Path(Routes.USERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserService userService;

    @POST
    public Response create(UserDTO userDTO) {
        UserDTO createdUser = userService.create(userDTO);
        return Response.status(Status.CREATED).entity(createdUser).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(userService.findAll()).build();
    }

    @GET
    @Path(Routes.USER)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(userService.findById(id)).build();
    }

    @GET
    @Path(Routes.USER_BY_EMAIL)
    public Response findByEmail(@PathParam("email") String email) {
        return Response.ok(userService.findByEmail(email)).build();
    }

    @PUT
    @Path(Routes.USER)
    public Response update(@PathParam("id") Long id, UserDTO userDTO) {
        return Response.ok(userService.update(id, userDTO)).build();
    }

    @DELETE
    @Path(Routes.USER)
    public Response delete(@PathParam("id") Long id) {
        userService.delete(id);
        return Response.noContent().build();
    }
}
