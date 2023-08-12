package info.ashutosh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.entity.location.Country;
import info.ashutosh.domain.entity.location.State;
import info.ashutosh.domain.entity.person.Language;
import info.ashutosh.domain.entity.person.Person;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.domain.json.person.PersonRequest;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.CityRepository;
import info.ashutosh.repository.CountryRepository;
import info.ashutosh.repository.LaguageRepository;
import info.ashutosh.repository.PersonRepository;
import info.ashutosh.repository.StateRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	LaguageRepository laguageRepository;

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	StateRepository stateRepository;

	@Autowired
	CityRepository cityRepository;

	public CustomResponse addPerson(PersonRequest personRequest) {

		String reqName = CommonMethod.trimString(personRequest.getName());

		Long reqLanguageId = CommonMethod.stringToLong(personRequest.getLanguage());

		Long reqCountryd = CommonMethod.stringToLong(personRequest.getCountryId());
		Long reqStateId = CommonMethod.stringToLong(personRequest.getStateId());
		Long reqCityId = CommonMethod.stringToLong(personRequest.getCityId());

		Optional<Language> language = laguageRepository.findById(reqLanguageId);
		if (!language.isPresent()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null,
					"Language: " + reqLanguageId.toString());
		}

		Optional<Country> country = countryRepository.findById(reqCountryd);
		if (!country.isPresent()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "Country: " + reqCountryd.toString());
		}

		Optional<State> state = stateRepository.findById(reqStateId);
		if (!state.isPresent()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "State: " + reqStateId.toString());
		}

		Optional<City> city = cityRepository.findById(reqCityId);
		if (!city.isPresent()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "City: " + reqCityId.toString());
		}

		Person person = new Person();

		person.setName(reqName);

		person.setLanguage(language.get());

		person.setCountry(country.get());
		person.setState(state.get());
		person.setCity(city.get());

		personRepository.save(person);

		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, null, null);
	}

	public CustomResponse getAllPerson() {

		List<Person> allPerson = personRepository.findAll();

		if (allPerson.isEmpty()) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, null);
		}

		return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, allPerson, null);
	}

}
