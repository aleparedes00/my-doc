package com.dao.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.cours.revisions.entities.Personne;
import com.cours.revisions.factory.SingletonFactory;
import com.cours.revisions.helper.PersonneHelper;
import com.cours.revisions.singletons.AbstractStatisticSingleton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class JUnitTestRevisions {

    private static final Log log = LogFactory.getLog(JUnitTestRevisions.class);
//    private static AbstractStatisticSingleton singletonCsv = null;
//    private static AbstractStatisticSingleton singletonXml = null;
    private static AbstractStatisticSingleton singletonJson = null;
    private static PersonneHelper personneHelper = null;

    @BeforeClass
    public static void init(){
        singletonJson = SingletonFactory.getFactory(SingletonFactory.FactorySingletonType.JSON_SINGLETON_FACTORY);
        personneHelper = new PersonneHelper();
        Assert.assertNotNull(singletonJson);
    }

    @Test
    public void testJUnitAllCalculMoyenneEcartType() {
        log.debug("Entree de la methode");
//        testJUnitCalculMoyenneEcartType(singletonCsv);
//        testJUnitCalculMoyenneEcartType(singletonXml);
        testJUnitCalculMoyenneEcartType(singletonJson);
        log.debug("Sortie de la methode");
    }

    private void testJUnitCalculMoyenneEcartType(AbstractStatisticSingleton singleton) {
        log.debug("===MEAN WEIGHTS=== ");
        Assert.assertTrue(compareDoubles(68.6500, singleton.getMeanWeights()));
        Assert.assertTrue(compareDoubles(17.4707, singleton.getStandardDeviationWeights()));
        log.debug("===MEAN HIGHS===");
        Assert.assertTrue(compareDoubles(166.0500, singleton.getMeanHighs()));
        Assert.assertTrue(compareDoubles(17.6138, singleton.getStandardDeviationHighs()));
    }

    @Test
    public void testCreatePersonnes() {
        personneHelper.addPersonne(1, "Maurice", "Dupont", 100.0, 170.0, "rue du paradis", "Rouen", "76000");
        personneHelper.addPersonne(2, "Martin", "Marshall", 55.0, 150.0, "rue de Nantes", "Laval", "53000");
        personneHelper.addPersonne(3, "Claire", "Chazal", 65.0, 175.0, "rue de Rennes", "Laval", "53000");
        personneHelper.addPersonne(4, "Celine", "Dia", 87.0, 170.0, "rue Diderot", "Paris", "75000");
        personneHelper.addPersonne(5, "Remy", "Cheval", 63.0, 140.0, "rue du paradis", "Nantes", "44000");
        Assert.assertEquals(5, personneHelper.getPersonnes().size());
    }

    @AfterClass
    public static void terminate(){
        log.debug("Entree de la methode");
//        singletonCsv = null;
//        singletonXml = null;
        singletonJson = null;
        personneHelper = null;
        log.debug("Sortie de la methode");
    }

    private static Boolean compareDoubles(Double d1, Double d2) {
        return (Math.abs(d1 - d2) < 1e-4);
    }
}
