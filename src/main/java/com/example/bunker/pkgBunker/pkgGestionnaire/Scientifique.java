package com.example.bunker.pkgBunker.pkgGestionnaire;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Scientifique extends Gestionnaire {
    private String[] listeProjet;
    public Scientifique(String _matricule, String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant, int _nombreEmploye,
                        String _secteur, int _nombreProjet, String[] _listeProjet) {
        super( _matricule,_nom, _prenom, _dateNaissance, _vivant, _nombreEmploye, _secteur, _nombreProjet);
        setListeProjet(_listeProjet);

    }
    public void setListeProjet(String[] listeProjet) {
        this.listeProjet = listeProjet;
    }
    public String[] getListeProjet() {
        return listeProjet;
    }
    @Override
    public String toString() {
        String projetString ="";
        for(String projet : listeProjet){
            projetString +=  projet+"\n";
        }
        return super.toString()+projetString;
    }
    public boolean equals(Scientifique s) {
        boolean result = s.getListeProjet().length == listeProjet.length;
        for (String string : listeProjet) {
            if (!string.equals(string)) {
                result = false;
                break;
            }
        }
        return super.equals(s) && result;
    }
    public int hashCode() {
        return super.hashCode();
    }
}
