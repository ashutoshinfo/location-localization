package info.ashutosh.dtos;

import lombok.Data;

import java.util.List;

@Data
public class StateDTO {
    private Long id;               // Add id field
    private String stateName;      // Add name field
    private List<CityDTO> cities;

    // getters and setters
}
