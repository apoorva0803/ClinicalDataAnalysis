package model;

import java.util.ArrayList;
import java.util.List;

import bean.Admission;
import bean.AdmissionDiagnosis;
import bean.Lab;
import bean.Patient;

public class ConfigList {

	private static ConfigList instance = null;
	
	public static ConfigList getInstance(){
		if(instance==null)
			instance = new ConfigList();
		
		return instance;
	}
	
	private static List<Patient> patientList = new ArrayList<Patient>();
	private static List<Admission> admissionList = new ArrayList<Admission>();
	private static List<AdmissionDiagnosis> diagnosisList = new ArrayList<AdmissionDiagnosis>();
	private static List<Lab> labList = new ArrayList<Lab>();
	
	public static List<Patient> getPatientList() {
		return patientList;
	}
	public void setPatientList(List<Patient> patientList) {
		ConfigList.patientList = patientList;
	}
	public static List<Admission> getAdmissionList() {
		return admissionList;
	}
	public void setAdmissionList(List<Admission> admissionList) {
		ConfigList.admissionList = admissionList;
	}
	public static List<AdmissionDiagnosis> getDiagnosisList() {
		return diagnosisList;
	}
	public void setDiagnosisList(List<AdmissionDiagnosis> diagnosisList) {
		ConfigList.diagnosisList = diagnosisList;
	}
	public static List<Lab> getLabList() {
		return labList;
	}
	public void setLabList(List<Lab> labList) {
		ConfigList.labList = labList;
	}
	
	
}
