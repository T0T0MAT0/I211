package fr.univtln.tchasset963.rest;

import fr.univtln.tchasset963.dao.DAO;
import fr.univtln.tchasset963.entity.Chien;

import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/chiens")
@Produces({"application/xml", "application/json"})
public class ChienRest {

    private DAO Dao = new DAO();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Chien> getChiens() {
        TypedQuery<Chien> query = Dao.getEm().createNamedQuery("Chien.findAll", Chien.class);
        List<Chien> results = query.getResultList();
        return results;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/{surnom}")
    public Chien getChien(@QueryParam("surnom") final String surnom) {
        TypedQuery<Chien> query = Dao.getEm().createNamedQuery("Chien.findByName", Chien.class);
        Chien chien = query.getSingleResult();
        return chien;
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public void addChien(@QueryParam("prenom") String surnom) {
        Dao.getEm().persist(new Chien(surnom));
    }
}
