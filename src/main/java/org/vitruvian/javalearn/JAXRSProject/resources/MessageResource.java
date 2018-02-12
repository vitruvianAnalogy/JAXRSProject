package org.vitruvian.javalearn.JAXRSProject.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
