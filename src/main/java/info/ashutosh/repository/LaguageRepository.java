package info.ashutosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.person.Language;

public interface LaguageRepository extends JpaRepository<Language, Long> {

}
