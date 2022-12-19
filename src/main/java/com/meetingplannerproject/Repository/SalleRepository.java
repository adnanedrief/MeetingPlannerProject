package com.meetingplannerproject.Repository;

import com.meetingplannerproject.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
	@Query(
			value = "select nom ,nbrplaces from salle",
			nativeQuery = true
	)
	List<String> getAllSalles();
	List<Salle> findSallesByMaterielsId(Long materielId);
}
