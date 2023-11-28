package com.asma.parfums.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


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
	
	
	/*@OneToOne
	private Image image;
*/
	
	@OneToMany (mappedBy = "parfum")
	 private List<Image> images;
	
	private String imagePath;
	
	
	
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


	public List<Image> getImages() {
		return images;
	}


	public void setImages(List<Image> images) {
		this.images = images;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	/*public Image getImage() {
		return image;
	}


	public void setImage(Image image) {
		this.image = image;
	}*/
	
	
	
	
	

}
