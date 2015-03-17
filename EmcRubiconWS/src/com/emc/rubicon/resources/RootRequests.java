package com.emc.rubicon.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;

@Path("/")
public class RootRequests {
	
	@GET
	@Produces("text/xml")
	public String DisplayGeneral(@Context HttpServletRequest requestContext) {
		System.out.println("illegal request made from "+requestContext.getRemoteAddr()+", send HTTP 404");
		throw new WebApplicationException(404);
            
	}

}
