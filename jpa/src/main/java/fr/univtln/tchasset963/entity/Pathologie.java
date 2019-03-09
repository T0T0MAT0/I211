package fr.univtln.tchasset963.entity;

import fr.univtln.tchasset963.entity.Chien;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pathologie {

    @Id
    private String nom;
    private String description;

    @ManyToOne
    private Chien chien;

    public Pathologie() {    }

    public Pathologie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Chien getChien() {
        return chien;
    }

    public void setChien(Chien chien) {
        this.chien = chien;
    }
}
