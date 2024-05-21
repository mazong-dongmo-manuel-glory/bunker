package com.example.bunker.pkgBunker.pkgForceSecurite;

import java.util.GregorianCalendar;

public class Milice extends ForceSecurite {
    private int nombrePlainte;

    public Milice(String matricule, String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant,
                  String _grade, String _poste, int _anneeService, String _arme, int _nombrePlainte) {
        super(matricule, _nom, _prenom, _dateNaissance, _vivant, _grade, _poste, _anneeService, _arme);
        setNombrePlainte(_nombrePlainte);

    }

    public void setNombrePlainte(int nombrePlainte) {
        this.nombrePlainte = nombrePlainte;
    }

    public int getNombrePlainte() {
        return nombrePlainte;
    }

    @Override
    public String toString() {
        return super.toString() + "Nombre de plainte : " + nombrePlainte + "\n";
    }

    public boolean equals(Milice m) {
        return super.equals(m) && m.nombrePlainte == nombrePlainte;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}