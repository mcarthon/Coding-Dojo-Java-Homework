package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	private ArrayList<String> patientNotes = new ArrayList<String>();
	
	// TO DO: Constructor that takes an IDcopy
	
	Physician ( Integer IDcopy ) {
		
		this.setId( IDcopy );
		
	}
	
    // TO DO: Implement HIPAACompliantUser!
	
	public boolean assignPin ( int pin ) {
		
		boolean condition = String.valueOf( pin ).length() == 4; 
		
		if ( condition ) {
			
			this.setPin( pin );
			
			return condition;
			
		}
		
		return condition;		
		
	}
	
	public boolean accessAuthorized ( Integer confirmedAuthID ) {
		
		return confirmedAuthID == this.id;
		
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
    // TO DO: Setters & Getters
	
	ArrayList<String> getPatientNotes () {
		
		return this.patientNotes;
		
	}
	 
	Physician setPatientNotes ( ArrayList<String> patientNotes ) {
		
		this.patientNotes = patientNotes;
		
		return this;
		
	}

}
