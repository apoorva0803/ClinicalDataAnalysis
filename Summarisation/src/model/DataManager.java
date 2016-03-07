package model;

import java.util.ArrayList;
import java.util.List;

import bean.Admission;
import bean.AdmissionDiagnosis;
import bean.Lab;
import bean.Patient;

public class DataManager {

	/**
	 * Returns a patient's diagnoses
	 * @param patient
	 * @return
	 */
	public static List<AdmissionDiagnosis> getPatientDiagnosis(Patient patient){
		List<AdmissionDiagnosis> diagnosisList = ConfigList.getDiagnosisList();
		
		List<AdmissionDiagnosis> patientDiagnosis = new ArrayList<AdmissionDiagnosis>();
//		System.out.println("diag zise is: "+ diagnosisList.size());
//		System.out.println(diagnosisList.get(1).getPatientId());
		
		for (AdmissionDiagnosis diagnosis :diagnosisList){
			
			if (diagnosis.getPatientId().equals(patient.getPatientId()) ){
//				System.out.println(diagnosis.getPrimaryDiagonsisDesc());
				patientDiagnosis.add(diagnosis);
			}
		}
		
		return patientDiagnosis;
	}
	
	/**
	 * Returns the lab results for specific patient in specific admission
	 * @param patient
	 * @param admissionId
	 * @return
	 */
	public static List<Lab> getPatientLabRsultsForAdmission(Patient patient, int admissionId){
		List<Lab> diagnosisList = ConfigList.getLabList();
		
		List<Lab> patientLabResults = new ArrayList<Lab>();
		
		for (Lab labResult :patientLabResults){
			if (labResult.getPatientId().equals(patient.getPatientId()) && labResult.getAdmissionId() == admissionId)
				patientLabResults.add(labResult);
		}
		
		return patientLabResults;
	}
	
	/**
	 * Returns list of admissions for a patient 
	 * @param patient
	 * @return
	 */
	public static List<Admission> getPatientAdmissions(Patient patient){
		List<Admission> diagnosisList = ConfigList.getAdmissionList();
		List<Admission> patientAdmissions = new ArrayList<Admission>();
		
		for (Admission admission :patientAdmissions){
			if (admission.getPatientId().equals(patient.getPatientId()))
				diagnosisList.add(admission);
		}
		return diagnosisList;
	}
}
