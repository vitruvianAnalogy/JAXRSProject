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

import org.vitruvian.javalearn.JAXRSProject.model.Message;
import org.vitruvian.javalearn.JAXRSProject.model.Profile;
import org.vitruvian.javalearn.JAXRSProject.service.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	//How to accept parameters in the url path, for e.g. /messages/1, to accept 1 or 2 , etc.
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName){ //Automatic conversion from String to long, can lead to error if a bad value is passed
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteMessage(@PathParam("profileName") String profileName){
		profileService.removeProfile(profileName);
	}

}
