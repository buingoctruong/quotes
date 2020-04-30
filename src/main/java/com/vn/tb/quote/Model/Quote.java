package com.vn.tb.quote.Model;

import javax.persistence.*;

@Entity
@Table(name = "quote")
public class Quote {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "content", columnDefinition = "text", length = 32500)
	public String content;
	
	@Column(name = "author")
	public String author;
	
	@Column(name = "collection")
	public String collection;
	
	@Column(name = "topic")
	public String topic;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn
//    private Author author;
	
//	@ManyToMany(cascade = {
//		    CascadeType.PERSIST,
//		    CascadeType.MERGE }, mappedBy = "quotes", fetch = FetchType.LAZY)
//	@JsonIgnore
//    private Set<Collection> collections = new HashSet<>();
//	
//	@ManyToMany(cascade = {
//		    CascadeType.PERSIST,
//		    CascadeType.MERGE }, mappedBy = "quotes", fetch = FetchType.LAZY)
//	@JsonIgnore
//    private Set<Topic> topics = new HashSet<>();
	

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
}
