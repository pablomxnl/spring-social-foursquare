package org.springframework.social.foursquare.api;

public class FoursquareUser {
	
	private final String id;
	private final String firstName;
	private final String lastName;
	private final UserPhoto photo;
	private final String gender;
	private final String homeCity;
	private String relationship;
	private boolean pings;
	private ContactInfo contactInfo;
	private MayorshipInfo mayorshipInfo;
	private CheckinInfo checkinInfo;
	private FriendInfo friendInfo;
	private Scores scores;
	
	public FoursquareUser(String id, String firstName, String lastName, UserPhoto photo,
			String gender, String homeCity, String relationship) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.gender = gender;
		this.homeCity = homeCity;
		this.relationship = relationship;
	}
	public FoursquareUser(String id, String firstName, String lastName, UserPhoto photo,
			String gender, String homeCity) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.gender = gender;
		this.homeCity = homeCity;
		
	}
	
 
	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public UserPhoto getPhoto() {
		return photo;
	}

	public String getGender() {
		return gender;
	}

	public String getHomeCity() {
		return homeCity;
	}

	public String getRelationship() {
		return relationship;
	}

	public boolean hasPings() {
		return pings;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	
	public MayorshipInfo getMayorshipInfo() {
		return mayorshipInfo;
	}

	public CheckinInfo getCheckinInfo() {
		return checkinInfo;
	}

	public FriendInfo getFriendInfo() {
		return friendInfo;
	}

	public Scores getScores() {
		return scores;
	}

}
