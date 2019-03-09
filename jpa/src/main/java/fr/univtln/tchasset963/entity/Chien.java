package fr.univtln.tchasset963.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(
//        name = "Chien",
//        uniqueConstraints={
//                @UniqueConstraint(name="id", columnNames={"PERSONNE_NOM", "PERSONNE_PRENOM"})
//        }
//)
@NamedQueries({
        @NamedQuery(name="Chien.findAll", query = "SELECT c FROM Chien c"),
        @NamedQuery(name="Chien.findByName", query="SELECT c FROM Chien c WHERE c.surnom = :surnom")
})
public class Chien {

    @Id
    private String surnom;

    @OneToOne
    @JoinColumns(value = {
            @JoinColumn(name = "nom_maitre", referencedColumnName = "PERSONNE_NOM"),
            @JoinColumn(name = "prenom_maitre", referencedColumnName = "PERSONNE_PRENOM")
    })
    private Personne proprietaire;

    @ManyToOne(cascade = CascadeType.ALL)
    private Chenil chenil;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Pathologie> pathologie = new ArrayList<>();

    public static List<Chien> chienList = new ArrayList<>();

    public Chien() {  chienList.add(this);  }

    public Chien(String surnom) {
        super(); this.surnom = surnom; chienList.add(this);
    }

    public Chien(String surnom, Personne proprietaire) {
        super();
        this.surnom = surnom;
        this.proprietaire = proprietaire;
    }

    public Chien(String surnom, Personne proprietaire, Chenil chenil) {
        this.surnom = surnom;
        this.proprietaire = proprietaire;
        this.chenil = chenil;
    }

    public static List<Chien> getChiens() {
        return chienList;
    }

    @Override
    public String toString() {
        return "Chien {" +
                "surnom='" + surnom + '\'' +
                ", proprietaire=" + proprietaire +
                '}'+"\n";
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String nom) {
        this.surnom = nom;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Chenil getChenil() {
        return chenil;
    }

    public void setChenil(Chenil chenil) {
        this.chenil = chenil;
    }

    public List<Pathologie> getPathologie() {
        return pathologie;
    }

    public void setPathologie(List<Pathologie> pathologie) {
        this.pathologie = pathologie;
    }
}
