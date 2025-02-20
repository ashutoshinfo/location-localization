package info.ashutosh.controller;

import info.ashutosh.domain.entity.person.Language;
import info.ashutosh.domain.json.common.CustomResponse;
import info.ashutosh.dtos.CityDTO;
import info.ashutosh.dtos.CountryDTO;
import info.ashutosh.dtos.LanguageDTO;
import info.ashutosh.dtos.StateDTO;
import info.ashutosh.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @GetMapping(value = "/get")
    public CustomResponse getLanguages() {
        return languageService.getLanguages();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LanguageDTO>> getAllLanguages() {
        List<LanguageDTO> languages = languageService.getAllLanguages();
        return ResponseEntity.ok(languages);
    }

}
