package com.example.CountryMVC.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.CountryMVC.model.Country;
import com.example.CountryMVC.service.CountryService;

@Controller
public class HomeController implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// registry.addViewController("/results").setViewName("results");
	}

	@Autowired
	CountryService countryService;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/list_countries")
	public String listCountries(Model model) {
		List<Country> listCountries = countryService.getCountryList();
		model.addAttribute("countries", listCountries);

		return "countries";
	}

	@RequestMapping("/delete/{id}") // id is path variable
	public String deleteEmployee(@PathVariable(name = "id") int id) {// not return any data back, so not use model
		countryService.delete(id);
		return "redirect:/list_countries";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");// add a view
		Country country = countryService.get(id);

		mav.addObject("country", country);// fetch the "country" details from the database
		return mav; // key-value pairs into key "country", the mav("edit_country" view) now can
					// get it
					// through "country"
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCountry(@Valid @ModelAttribute("country") Country c) {// receive
																			// "country"
																			// from view
		// "edit_country" as
		// "c"

		countryService.saveCountry(c);
		return "redirect:/list_countries";

	}

	@GetMapping("/new")
	public String showCountryForm(Model model) {
		Country e = new Country();
		model.addAttribute("country_new", e);
		return "new_country";
	}

	@PostMapping("/new")
	public String submitNewCountryForm(@Valid @ModelAttribute("country_new") Country country_new, //
			BindingResult bindingResult) {
		System.out.println(country_new);
		System.out.println(bindingResult);
		if (bindingResult.hasErrors()) {
			return "new_country";
		} else {
			countryService.saveCountry(country_new);
			return "new_country_success";
		}
	}

	@RequestMapping("/showDetails/{id}")
	public ModelAndView showCountryDetails(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("show_country_detail");// add a view
		Country country = countryService.get(id);

		mav.addObject("country", country);// fetch the "country" details from the database
		return mav; // key-value pairs into key "country", the mav("show_country_detail" view) now
					// can
					// get it
					// through "country"
	}
}
