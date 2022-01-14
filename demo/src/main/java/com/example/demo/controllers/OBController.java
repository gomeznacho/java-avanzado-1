package com.example.demo.controllers;

import com.example.demo.models.OB;
import com.example.demo.service.OBService;

import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
public class OBController {
    private OBService obService;

    public OBController(OBService obService) {
        this.obService = obService;

        this.obService.add(new OB("asd", Math.random()));
        this.obService.add(new OB("qwe", Math.random()));
        this.obService.add(new OB("zxc", Math.random()));
        this.obService.add(new OB("tyui", Math.random()));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<OB> findAll(){
        return OBService.getAll();
    }

    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public OB getOne(@PathParam("name") String name){
        return OBService.getOne(name);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes()
    public Response addBootcamp(OB ob){
        obService.add(ob);

        return Response
                .created(URI.create("/bootcampers/" + ob.getName()))
                .build();
    }
    @DELETE
    @Path("/bootcampers/{name}")
    public Response deleteBootcamp(@PathParam("name") String name){
        obService.delete(name);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/bootcampers")
    public Response deleteAll(){
        obService.deleteAll();
        return Response.noContent().build();
    }

}
