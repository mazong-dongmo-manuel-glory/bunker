package com.example.bunker.pkgBunker.pkgGestionnaire;

import java.util.GregorianCalendar;

public class Administrateur extends Gestionnaire {
    private String projetAffecte;
    private String titre;

    public Administrateur(
        String _matricule,
            String _nom, String _prenom,
            GregorianCalendar _dateNaissance,
            boolean _vivant,
            int _nombreEmploye,
            String _secteur,
            int _nombreProjet ,String _projetAffecte,String _titre) {
        super(_matricule,_nom, _prenom, _dateNaissance, _vivant, _nombreEmploye, _secteur, _nombreProjet);
        setProjetAffecte(_projetAffecte);
        setTitre(_titre);
        

    }
    public void setProjetAffecte(String projetAffecte) {
        this.projetAffecte = projetAffecte;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getTitre() {
        return titre;
    }
    public String getProjetAffecte() {
        return projetAffecte;
    }
    
    public String toString(){
        return super.toString()+"Projet Affecte : "+projetAffecte+"\nTitre : "+titre+"\n";
    }
    public boolean equals(Administrateur ad){
        return super.equals(ad)+ad.getProjetAffecte() == projetAffecte && titre.equals(ad.getProjetAffecte());
    }
    
}