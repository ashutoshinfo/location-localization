package info.ashutosh.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CountryDTO {
    private Long id;               // Add id field
    private String countryName;    // Add name field
    private List<StateDTO> states;

    // getters and setters
}
