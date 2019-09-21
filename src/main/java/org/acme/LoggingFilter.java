package org.acme;

import org.jboss.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

public class LoggingFilter implements ContainerRequestFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class);

    @Context
    UriInfo uriInfo;

    @Context
    HttpServletRequest httpServletRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        final String method = httpServletRequest.getMethod();
        final String path = uriInfo.getPath();
        final String address = httpServletRequest.getRemoteAddr();

        LOG.infof("Request %s %s from IP %s", method, path, address);
    }
}
