/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upf.taln.textdigester.summarizer.summa;

import gate.Corpus;
import gate.Factory.*;
import gate.Document;
import gate.Factory;
import gate.creole.ResourceInstantiationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio
 */
public class Centroid {
    
    public static summa.mds.DocumentCentroidSimilarity centroidSim;
     public static summa.mds.CentroidComputation computeCentroid;
    public static void init() {
        centroidSim=new summa.mds.DocumentCentroidSimilarity();
        computeCentroid=new summa.mds.CentroidComputation();
        centroidSim.setCentroid("centroid");
        centroidSim.setAnnSet("Analysis");
        centroidSim.setSentAnn("Sentence");
        centroidSim.setSentVec("Vector_Norm");
        
    }
    
    public static void setCorpus(Document[] docs) {
        Corpus c=null;
        try {
            c = Factory.newCorpus("");
        } catch (ResourceInstantiationException ex) {
            Logger.getLogger(Centroid.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int d=0;d<docs.length;d++) {
            c.add(docs[d]);
        }
        computeCentroid.setAnnSet("Analysis");
        computeCentroid.setVecName("DocVector_Norm");
        computeCentroid.setCorpus(c);
        centroidSim.setCorpus(c);
    }
    
    public static void run() {
        computeCentroid.execute();
        centroidSim.execute();
        
    }
}
