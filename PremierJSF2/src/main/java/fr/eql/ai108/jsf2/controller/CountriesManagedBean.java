package fr.eql.ai108.jsf2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean (name = "mbCountries")
@ViewScoped
public class CountriesManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> countries = new ArrayList<String>();
	private List<String> cities = new ArrayList<String>();
	private String selectedCountry;
	private String selectedCity;
	private Map<String, List<String>> mapCities = new HashMap<String, List<String>>();
	
	public void onCountryChange() {
		if(selectedCountry != null && !selectedCountry.equals("")) {
			cities = mapCities.get(selectedCountry);
		}else {
			cities = new ArrayList<String>();
		}
	}
	
	@PostConstruct
	public void init() {
		countries.add("France");
		countries.add("Burkina Faso");
		countries.add("USA");
		
		List<String> villesFrance = new ArrayList<String>();
		villesFrance.add("Paris");
		villesFrance.add("Lyon");
		villesFrance.add("Lille");
		
		List<String> villesBurkina = new ArrayList<String>();
		villesBurkina.add("Ouagadougou");
		villesBurkina.add("Bobo Dioulasso");
		villesBurkina.add("Fada N'Gourma");
		
		List<String> villesUSA = new ArrayList<String>();
		villesUSA.add("New Orleans");
		villesUSA.add("Charlotte");
		villesUSA.add("Boston");
		
		mapCities.put("France", villesFrance);
		mapCities.put("Burkina Faso", villesBurkina);
		mapCities.put("USA", villesUSA);
	}
	
	public List<String> getCountries() {
		return countries;
	}
	public void setCountries(List<String> countries) {
		this.countries = countries;
	}
	public List<String> getCities() {
		return cities;
	}
	public void setCities(List<String> cities) {
		this.cities = cities;
	}
	public String getSelectedCountry() {
		return selectedCountry;
	}
	public void setSelectedCountry(String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}
	public String getSelectedCity() {
		return selectedCity;
	}
	public void setSelectedCity(String selectedCity) {
		this.selectedCity = selectedCity;
	}
	public Map<String, List<String>> getMapCities() {
		return mapCities;
	}
	public void setMapCities(Map<String, List<String>> mapCities) {
		this.mapCities = mapCities;
	}
}
