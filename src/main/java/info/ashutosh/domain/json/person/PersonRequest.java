package info.ashutosh.domain.json.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonRequest {

	private Long id;

	@NotNull(message = "Name Required !")
	@NotBlank(message = "Name must not Blank!")
	private String name;

	@NotNull(message = "language Required !")
	@NotBlank(message = "language must not Blank!")
	private String language;
	
	@NotNull(message = "countryId Required !")
	@NotBlank(message = "countryId must not Blank!")
	private String countryId;

	@NotNull(message = "stateId Required !")
	@NotBlank(message = "stateId must not Blank!")
	private String stateId;

	@NotNull(message = "cityId Required !")
	@NotBlank(message = "cityId must not Blank!")
	private String cityId;

}
