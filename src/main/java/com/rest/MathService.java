package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.model.Number;

/**
 *
 * @author George
 */
@Path("mathapi")
public class MathService {
    public MathService(){}
    
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(){
        return "Welcome to Math Service";
    }
    
    @GET
    @Path("/number/n/{N}")
    @Produces(MediaType.APPLICATION_XML)
    public Number values(@PathParam("N") int N){
        return new Number(N);
    }
}
