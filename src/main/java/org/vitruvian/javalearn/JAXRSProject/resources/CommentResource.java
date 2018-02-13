package org.vitruvian.javalearn.JAXRSProject.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vitruvian.javalearn.JAXRSProject.model.Comment;
import org.vitruvian.javalearn.JAXRSProject.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId){
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment){
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment){
		comment.setId(commentId);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("commentId") long commentId, @PathParam("messageId") long messageId){
		commentService.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("{commentId}")
	public Comment getMessage(@PathParam("commentId") long commentId,  @PathParam("messageId") long messageId){
		return commentService.getComment(messageId, commentId);
	}
}
