package com.scrybtye.vgmicroservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VideoGame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true, nullable = false)	
	private String name;
	
	private double price;
	
	@Column(columnDefinition = "varchar(2) default 'E'") 
	private String audienceRating;
	
	private String category;
	
	
	public VideoGame(Long id, String name, double price, String audienceRating, String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.audienceRating = audienceRating;
		this.category = category;
	}
	
	
	public VideoGame() {
		this(-1L, "N/A", 0.0, "N/A", "N/A");
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getAudienceRating() {
		return audienceRating;
	}


	public void setAudienceRating(String audienceRating) {
		this.audienceRating = audienceRating;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "VideoGame [id=" + id + ", name=" + name + ", price=" + price + ", audienceRating=" + audienceRating
				+ ", category=" + category + "]";
	}
	

}
