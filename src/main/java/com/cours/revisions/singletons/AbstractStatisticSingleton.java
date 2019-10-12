/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.cours.revisions.utils.Stats.getMean;
import static com.cours.revisions.utils.Stats.getStandardDeviaion;
import static com.cours.revisions.utils.Stats.getStandardDeviation;


/**
 *
 * @author elhad
 */
public abstract class AbstractStatisticSingleton {

    protected List<Personne> people = new ArrayList<Personne>();
    protected Double meanWeights = 0.0;
    protected Double standardDeviationWeights = 0.0;

    protected Double meanHighs = 0.0;
    protected Double standardDeviationHighs = 0.0;

    public Double getMeanWeights() {
        return meanWeights;
    }

    public Double getStandardDeviationWeights() {
        return standardDeviationWeights;
    }

    public Double getMeanHighs() {
        return meanHighs;
    }

    public Double getStandardDeviationHighs() {
        return standardDeviationHighs;
    }

    public List<Personne> getPeople() {
        return people;
    }

    protected abstract void extractPersonnesDatas();

    protected void computeStats(){
        List<Double> weights = people.stream().map(Personne::getPoids).collect(Collectors.toList());
        meanWeights = getMean(weights);
        standardDeviationWeights = getStandardDeviaion(weights);

        List<Double> highs = people.stream().map(Personne::getTaille).collect(Collectors.toList());
        meanHighs = getMean(highs);
        standardDeviationHighs = getStandardDeviaion(highs);

    }
}
