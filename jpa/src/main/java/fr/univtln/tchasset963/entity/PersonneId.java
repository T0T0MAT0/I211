package fr.univtln.tchasset963.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonneId implements Serializable {
    @Column(unique = true, name="PERSONNE_NOM")
    private String nom;
    @Column(unique = true, name="PERSONNE_PRENOM")
    private String prenom;

    public PersonneId() {    }

    public PersonneId(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
