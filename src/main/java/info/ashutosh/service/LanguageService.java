package info.ashutosh.service;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.entity.person.Language;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.CityRepository;
import info.ashutosh.repository.LanguageRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;

	public CustomResponse getLanguages() {


		List<Language> findBylaguageId = languageRepository.findAll();

		if (findBylaguageId.isEmpty()) {

			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, findBylaguageId, null);
	}

}
