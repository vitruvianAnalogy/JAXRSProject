package org.vitruvian.javalearn.JAXRSProject.service;

import java.util.ArrayList;
import java.util.List;

import org.vitruvian.javalearn.JAXRSProject.model.Message;

public class MessageService {

	public List<Message> getAllMessages(){
		
		Message m1 = new Message(1L, "Hello world", "Nishant");
		Message m2 = new Message(1L, "Hello nature", "Nishant");
		
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		
		return list;
		
	}
}
