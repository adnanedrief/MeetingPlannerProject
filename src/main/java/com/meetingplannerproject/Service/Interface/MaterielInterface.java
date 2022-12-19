package com.meetingplannerproject.Service.Interface;

import com.meetingplannerproject.Model.*;

import java.util.List;
import java.util.Optional;

public interface MaterielInterface {
	Optional<Materiel> findById(Long id);
	List<Materiel> findMaterielByReunionsId(Long reunionId);
	void ajouterMateriel(Materiel materiel);
}
