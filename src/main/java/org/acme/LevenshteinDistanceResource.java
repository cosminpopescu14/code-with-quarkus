package org.acme;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/levenshtein")
public class LevenshteinDistanceResource {

    @Inject
    private LevenshteinDistance levenshteinDistance;

    @GET
    @Path("/compute/{s1}/{s2}")
    @Produces(MediaType.TEXT_PLAIN)
    public int computeDistance(@PathParam("s1") String string1, @PathParam("s2") String string2) {
        return levenshteinDistance.computeDistance(string1, string2);
    }

}
