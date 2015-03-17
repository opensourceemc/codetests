/**
 * @author Ryan.Swenson
 * 
 * JAXWS-RS RESTFUL Fibonacci Service v0.1
 *
 */

package com.emc.rubicon.resources;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

import com.emc.rubicon.math.Fibonacci;


@Path("/fibonacci")
public class PrincipalService {  
	

	Integer n;
	
	Fibonacci fib = new Fibonacci();
	
	
	@GET
	@Produces("text/plain")
	public String ReturnResultText(@QueryParam("n") int n) {
		
		if (n<0) {
	        throw new WebApplicationException(400);
		}
		
		String result = fib.Fib(n);

		return result;     
            
	}

}
