package info.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService personService;

	@GetMapping(value = "/get/{id}")
	public CustomResponse getMethodName(@PathVariable("id") String laguageId) {
		return personService.getCountriesBasedOnLaguageId(laguageId);
	}

}
