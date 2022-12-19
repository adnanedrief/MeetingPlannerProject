package com.meetingplannerproject.Service.Interface;

import com.meetingplannerproject.Model.*;

import java.util.List;
import java.util.Optional;

public interface DemandeInterface {
	void ajouterDemande(Demande demande);
	List<Demande> findDemandeBySalleId(Long id);
	List<String> getDemandes();
	Optional<Demande> findById(Long id);
}
