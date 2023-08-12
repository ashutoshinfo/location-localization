package info.ashutosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.location.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
