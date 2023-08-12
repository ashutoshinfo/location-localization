package info.ashutosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.location.City;

public interface CityRepository extends JpaRepository<City, Long> {

	List<City> findByLanguage_IdAndCountry_Id(Long trimLaguageId, Long trimCityId);

}
