package info.ashutosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.ashutosh.domain.entity.location.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	List<Country> findByLanguage_Id(Integer languageId);

	@Query("SELECT c FROM Country c WHERE c.language.id = :languageId")
	List<Country> findCountriesByLanguageId(Long languageId);

}
