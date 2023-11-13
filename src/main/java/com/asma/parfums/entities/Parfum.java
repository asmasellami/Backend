package com.asma.parfums.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Parfum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParfum;
	private String parfumName;
	private Double parfumPrice;
	private Date releasedate;
	
	@ManyToOne
	private Marque marque;

	
	public Parfum() {
		super();
		
	}
	
	
	public Parfum(String parfumName, Double parfumPrice, Date releasedate) {
		super();
		this.parfumName = parfumName;
		this.parfumPrice = parfumPrice;
		this.releasedate = releasedate;
	}


	public Long getIdParfum() {
		return idParfum;
	}
	public void setIdParfum(Long idParfum) {
		this.idParfum = idParfum;
	}
	public String getParfumName() {
		return parfumName;
	}
	public void setParfumName(String ParfumName) {
		this.parfumName = ParfumName;
	}
	public Double getParfumPrice() {
		return parfumPrice;
	}
	public void setParfumPrice(Double parfumPrice) {
		this.parfumPrice = parfumPrice;
	}
	public Date getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}



	public Marque getMarque() {
		return marque;
	}


	public void setMarque(Marque marque) {
		this.marque = marque;
	}


	@Override
	public String toString() {
		return "Parfum [idParfum=" + idParfum + ", ParfumName=" + parfumName + ", ParfumPrice=" + parfumPrice
				+ ", releasedate=" + releasedate + "]";
	}
	
	
	
	
	

}
