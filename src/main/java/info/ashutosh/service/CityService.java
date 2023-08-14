package info.ashutosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.CityRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;

@Service
public class CityService {

	@Autowired
	CityRepository cityRepository;

	public CustomResponse getcitiesBasedOnLaguageIdAndcountryId(String laguageId, String stateId) {

		Long trimLaguageId = CommonMethod.stringToLong(laguageId);
		Long trimStateId = CommonMethod.stringToLong(stateId);

		if (trimLaguageId == null && trimStateId == null) {
			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}

		List<City> findBylaguageId = cityRepository.findByLanguage_IdAndState_Id(trimLaguageId, trimStateId);

		if (findBylaguageId.isEmpty()) {

			return ResponseUtil.prepareResponse(ResponseStatus.NOT_EXIST, null, "No Record Found !");
		}
		return ResponseUtil.prepareResponse(ResponseStatus.SUCCESS, findBylaguageId, null);
	}

}
