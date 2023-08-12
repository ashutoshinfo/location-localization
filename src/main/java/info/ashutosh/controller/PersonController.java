package info.ashutosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.ashutosh.aop.CheckValidation;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.domain.json.person.PersonRequest;
import info.ashutosh.service.PersonService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@CheckValidation
	@PostMapping(value = "/add")
	public CustomResponse addPerson(@RequestBody @Valid PersonRequest personRequest, BindingResult bindingResult) {

		return personService.addPerson(personRequest);
	}

	@GetMapping(value = "/get")
	public CustomResponse getAllPerson() {
		return personService.getAllPerson();
	}

}
