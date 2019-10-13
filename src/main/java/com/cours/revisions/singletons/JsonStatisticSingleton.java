/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.singletons;

import com.cours.revisions.entities.Personne;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author elhad
 */
public class JsonStatisticSingleton extends AbstractStatisticSingleton {

    private final String personnesJsonPathFile = "personnesJson.json";
    private final String personnesKey = "personnes";

    private final String idKey = "id";
    private final String nameKey = "prenom";
    private final String lasNameKey = "nom";
    private final String weightKey = "poids";
    private final String highKey = "taille";
    private final String addressKey = "rue";
    private final String cityKey = "ville";
    private final String zipCodeKey = "codePostal";



    private JsonStatisticSingleton() {
        System.out.printf("coucou");
        extractPersonnesDatas();
    }

    private static class LazyHolder {
        static final JsonStatisticSingleton INSTANCE = new JsonStatisticSingleton();
    }

    public static JsonStatisticSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
        return new Personne(
                ((Long) jsonObjectPerson.get(idKey)).intValue(),
                ((String) jsonObjectPerson.get(nameKey)),
                ((String) jsonObjectPerson.get(lasNameKey)),
                ((Long) jsonObjectPerson.get(weightKey)).doubleValue(),
                ((Long) jsonObjectPerson.get(highKey)).doubleValue(),
                ((String) jsonObjectPerson.get(addressKey)),
                ((String) jsonObjectPerson.get(cityKey)),
                ((String) jsonObjectPerson.get(zipCodeKey))
        );
    }

    @Override
    protected void extractPersonnesDatas() {
        try {
            Reader reader = new FileReader((personnesJsonPathFile));
            JSONParser parser = new JSONParser();
            JSONObject parsedJson = (JSONObject) parser.parse(reader);

            JSONArray personnesArray = (JSONArray) parsedJson.get(personnesKey);

            for (Object personneData : personnesArray){
                people.add(createPersonneWithFileObject((JSONObject) personneData));
            }

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        computeStats();

    }

}
