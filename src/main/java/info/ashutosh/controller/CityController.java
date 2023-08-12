package info.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;

	@GetMapping(value = "/get")
	public CustomResponse getcitiesBasedOnLaguageIdAndcountryId(
			@RequestParam("languageId") String languageId,
			@RequestParam("countryId") String countryId) {
		return cityService.getcitiesBasedOnLaguageIdAndcountryId(languageId, countryId);
	}

}
