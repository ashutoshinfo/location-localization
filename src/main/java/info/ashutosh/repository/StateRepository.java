package info.ashutosh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.ashutosh.domain.entity.location.State;

public interface StateRepository extends JpaRepository<State, Long> {

	List<State> findByLanguage_Id(Long languageId);
}
