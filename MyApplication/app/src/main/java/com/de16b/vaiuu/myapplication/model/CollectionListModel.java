package com.de16b.vaiuu.myapplication.model;

public class CollectionListModel {

	private String name;
	private String mobile;
	private String photo;
	private String email;
	private String facebook;
	private String Linkdin;
	private String skype;
	private String viber;
	private String twitter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getLinkdin() {
		return Linkdin;
	}

	public void setLinkdin(String linkdin) {
		Linkdin = linkdin;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getViber() {
		return viber;
	}

	public void setViber(String viber) {
		this.viber = viber;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	@Override
	public String toString() {
		return "CollectionListModel{" +
				"name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", photo='" + photo + '\'' +
				", email='" + email + '\'' +
				", facebook='" + facebook + '\'' +
				", Linkdin='" + Linkdin + '\'' +
				", skype='" + skype + '\'' +
				", viber='" + viber + '\'' +
				", twitter='" + twitter + '\'' +
				'}';
	}
}
