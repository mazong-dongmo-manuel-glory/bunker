package com.example.bunker.pkgBunker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

public  class Personnel implements Serializable {
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected GregorianCalendar dateNaissance;
    protected boolean vivant;
    private static ArrayList<Personnel> PERSONNELS;
    static {
        PERSONNELS = new ArrayList<Personnel>();
    }
    public Personnel(String _matricule,String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant) {
        setMatricule(_matricule);
        setNom(_nom);
        setPrenom(_prenom);
        setDateNaissance(_dateNaissance);
        setVivant(_vivant);
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(GregorianCalendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setVivant(boolean vivant) {
        this.vivant = vivant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public GregorianCalendar getDateNaissance() {
        return dateNaissance;
    }

    public String getMatricule() {
        return matricule;
    }
    public boolean getVivant() {
        return vivant;
    }
    @Override
    public String toString() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        return "Matricule : " + matricule + "\nNom : " + nom + "\ndate de naissance : " + formatDate.format(dateNaissance.getTime())
                + "\nVvivant : " + vivant+"\n";
    }

    public boolean equals(Personnel p) {
        return getNom().equals(p.getNom()) && getMatricule().equals(p.getMatricule())
                && getPrenom().equals(p.getPrenom()) && getDateNaissance().equals(p.getDateNaissance());
    }

}
