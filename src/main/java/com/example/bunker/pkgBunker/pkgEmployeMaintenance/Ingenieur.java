package com.example.bunker.pkgBunker.pkgEmployeMaintenance;

import java.util.GregorianCalendar;

public class Ingenieur extends EmployeMaintenance{
    private String specialiste;
    private GregorianCalendar dateFinEtude;
    private int niveauEtude;

    public Ingenieur(String _matricule, String _nom, String _prenom,
                     GregorianCalendar _dateNaissance,
                     boolean _vivant,
                     int _nombreEmploye,
                     String _secteur,
                     int _nombreProjet, String _projetAffecte, String _titre,
                     String _specialiste, GregorianCalendar _dateFinEtude, int _niveauEtude){
        super(_matricule,_nom, _prenom, _dateNaissance, _vivant, _secteur);
        setSpecialiste(_specialiste);
        setDateFinEtude(_dateFinEtude);
        setDateFinEtude(_dateFinEtude);

    }
    public void setSpecialiste(String specialiste) {
        this.specialiste = specialiste;
    }
    public void setDateFinEtude(GregorianCalendar dateFinEtude) {
        this.dateFinEtude = dateFinEtude;
    }
    public void setNiveauEtude(int niveauEtude) {
        this.niveauEtude = niveauEtude;
    }
    public String getSpecialiste() {
        return specialiste;
    }
    public GregorianCalendar getDateFinEtude() {
        return dateFinEtude;
    }
    public int getNiveauEtude() {
        return niveauEtude;
    }
    public String toString(){
        return super.toString()+"Specialite : "+specialiste+"\nDate de fin d'etude : "+
        dateFinEtude.toString()+"\nNiveau d'etude : "+niveauEtude+"\n";
    }
    public boolean equals(Ingenieur ing){
        return super.equals(ing) &&  specialiste.equals(ing.getSpecialiste()) && dateFinEtude.equals(ing.getDateFinEtude()) && niveauEtude == ing.getNiveauEtude();
    }
}
