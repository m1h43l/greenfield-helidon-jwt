package extranet;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.jwt.JsonWebToken;

import extranet.data.Customer;
import io.helidon.microprofile.cors.CrossOrigin;

@Dependent
@Path("/customer")
public class CustomerResource {

	@Inject
	private JsonWebToken webToken;

	@OPTIONS
	@CrossOrigin()
	public void options() {
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer get(@PathParam("id") Integer id) {
		return buildCustomer(id);
	}

	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Integer id) {
		return Response.noContent().build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Customer persist(Customer customer) {
		return customer;
	}

	private Customer buildCustomer(int id) {
		return new Customer(id, "Mihael Schmidt");
	}
}
