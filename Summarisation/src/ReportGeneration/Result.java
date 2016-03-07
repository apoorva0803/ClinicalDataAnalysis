package ReportGeneration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import DAO.UserDao;
import util.Mapper;
import util.Util;

public class Result {

	public static void main(String args[]){
		UserDao ud = new UserDao();
		try {
			ud.preProcess();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FinalReport fr= new FinalReport();

		String input = "Enter query";
		System.out.println(input);
		Scanner sc = new Scanner(System.in);
		String query = sc.nextLine().trim();
		String[] words = query.split(" ");
		Map<String,Integer> countMap = new HashMap<String,Integer>();
		for (String word : words) {
			if (Mapper.getDiseaseKeywords().contains(word.toUpperCase())) {
				int number=Util.countNoOfPatients(word);
				countMap.put(word, number);				
			}
		}
		String report =  fr.getDiseaseCountSummary(countMap);
		System.out.println(report);
	}
}