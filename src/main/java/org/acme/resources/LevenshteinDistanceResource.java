package org.acme.resources;

import com.google.gson.Gson;
import org.acme.service.LevenshteinDistance;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/levenshtein")
public class LevenshteinDistanceResource {

    @Inject
    LevenshteinDistance levenshteinDistance;

    @Inject
    org.acme.Entities.Response levenshteinResponse;


    private Gson gson = new Gson();

    @GET
    @Path("/compute/{s1}/{s2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response computeDistance(@PathParam("s1") String string1, @PathParam("s2") String string2) {
        levenshteinResponse.setDistance(levenshteinDistance.computeDistance(string1, string2));
        var jsonResponse = gson.toJson(levenshteinResponse);
        return Response.status(200).entity(jsonResponse).build();
    }
}
