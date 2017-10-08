package controller;
import java.util.ArrayList;
import java.util.List;

import bean.Country;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/countries")

public class CountryController {
 
// @RequestMapping(method = RequestMethod.GET,headers="Accept=application/json")
 @RequestMapping("/countries")
 public List getCountries()
 { System.out.println("entering getcountries......");
  List listOfCountries = new ArrayList();
  listOfCountries=createCountryList();
  return listOfCountries;
 }

// @RequestMapping(value = "/country/{id}", method = RequestMethod.GET,headers="Accept=application/json")
 @RequestMapping("/country/{id}")
 public Country getCountryById(@PathVariable int id)
 {
	 System.out.println("entering getcountrybyid......");
  List listOfCountries = new ArrayList();
  listOfCountries=createCountryList();

  for (Object country: listOfCountries) {
   if(((Country)country).getId()==id)
    return(Country) country;
  }
  
  return null;
 }

// Utiliy method to create country list.
 public List createCountryList()
 {
  Country indiaCountry=new Country(1, "India");
  Country chinaCountry=new Country(4, "China");
  Country nepalCountry=new Country(3, "Nepal");
  Country bhutanCountry=new Country(2, "Bhutan");

  List listOfCountries = new ArrayList();
  listOfCountries.add(indiaCountry);
  listOfCountries.add(chinaCountry);
  listOfCountries.add(nepalCountry);
  listOfCountries.add(bhutanCountry);
  return listOfCountries;
 }
}

