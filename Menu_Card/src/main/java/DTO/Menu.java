package DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,unique = true)
	private String dish;
	
	@Column(nullable = false,unique = true)
	private String quantity_in_kg;
	
	@Column(nullable = false,unique = true)
	private String price_per_kg;

	public int getId() {
		return id;
	}

	public String getDish() {
		return dish;
	}

	public void setDish(String dish) {
		this.dish = dish;
	}

	public String getQuantity_in_kg() {
		return quantity_in_kg;
	}

	public void setQuantity_in_kg(String quantity_in_kg) {
		this.quantity_in_kg = quantity_in_kg;
	}

	public String getPrice_per_kg() {
		return price_per_kg;
	}

	public void setPrice_per_kg(String price_per_kg) {
		this.price_per_kg = price_per_kg;
	}
	
}
