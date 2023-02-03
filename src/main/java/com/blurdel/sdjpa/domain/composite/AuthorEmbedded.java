package com.blurdel.sdjpa.domain.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "author_composite")
public class AuthorEmbedded {

	@EmbeddedId
	private NameId nameid;
	
	private String country;
	

	public AuthorEmbedded() {
	}
	
	public AuthorEmbedded(NameId nameid) {
		this.nameid = nameid;
	}

	public NameId getNameid() {
		return nameid;
	}
	public void setNameid(NameId nameid) {
		this.nameid = nameid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "AuthorEmbedded [nameid=" + nameid + ", country=" + country + "]";
	}
	
}
