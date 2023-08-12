package info.ashutosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.person.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
