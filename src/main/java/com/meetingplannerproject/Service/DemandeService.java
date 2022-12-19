package com.meetingplannerproject.Service;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Repository.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService implements DemandeInterface {
	@Autowired
	DemandeRepository demandeRespository;
	public List<Demande> findDemandeBySalleId(Long id) {
		return demandeRespository.findDemandesBySallesId(id);
	}
	@Override
	public Optional<Demande> findById(Long id) {
		return demandeRespository.findById(id);
	}
	@Override
	public List<String> getDemandes(){
		return demandeRespository.getAllDemande();
	};

	@Override
	public void ajouterDemande(Demande demande) {demandeRespository.save(demande);}

}
