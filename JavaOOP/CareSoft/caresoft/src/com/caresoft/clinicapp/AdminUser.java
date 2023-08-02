package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
	private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
    
    AdminUser ( Integer ID, String role ) {
    	
    	this.employeeID = ID;
    	
    	this.role = role;
    	
    }
    
    // TO DO: Implement HIPAACompliantUser!
    
    public boolean assignPin ( int pin ) {
    	
    	boolean condition = String.valueOf( pin ).length() == 4;
    	
    	if ( condition ) {
    		
    		this.setPin( pin );
    		
    		return true;
    		
    	}
    	
    	return false;
    	
    }
    
    public boolean accessAuthorized ( Integer confirmedAuthID ) {
    	
    	boolean condition = confirmedAuthID == this.id;
    	
    	if ( !condition ) {
    		
    		this.authIncident();
    		
    		return false;
    		
    	}
    	
    	return true;
    	
    }
    
    // TO DO: Implement HIPAACompliantAdmin!
    
    public ArrayList<String> reportSecurityIncidents () {
    	
    	return this.securityIncidents;
    	
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    
    ArrayList<String> getSecurityIncidents () {
    	
    	return this.securityIncidents;
    	
    }
    
    AdminUser setSecurityIncidents ( ArrayList<String> securityIncidents ) {
    	
    	this.securityIncidents = securityIncidents;
    	
    	return this;
    	
    }
    
}
