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

    final String personnesJsonPathFile = "personnesJson.json";
    final String personnesKey = "personnes";

    final String idKey = "id";
    final String nameKey = "prenom";
    final String lasNameKey = "nom";



    private JsonStatisticSingleton() {

    }

    private static class LazyHolder {
        static final JsonStatisticSingleton INSTANCE = new JsonStatisticSingleton();
    }

    public static JsonStatisticSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    public Personne createPersonneWithFileObject(JSONObject jsonObjectPerson) {
        System.out.println(jsonObjectPerson.toJSONString());
        return null;
    }

    @Override
    protected void extractPersonnesDatas() {
        try {
            Reader reader = new FileReader((personnesJsonPathFile));
            JSONParser parser = new JSONParser();
            JSONObject parsedJson = (JSONObject) parser.parse(reader);

            JSONArray personnesArray = (JSONArray) parsedJson.get(personnesKey);


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }


    }

}
