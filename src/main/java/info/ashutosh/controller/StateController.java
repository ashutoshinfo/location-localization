package info.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {

	@Autowired
	StateService stateService;

	@GetMapping(value = "/get")
	public CustomResponse getMethodName(
	        @RequestParam("languageId") String languageId,
	        @RequestParam("countryId") String countryId) {
		return stateService.getCountriesBasedOnLaguageIdAndcountryId(languageId,countryId);
	}

}
