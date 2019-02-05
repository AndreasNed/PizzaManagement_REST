package REST;

import DAO.PizzaDAO;
import Entity.Pizza;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/pizza")
public class REST_Functions {

    @Inject
    PizzaDAO dao;

    @POST
    @Path("/add")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addPizza(Pizza p) {
        dao.add(p);
    }

    @GET
    @Path("/find/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pizza findPizza(@PathParam("id") Long id) {
        return dao.find(id);
    }

    @GET
    @Path("/find/all")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pizza> findAllPizza() {
        return dao.findAll();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public void deletePizza(@PathParam("id") Long id){
        dao.delete(id);
    }
    
    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePizza(Pizza p){
        dao.update(p);
    }

}
