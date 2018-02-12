package org.vitruvian.javalearn.JAXRSProject.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vitruvian.javalearn.JAXRSProject.model.Message;
import org.vitruvian.javalearn.JAXRSProject.service.MessageService;

@Path("messages")
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	
	//How to accept parameters in the url path, for e.g. /messages/1, to accept 1 or 2 , etc.
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Message getMessage(@PathParam("messageId") long messageId){ //Automatic conversion from String to long, can lead to error if a bad value is passed
		return messageService.getMessage(messageId);
	}
}
