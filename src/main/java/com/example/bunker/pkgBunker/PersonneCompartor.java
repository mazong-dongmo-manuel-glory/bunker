package com.example.bunker.pkgBunker;

import java.util.Comparator;

public class PersonneCompartor implements Comparator<Personnel> {

    @Override
    public int compare(Personnel p1, Personnel p2) {
        int dateComparison = p1.getDateNaissance().compareTo(p2.getDateNaissance());
        if (dateComparison != 0) {
            return dateComparison;
        } else {
            return p1.getNom().compareToIgnoreCase(p2.getNom());
        }
    }

}
