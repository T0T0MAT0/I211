package fr.univtln.tchasset963.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Chenil {

    @Id
    private String nom;

    @OneToMany(mappedBy = "chenil",cascade = CascadeType.ALL)
    private List<Chien> listChiens = new ArrayList();

    public Chenil() {    }

    public Chenil(String nom) {
        this.nom = nom;
    }

    public Chenil(List<Chien> listChiens) {
        this.listChiens = listChiens;
    }

    public List<Chien> getListChiens() {
        return listChiens;
    }

    public void setListChiens(List<Chien> listChiens) {
        this.listChiens = listChiens;
    }
    public void setChien(Chien chien) {
        this.getListChiens().add(chien);
    }
}
