package org.vitruvian.javalearn.JAXRSProject.database;

import java.util.HashMap;
import java.util.Map;

import org.vitruvian.javalearn.JAXRSProject.model.Message;
import org.vitruvian.javalearn.JAXRSProject.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<Long,Message>();
	private static Map<String, Profile> profiles = new HashMap<String,Profile>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

}
