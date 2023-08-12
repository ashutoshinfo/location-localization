package info.ashutosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.domain.entity.location.State;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.StateRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;

@Service
public class StateService {

	@Autowired
	StateRepository stateRepository;

	public CustomResponse getCountriesBasedOnLaguageIdAndcountryId(String laguageId, String countryId) {

		Long trimLaguageId = CommonMethod.stringToLong(laguageId);
		Long trimCountryId = CommonMethod.stringToLong(countryId);

		if (trimLaguageId == null && trimCountryId == null) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}

		List<State> findBylaguageId = stateRepository.findByLanguage_IdAndCountry_Id(trimLaguageId, trimCountryId);

		if (findBylaguageId.isEmpty()) {

			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, findBylaguageId, null);

	}

}
