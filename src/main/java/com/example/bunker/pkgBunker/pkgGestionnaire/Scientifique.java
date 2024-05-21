package com.example.bunker.pkgBunker.pkgGestionnaire;

import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Scientifique extends Gestionnaire {
    private ArrayList<String> listeProjet;
    Scientifique(String _matricule,String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant, int _nombreEmploye,
            String _secteur, int _nombreProjet, ArrayList<String> _listeProjet) {
        super( _matricule,_nom, _prenom, _dateNaissance, _vivant, _nombreEmploye, _secteur, _nombreProjet);

    }
    public void setListeProjet(ArrayList<String> listeProjet) {
        this.listeProjet = listeProjet;
    }
    public ArrayList<String> getListeProjet() {
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
        boolean result = s.getListeProjet().size() != listeProjet.size() ? false : true;
        for(int i = 0;i <  listeProjet.size();i++){
            if(!listeProjet.get(i).equals(listeProjet.get(i))){
                result = false;
            }
        }
        return super.equals(s) && result;
    }
    public int hashCode() {
        return super.hashCode();
    }
}
