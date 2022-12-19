package com.meetingplannerproject.Service.Interface;

import com.meetingplannerproject.Model.*;

import java.util.List;
import java.util.Optional;

public interface SalleInterface {
	List<Salle> getAllSalles() ;
	List<String> allsalles();
	Optional<Salle> findById(Long id);
	List<Salle> findSallesByMaterielsId(Long equipmentId);
	void ajouterSalle(Salle salle);
}
