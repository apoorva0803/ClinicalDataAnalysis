package ReportGeneration;

import simplenlg.framework.*;
import simplenlg.lexicon.*;
import simplenlg.realiser.english.*;
import simplenlg.phrasespec.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import bean.AdmissionDiagnosis;
import simplenlg.features.*;
import util.*;

public class FinalReport {
	//private PatientReportContent reportContent;
	Lexicon lexicon = Lexicon.getDefaultLexicon();
	NLGFactory nlgFactory = new NLGFactory(lexicon);
	Realiser realiser = new Realiser(lexicon);
	
	SPhraseSpec p = nlgFactory.createClause();
	
	List<NPPhraseSpec> objects = new ArrayList<NPPhraseSpec>();
	CoordinatedPhraseElement obj = nlgFactory.createCoordinatedPhrase();
	CoordinatedPhraseElement sub = nlgFactory.createCoordinatedPhrase();
	
	
	public String getPatientAdmissionSummary(String patientId, List<AdmissionDiagnosis> diagnoses){
		String report = "";
		int admissionCount = 1;
		
		for(AdmissionDiagnosis diagnosis : diagnoses){
			
			NPPhraseSpec object = nlgFactory.createNounPhrase(diagnosis.getPrimaryDiagonsisDesc());
			object.addModifier("on " + Util.ordinal(admissionCount) + " admission");
			obj.addCoordinate(object);
			
			admissionCount++;
		}
		     
		VPPhraseSpec verb = nlgFactory.createVerbPhrase("diagnose with");
	    p.setFeature(Feature.TENSE, Tense.PAST);
	    p.setSubject("This patient");
	    p.setObject(obj);
	    p.setVerb(verb);
	    
	    String output2 = realiser.realiseSentence(p);
	    report = output2;
		return report;
	}
	
	public String getDiseaseCountSummary(Map<String,Integer> count){
		String report = "";

		Iterator<Entry<String, Integer>> keySet =count.entrySet().iterator();
		
		while (keySet.hasNext()) {
	        Map.Entry pair = (Map.Entry)keySet.next();
	        NPPhraseSpec object1 = nlgFactory.createNounPhrase(pair.getValue().toString());
	        NPPhraseSpec subject1 = nlgFactory.createNounPhrase(pair.getKey());
	        //subject1.addPostModifier("issues");
	        sub.addCoordinate(subject1);
	        obj.addCoordinate(object1);
		}
	
		sub.addPreModifier("Number of patients suffering from");
		sub.addPostModifier("issues");
		
		obj.setFeature(Feature.CONJUNCTION, "and");
		p.setVerb("is");
	    p.setSubject(sub);
	    p.setObject(obj);
	 
	    String output2 = realiser.realiseSentence(p);
	    report = output2;
		return report;
	}
}
