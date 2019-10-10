/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;

/**
 *
 * @author elhad
 */
public class CsvStatisticSingleton extends AbstractStatisticSingleton {

    final String personnesCsvPathFile = "personnesCsv.csv";

    private CsvStatisticSingleton() {
    }

    private Personne createPersonneWithFileObject(String[] attributs) {
        return null;
    }

    @Override
    protected void extractPersonnesDatas() {
    }
}
