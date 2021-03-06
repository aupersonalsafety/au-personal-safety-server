package com.au.personal.safety.resource;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.au.personal.safety.email.Email;
import com.au.personal.safety.email.EmailMessage;
import com.au.personal.safety.validator.EmailResourceValidator;

@Path("/email")
public class EmailResource {	
	
	@POST
	@Path("/sendtophone")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendEmailToPhone(EmailMessage emailMessage) {
		Response response = null;
		EmailResourceValidator validator = new EmailResourceValidator(emailMessage);
		if(validator.validate()) {
			Email email = new Email(emailMessage);
			response = email.sendMessage();
		} else {
			response = validator.getResponse();
		}
		
		return response;

	}

}
