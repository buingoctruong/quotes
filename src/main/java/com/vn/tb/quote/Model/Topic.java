package com.vn.tb.quote.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "topic")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "name", nullable = false)
	public String name;
	
	@Column(name = "link")
	public String link;
	
	@Column(name = "count")
	public Integer count;
	
	@Column(name = "image")
	public String image;
	
	@Column(name = "profile", columnDefinition = "text", length = 32500)
	public String profile;
	
	// when crawling, change fetch to EAGER
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "topic_quote",
	    joinColumns = @JoinColumn(name = "topic_id", referencedColumnName = "id"),
	    inverseJoinColumns = @JoinColumn(name = "quote_id", referencedColumnName = "id"))
	@JsonIgnore
	private Set<Quote> quotes = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public Integer getCount() {
		return count;
	}

	public String getImage() {
		return image;
	}

	public String getProfile() {
		return profile;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Set<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(Set<Quote> quotes) {
		this.quotes = quotes;
	}
}
