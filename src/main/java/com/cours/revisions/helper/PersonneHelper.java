/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.helper;

import com.cours.revisions.entities.Personne;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elhad
 */
public class PersonneHelper {

    public PersonneHelper(){}

    private List<Personne> personnes = null;

    public List<Personne> createListPersonnes() {
        return new ArrayList<>();
    }

    public void addPersonne(Integer idPersonne, String name, String lastName, Double weight, Double high, String address, String city, String zipCode) {
        if (personnes == null){
            personnes = createListPersonnes();
        }
        Personne personne = createPersonne(idPersonne, name, lastName, weight, high, address, city, zipCode);
        personnes.add(personne);
    }

    private Personne createPersonne(Integer idPersonne, String name, String lastName, Double weight, Double high, String address, String city, String zipCode) {
       return new Personne(idPersonne, name, lastName, weight, high, address, city, zipCode);
    }

    public List<Personne> getPersonnes(){return personnes;}

//    public List<Personne> createListPersonnesReflexive() {
//        return null;
//    }
//
//    public Personne addPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
//        return null;
//    }
//
//    public Personne createPersonneReflexive(Integer idPersonne, String prenom, String nom, Double poids, Double taille, String rue, String ville, String codePostal) {
//       return null;
//    }
}
