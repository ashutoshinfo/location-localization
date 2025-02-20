package info.ashutosh.controller;

import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/language")
public class LanguageController {

	@Autowired
	LanguageService languageService;

	@GetMapping(value = "/get")
	public CustomResponse getLanguages() {
		return languageService.getLanguages();
	}

}
