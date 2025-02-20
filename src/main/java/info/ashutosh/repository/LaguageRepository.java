package info.ashutosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.person.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
