package com.skilldistillery.booknerds.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	@Column(name = "cover_image_url")
	private String coverImageUrl;
	
	@ManyToOne
	@JoinColumn(name = "added_by_id")
	private User addedBy;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;

	@JsonIgnoreProperties({"favoriteBooks"})
	@ManyToMany(mappedBy = "favoriteBooks")
	private List<User> favoritedByUsers;
	
	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<User> getFavoritedByUsers() {
		return favoritedByUsers;
	}

	public void setFavoritedByUsers(List<User> favoritedByUsers) {
		this.favoritedByUsers = favoritedByUsers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", coverImageUrl=" + coverImageUrl + "]";
	}

}
