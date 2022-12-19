package com.meetingplannerproject.Service;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Repository.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService implements SalleInterface {
	@Autowired
	SalleRepository salleRepository;
	@Override
	public Optional<Salle> findById(Long id) {
		return salleRepository.findById(id);
	}
	@Override
	public List<Salle> findSallesByMaterielsId(Long materielId) {
		return salleRepository.findSallesByMaterielsId(materielId);
	}
	@Override
	public void ajouterSalle(Salle salle) {
		salleRepository.save(salle);
	}
	@Override
	public List<Salle> getAllSalles() {
		return salleRepository.findAll();
	}
	@Override
	public List<String> allsalles() {
	  return salleRepository.getAllSalles();
  };



}
