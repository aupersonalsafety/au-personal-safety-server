package com.au.personal.safety.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.au.personal.safety.email.Email;
import com.au.personal.safety.email.EmailMessage;
import com.au.personal.safety.users.User;
import com.au.personal.safety.validator.EmailResourceValidator;
import com.au.personal.safety.alerts.SendAlerts;


/*
 * Purpose: to use the SendAlerts class to send alerts to all contacts for the corresponding user
 */
public class SendAlertsResource {
	
	
	@POST
	@Path("/alertcontacts")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendAlerts(int userID_IN) {
		Response result = null;
		
		//get user for inputted UserID value
		SendAlerts aSendAlertsObj = new SendAlerts(userID_IN);
		//SendAlerts(User userIN)
		Response theResponse = aSendAlertsObj.alertContacts();
		result = theResponse;
		return result;

	}
	
}