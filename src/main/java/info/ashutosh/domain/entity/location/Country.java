package info.ashutosh.domain.entity.location;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "countries")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	// Country -- Person
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	private List<Person> persons;

	// Country - States
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<State> states = new ArrayList<>();

	// Country - Language
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_language_id")
	private Language language;

}
