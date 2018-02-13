package org.vitruvian.javalearn.JAXRSProject.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.vitruvian.javalearn.JAXRSProject.model.Message;
import org.vitruvian.javalearn.JAXRSProject.resources.beans.MessageFilterBean;
import org.vitruvian.javalearn.JAXRSProject.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
																				  @QueryParam("start") int start,
																				  @QueryParam("size") int size){
		if (year > 0)
			return messageService.getAllMessagesForYear(year);
		if(start>=0 && size >0)
			return messageService.getAllMessagesPaginated(start, size);
		return messageService.getAllMessages();
	}
	
	//This method is used to understand Bean Param and does the exact same job as "getMessages" method
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Message> duplicateGetMessages(@BeanParam MessageFilterBean filterBean){
//		if (filterBean.getYear() > 0)
//			return messageService.getAllMessagesForYear(filterBean.getYear());
//		if(filterBean.getStart()>=0 && filterBean.getSize() >=0)
//			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
//		return messageService.getAllMessages();
//	}
	
	
	//How to accept parameters in the url path, for e.g. /messages/1, to accept 1 or 2 , etc.
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId){ //Automatic conversion from String to long, can lead to error if a bad value is passed
		return messageService.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId, Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId){
		messageService.removeMessage(messageId);
	}

	//No GET method specified, since it is a sub resource
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
	
}
