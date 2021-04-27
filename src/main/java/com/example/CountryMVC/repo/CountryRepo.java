package com.example.CountryMVC.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CountryMVC.model.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer> {

}
