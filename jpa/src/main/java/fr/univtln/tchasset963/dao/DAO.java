package fr.univtln.tchasset963.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
    private EntityManager em = emf.createEntityManager();

    public EntityManager getEm() {
        return this.em;
    }
}
