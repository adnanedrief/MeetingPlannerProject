package com.meetingplannerproject.Service;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Repository.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterielService implements MaterielInterface {
	@Autowired
	MaterielRepository materielRespository;
	@Override
	public Optional<Materiel> findById(Long id) {
		return materielRespository.findById(id);
	}
	@Override
	public List<Materiel> findMaterielByReunionsId(Long reunionId) {
		return materielRespository.findMaterielByReunionsId(reunionId);
	}
	@Override
	public void ajouterMateriel(Materiel materiel) {
		Materiel newMateriel = new Materiel();
		newMateriel.setNom(materiel.getNom());
		materielRespository.save(newMateriel);
	}

}
