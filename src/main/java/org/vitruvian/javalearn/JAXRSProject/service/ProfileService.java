package org.vitruvian.javalearn.JAXRSProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vitruvian.javalearn.JAXRSProject.database.DatabaseClass;
import org.vitruvian.javalearn.JAXRSProject.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("neo", new Profile(1L, "neo", "Nishant", "Rawat"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name){
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile (String name){
		return profiles.remove(name);
	}
}
