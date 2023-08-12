package info.ashutosh.domain.entity.person;

import info.ashutosh.domain.entity.location.City;
import info.ashutosh.domain.entity.location.Country;
import info.ashutosh.domain.entity.location.State;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Person - Language
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_language_fid")
	private Language language;

	// Person - Country
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_country_fid")
	private Country country;

	// Person - State
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_state_fid")
	private State state;

	// Person - City
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_city_fid")
	private City city;

}
