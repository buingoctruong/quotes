package com.vn.tb.quote.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "content", columnDefinition = "text", length = 32500)
	public String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Author author;
	
	// when crawling, change fetch to EAGER
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "quotes", fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<Collection> collections = new HashSet<>();
	
	// when crawling, change fetch to EAGER
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "quotes", fetch = FetchType.LAZY)
	@JsonIgnore
    private Set<Topic> topics = new HashSet<>();
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Collection> getCollections() {
		return collections;
	}

	public void setCollections(Set<Collection> collections) {
		this.collections = collections;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}
}
