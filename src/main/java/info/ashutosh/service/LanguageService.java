package info.ashutosh.service;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.entity.person.Language;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.dtos.CityDTO;
import info.ashutosh.dtos.CountryDTO;
import info.ashutosh.dtos.LanguageDTO;
import info.ashutosh.dtos.StateDTO;
import info.ashutosh.enums.ResponseStatus;
import info.ashutosh.repository.CityRepository;
import info.ashutosh.repository.LanguageRepository;
import info.ashutosh.util.CommonMethod;
import info.ashutosh.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<LanguageDTO> getAllLanguages() {
        List<Language> languages = languageRepository.findAll();

        // Map to DTO
        return languages.stream()
            .map(language -> {
                LanguageDTO dto = new LanguageDTO();
                dto.setId(language.getId());  // Set the id
                dto.setLanguageName(language.getName());  // Set the name

                // Map countries to DTOs
                List<CountryDTO> countryDTOs = language.getCountries().stream()
                    .map(country -> {
                        CountryDTO countryDTO = new CountryDTO();
                        countryDTO.setId(country.getId());  // Set the id
                        countryDTO.setCountryName(country.getName());  // Set the name

                        // Map states to DTOs
                        List<StateDTO> stateDTOs = country.getStates().stream()
                            .map(state -> {
                                StateDTO stateDTO = new StateDTO();
                                stateDTO.setId(state.getId());  // Set the id
                                stateDTO.setStateName(state.getName());  // Set the name

                                // Map cities to DTOs
                                List<CityDTO> cityDTOs = state.getCities().stream()
                                    .map(city -> {
                                        CityDTO cityDTO = new CityDTO();
                                        cityDTO.setId(city.getId());  // Set the id
                                        cityDTO.setCityName(city.getName());  // Set the name
                                        return cityDTO;
                                    })
                                    .collect(Collectors.toList());

                                stateDTO.setCities(cityDTOs);
                                return stateDTO;
                            })
                            .collect(Collectors.toList());

                        countryDTO.setStates(stateDTOs);
                        return countryDTO;
                    })
                    .collect(Collectors.toList());

                dto.setCountries(countryDTOs);
                return dto;
            })
            .collect(Collectors.toList());
    }

}
