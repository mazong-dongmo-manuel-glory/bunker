package com.example.bunker.pkgBunker.pkgEmployeMaintenance;

import java.util.GregorianCalendar;

import com.example.bunker.pkgBunker.Personnel;

public abstract class EmployeMaintenance extends Personnel{
    protected String secteur;
    EmployeMaintenance(String _matricule,String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant,String _secteur){
        super(_matricule,_nom, _prenom, _dateNaissance, _vivant);
        setSecteur(_secteur);

    }
    public String getSecteur() {
        return secteur;
    }
    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }
    public String toString(){
        return super.toString()+"\nSecteur : "+secteur+"\n";
    }
    public boolean equals(EmployeMaintenance emp){
        return super.equals(emp) && emp.getSecteur().equals(secteur);
    }
}
