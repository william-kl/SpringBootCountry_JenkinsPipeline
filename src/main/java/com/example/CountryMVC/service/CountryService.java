package com.example.CountryMVC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CountryMVC.model.Country;
import com.example.CountryMVC.repo.CountryRepo;

@Service
public class CountryService {
	@Autowired
	CountryRepo countryRepo;

	public List<Country> getCountryList() {
		return countryRepo.findAll();
	}

	public void delete(int id) {
		countryRepo.deleteById(id);
	}

	public Country get(int i) {
		return countryRepo.findById(i).get();
	}

	public void saveCountry(Country c) {
		countryRepo.save(c);
	}
}
