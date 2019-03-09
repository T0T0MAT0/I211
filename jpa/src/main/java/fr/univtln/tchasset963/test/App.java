package fr.univtln.tchasset963.test;

import fr.univtln.tchasset963.entity.Chenil;
import fr.univtln.tchasset963.entity.Chien;
import fr.univtln.tchasset963.entity.Personne;
import fr.univtln.tchasset963.entity.PersonneId;

import javax.persistence.*;


public class App
{
    public static void main( String[] args ){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testpostgresqllocal");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transac = em.getTransaction();

        Personne
                personne = new Personne(new PersonneId("Chasset", "Thomas")),
                personne1 = new Personne(new PersonneId("Abc","Def"));

        Chien chien = new Chien("Rufus"),
            chien1 = new Chien("Arbus"),
            chien2 = new Chien("Mumu");

        chien.setProprietaire(personne);
        personne.setChien(chien);

        Chenil chenil1 = new Chenil("Chenil1"),
                chenil2 = new Chenil("Chenil2");

        chien1.setChenil(chenil1);
        chien2.setChenil(chenil1);

        transac.begin();

        em.persist(personne);
        em.persist(personne1);

        em.persist(chien);
        em.persist(chien1);
        em.persist(chien2);

        em.persist(chenil1);
        em.persist(chenil2);

        transac.commit();

        em.close();
        emf.close();
    }
}
