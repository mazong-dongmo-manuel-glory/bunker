package com.example.bunker.pkgBunker.pkgEmployeMaintenance;

import java.util.GregorianCalendar;

public class Ouvrier extends EmployeMaintenance {
    private int quartDetravail;
    private String genreDeTravail;
    public Ouvrier(String _matricule, String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant, String _secteur,
                   int _quartDeTravail, String _genreDeTravail){
        super(_matricule,_nom, _prenom, _dateNaissance, _vivant, _secteur);
        setQuartDetravail(_quartDeTravail);
        setGenreDeTravail(_genreDeTravail);

    }
    public void setQuartDetravail(int quartDetravail) {
        this.quartDetravail = quartDetravail;
    }
    public void setGenreDeTravail(String genreDeTravail) {
        this.genreDeTravail = genreDeTravail;
    }
    public String getGenreDeTravail() {
        return genreDeTravail;
    }
    public int getQuartDetravail() {
        return quartDetravail;
    }
    public String toString(){
        return super.toString()+"Quart de travail : "+quartDetravail+"\nGenre de travail : "+genreDeTravail+"\n";
    }
    
    public boolean equals(Ouvrier ouv){
        return super.equals(ouv) && ouv.getGenreDeTravail().equals(genreDeTravail) && ouv.getQuartDetravail() == quartDetravail;
    }
}
