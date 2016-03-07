package util;

import java.util.HashSet;
import java.util.Set;

public class Mapper {

	private static Set<String> diseaseKeywords = new HashSet<String>();
	

	public static Set<String> getDiseaseKeywords() {
		addDiseaseKeywords();
		return diseaseKeywords;
	}

	 static void addDiseaseKeywords() {
		diseaseKeywords.add("HEART");
		diseaseKeywords.add("ULCER");
		diseaseKeywords.add("KIDNEY");
		diseaseKeywords.add("LEUKEMIA");
		diseaseKeywords.add("DIABETES");
		
	}
	
	
	
	
}
