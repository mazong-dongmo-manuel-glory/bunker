package com.example.bunker.pkgBunker.pkgForceSecurite;

import java.util.GregorianCalendar;

public class Armee extends ForceSecurite {
    private int nombreVictime;
    private int nombreSortie;
    private String[] matricules;

    public Armee(String matricule, String _nom, String _prenom, GregorianCalendar _dateNaissance, boolean _vivant,
            String _grade, String _poste, int _anneeService, String _arme, int _nombreVictime,
            int _nombreSortie, String[] _matricules) {
        super(matricule, _nom, _prenom, _dateNaissance, _vivant, _grade, _poste, _anneeService, _arme);
        setNombreVictime(_nombreVictime);
        setNombreSortie(_nombreSortie);
        setMatricules(_matricules);

    }

    public void setNombreVictime(int nombreVictime) {
        this.nombreVictime = nombreVictime;
    }

    public void setNombreSortie(int nombreSortie) {
        this.nombreSortie = nombreSortie;
    }

    public void setMatricules(String[] matricules) {
        this.matricules = matricules;
    }

    public int getNombreVictime() {
        return nombreVictime;
    }

    public int getNombreSortie() {
        return nombreSortie;
    }

    public String[] getMatricules() {
        return matricules;
    }

    public boolean equals(Armee armee) {
        return super.equals(armee) && armee.getNombreVictime() == getNombreVictime()
                && armee.getNombreSortie() == getNombreSortie() &&
                armee.matricules[0].equals(getMatricules()[0]) && armee.matricules[1].equals(matricules[1]) &&
                armee.matricules[2].equals(matricules[2]) && armee.matricules[3].equals(matricules[3])
                && armee.matricules[4].equals(matricules[4]);
    }

    @Override
    public String toString() {
        String matriculestring="";
        for(int i=0; i<matricules.length; i++) {

        matriculestring +=" "+ matricules[i];
        }
        return super.toString() + "\nNombre de victime : " + nombreVictime + "\nNombre de sortie : " + nombreSortie
                + "\nMaticules :  " + matriculestring
                + "\n";
    }
}
