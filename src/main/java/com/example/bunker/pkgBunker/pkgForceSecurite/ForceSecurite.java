package com.example.bunker.pkgBunker.pkgForceSecurite;

import java.util.GregorianCalendar;

import com.example.bunker.pkgBunker.Personnel;

public abstract class ForceSecurite extends Personnel{
    protected String grade;
    protected String poste;
    protected int anneeService;
    protected String arme;
    ForceSecurite(String _matricule, String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant,String _grade,String _poste, int _anneeService,String _arme){
        super( _matricule,_nom, _prenom, _dateNaissance, _vivant);
        setGrade(_grade);
        setPoste(_poste);
        setAnneeService(_anneeService);
        setArme(_arme);
        
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setAnneeService(int anneeService) {
        this.anneeService = anneeService;
    }
    public void setPoste(String poste) {
        this.poste = poste;
    }
    public void setArme(String arme) {
        this.arme = arme;
    }
    public int getAnneeService() {
        return anneeService;
    }
    public String getArme() {
        return arme;
    }
    public String getPoste() {
        return poste;
    }
    public String getGrade() {
        return grade;
    }
    @Override
    public String toString() {
        return super.toString()+"Grade : "+getGrade()+"\nPoste : "+getPoste()+"\nAnnee de service : "+anneeService+"\n";
    }
    
    public boolean equals(ForceSecurite f) {
        return super.equals(f) &&  f.getPoste().equals(f.getPoste()) && f.getGrade().equals(f.getGrade()) && f.getAnneeService() == getAnneeService();
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
}
