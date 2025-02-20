package info.ashutosh.dtos;

import lombok.Data;

import java.util.List;

@Data
public class LanguageDTO {
    private Long id;               // Add id field
    private String languageName;   // Add name field
    private List<CountryDTO> countries;

    // getters and setters
}
