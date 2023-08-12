package info.ashutosh.domain.entity.location;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import info.ashutosh.domain.entity.person.Language;
import info.ashutosh.domain.entity.person.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "states")
@Getter
@Setter
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// State -- Country
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_country_id", nullable = false)
	private Country country;

	// State - City
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<City> cities;

	// State -- Person
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "state")
	private List<Person> persons;

	// Country - Language
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_language_id")
	private Language language;
}
