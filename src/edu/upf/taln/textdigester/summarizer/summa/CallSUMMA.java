/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upf.taln.textdigester.summarizer.summa;


import static edu.upf.taln.textdigester.summarizer.summa.SUMMAAnalyser.AnalyseEnDocument;
import static edu.upf.taln.textdigester.summarizer.summa.SUMMAAnalyser.AnalyseEsDocument;
import static edu.upf.taln.textdigester.summarizer.summa.SUMMAAnalyser.AnalyseCaDocument;
import static edu.upf.taln.textdigester.summarizer.summa.SUMMAAnalyser.createSummaResources;
import edu.upf.taln.textdigester.summarizer.util.CreateSUMMAidfs;
import gate.Document;
import gate.Factory;
import gate.Gate;
import gate.util.GateException;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Horacio
 */
public class CallSUMMA {
    
    public static void main(String[] args) {
        
        try {
            
            Gate.init();
            runMulti();
        } catch(GateException ge) {
            
        }
    }
    
    
     public static void runMulti() {
        
        try {
           // Gate.init();
            Document enDoc1;
            Document enDoc2;
            Document enDoc3;
            // Spanish
            enDoc1=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\es_5f3f6cad0f935aacaa07c9d401f84dd9_body_GATE.xml"), "UTF-8");
        
            // English
            enDoc2=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\en_2c02d6960625b1d510098f7857f90ab9_body_GATE.xml"), "UTF-8");
        
            
            // Catalan
            enDoc3=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\es_9ca0c374a00f9e8e41b3221cb2793ed4_body_GATE.xml"), "UTF-8");
        
            
            createSummaResources();
            CreateSUMMAidfs.createIgnoreTags();
            
            // English
            AnalyseEnDocument(enDoc1);
            AnalyseEnDocument(enDoc2);
            AnalyseEnDocument(enDoc3);
            Document[] docs=new Document[3];
            docs[0]=enDoc1;
            docs[1]=enDoc2;
            docs[2]=enDoc3;
            Centroid.init();
            Centroid.setCorpus(docs);
            Centroid.run();
      
            System.out.println(">>>ENGLISH<<<");
            //CleanSUMMADocument.clean(enDoc);
            System.out.println(enDoc1.getAnnotations("Analysis").get("Sentence"));
           
        } catch(GateException ge) {
            Logger.getLogger(SUMMAAnalyser.class.getName()).log(Level.SEVERE, null, ge);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SUMMAAnalyser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallSUMMA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void runSingle() {
        
        try {
           // Gate.init();
            Document esDoc;
            Document enDoc;
            Document caDoc;
            // Spanish
            esDoc=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\es_3df84362f3b3995141528748a68408bd_body_GATE.xml"), "UTF-8");
        
            // English
            enDoc=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\en_2c02d6960625b1d510098f7857f90ab9_body_GATE.xml"), "UTF-8");
        
            
            // Catalan
            caDoc=Factory.newDocument(new 
        URL("file:///C:\\work\\programs\\hakathon\\data\\ca_1f80345fa12d9443e1e68feae1688be8_body_GATE.xml"), "UTF-8");
        
            
            createSummaResources();
            CreateSUMMAidfs.createIgnoreTags();
            
            // Spanish
            AnalyseEsDocument(esDoc);
            
            
      
            
           
            
            
            First.init();
            First.setDoc(esDoc);
            First.run();
            Frequency.init();
            Frequency.setDoc(esDoc);
            Frequency.run();
            Position.init();
            Position.setDoc(esDoc);
            Position.run();
            Semantic.init();
            Semantic.setDoc(esDoc);
            Semantic.run();
            DocSim.init();
            DocSim.setDoc(esDoc);
            DocSim.run();
            
            System.out.println(">>>SPANISH<<<");
            
            CleanSUMMADocument.clean(esDoc);
            System.out.println(esDoc.getAnnotations("Analysis").get("Sentence"));
              System.out.println(esDoc.getAnnotations("Analysis").get("Vector"));
            // English
            AnalyseEnDocument(enDoc);
            
            
      
            
           
            
            
            First.init();
            First.setDoc(enDoc);
            First.run();
            Frequency.init();
            Frequency.setDoc(enDoc);
            Frequency.run();
            Position.init();
            Position.setDoc(enDoc);
            Position.run();
            Semantic.init();
            Semantic.setDoc(enDoc);
            Semantic.run();
            DocSim.init();
            DocSim.setDoc(enDoc);
            DocSim.run();
            
            System.out.println(">>>ENGLISH<<<");
            CleanSUMMADocument.clean(enDoc);
            System.out.println(enDoc.getAnnotations("Analysis").get("Sentence"));
              System.out.println(enDoc.getAnnotations("Analysis").get("Vector"));
            // Catalan
            AnalyseCaDocument(caDoc);
            
            
      
            
           
            
            
            First.init();
            First.setDoc(caDoc);
            First.run();
            Frequency.init();
            Frequency.setDoc(caDoc);
            Frequency.run();
            Position.init();
            Position.setDoc(caDoc);
            Position.run();
            Semantic.init();
            Semantic.setDoc(caDoc);
            Semantic.run();
            DocSim.init();
            DocSim.setDoc(caDoc);
            DocSim.run();
            System.out.println(">>>CATALAN<<<");
            CleanSUMMADocument.clean(caDoc);
            System.out.println(caDoc.getAnnotations("Analysis").get("Sentence"));
            System.out.println(caDoc.getAnnotations("Analysis").get("Vector"));
        } catch(GateException ge) {
            Logger.getLogger(SUMMAAnalyser.class.getName()).log(Level.SEVERE, null, ge);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SUMMAAnalyser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CallSUMMA.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
