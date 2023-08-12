package info.ashutosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.domain.entity.location.Country;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.CountryRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;

@Service
public class CountryService {

//	@Autowired
//	EntityManager entityManager;

	@Autowired
	CountryRepository countryRepository;

	public CustomResponse getCountriesBasedOnLaguageId(String laguageId) {

		Integer stringToLong = CommonMethod.stringToInteger(laguageId);

		if (stringToLong == null) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}

		List<Country> findBylaguageId = countryRepository.findByLanguage_Id(stringToLong);// <-- Error

		if (findBylaguageId.isEmpty()) {

			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, findBylaguageId, null);

	}

//	public List<Country> findCountriesByLanguageId2(Long languageId) {
//		String hql = "SELECT c FROM Country c WHERE c.language.id = :languageId";
//		return entityManager.createQuery(hql, Country.class).setParameter("languageId", languageId).getResultList();
//	}

}
