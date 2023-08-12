package info.ashutosh.domain.entity.person;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.entity.location.Country;
import info.ashutosh.domain.entity.location.State;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Language -- Person
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	private List<Person> persons;

	// Language -- Country
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	private List<Country> countries;

	// Language -- State
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	private List<State> states;

	// Language -- City
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
	private List<City> cities;

}
