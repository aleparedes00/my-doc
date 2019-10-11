/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.revisions.main;

import com.cours.revisions.singletons.AbstractStatisticSingleton;
import com.cours.revisions.singletons.JsonStatisticSingleton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
public class MainRevisions {

    private static final Log log = LogFactory.getLog(MainRevisions.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractStatisticSingleton mySingleton;

        mySingleton = JsonStatisticSingleton.getInstance();

    }
}
