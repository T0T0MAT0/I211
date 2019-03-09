package fr.univtln.tchasset963.entity;

import javax.persistence.*;

@Entity
public class Personne {

    @EmbeddedId
    PersonneId id;

    @OneToOne(mappedBy = "proprietaire",  orphanRemoval = true)
    private Chien chien;

    public Personne() {    }

    public Personne(PersonneId id) {
        this.id = id;
    }

    public Personne(PersonneId id, Chien chien) {
        this.id = id;
        this.chien = chien;
    }

    public PersonneId getId() {
        return id;
    }

    public void setId(PersonneId id) {
        this.id = id;
    }

    public Chien getChien() {
        return chien;
    }

    public void setChien(Chien chien) {
        this.chien = chien;
        chien.setProprietaire(this);
    }

    //@Id
    //@GeneratedValue
    //private int id;
    //private String nom, prenom;

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

//    public String getNom() {
//        return nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }
//
//    public String getPrenom() {
//        return prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }

//    public int getPoids() {
//        return poids;
//    }
//
//    public void setPoids(int poids) {
//        this.poids = poids;
//    }

    //    public Personne(String prenom, String nom) {
//        this.nom = nom;
//        this.prenom = prenom;
//    }
//
//    public Personne(int poids, String nom, String prenom) {
//        this.poids = poids;
//        this.nom = nom;
//        this.prenom = prenom;
//    }
}
