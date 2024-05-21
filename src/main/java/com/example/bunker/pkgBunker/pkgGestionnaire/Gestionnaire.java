package com.example.bunker.pkgBunker.pkgGestionnaire;

import java.util.GregorianCalendar;


import com.example.bunker.pkgBunker.Personnel;
public abstract class Gestionnaire extends Personnel {
    protected int nombreEmploye;
    protected String secteur;
    protected int nombreProjet;

    Gestionnaire(String _matricule,String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant, int _nombreEmploye,
            String _secteur, int _nombreProjet) {
        super(_matricule,_nom, _prenom, _dateNaissance, _vivant);
        setNombreEmploye(_nombreEmploye);
        setSecteur(_secteur);
        setNombreProjet(_nombreProjet);

    }

    public void setNombreEmploye(int nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public void setNombreProjet(int nombreProjet) {
        this.nombreProjet = nombreProjet;
    }

    public int getNombreEmploye() {
        return nombreEmploye;
    }

    public String getSecteur() {
        return secteur;
    }

    public int getNombreProjet() {
        return nombreProjet;
    }

    @Override
    public String toString() {

        return super.toString() + "Nombre employe : " + nombreEmploye + "\nSecteur : " + secteur + "\nNombre projet : "
                + nombreProjet + "\n";
    }

    public boolean equals(Gestionnaire g) {
        return super.equals(g) && g.getNombreEmploye() == nombreEmploye && g.getNombreProjet() == nombreProjet
                && g.getSecteur().equals(secteur);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
