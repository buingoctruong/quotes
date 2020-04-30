package com.vn.tb.quote.Model;

import javax.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
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
	
//	@ManyToMany(cascade = {
//		    CascadeType.PERSIST,
//		    CascadeType.MERGE }, fetch = FetchType.LAZY)
//	@JoinTable(name = "collection_quote",
//	    joinColumns = @JoinColumn(name = "collection_id", referencedColumnName = "id"),
//	    inverseJoinColumns = @JoinColumn(name = "quote_id", referencedColumnName = "id"))
//	@JsonIgnore
//	private Set<Quote> quotes = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
}
