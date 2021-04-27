package com.example.CountryMVC.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "country000")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Size(min = 3, max = 50)
	String name;

	@NotNull
	String capital;

	@NotNull
	String population;

	@NotNull
	int countryCode;

	public Country() {

	}

	public Country(int id, String name, String capital, String population, int countryCode) {
		this.id = id;
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.countryCode = countryCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + ", population=" + population
				+ ", countryCode=" + countryCode + "]";
	}

}
