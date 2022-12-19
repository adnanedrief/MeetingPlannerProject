package com.meetingplannerproject.Service;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Repository.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionService implements ReunionInterface {
	@Autowired
	ReunionRepository reunionRespository;
	@Override
	public Optional<Reunion> findById(Long id) {
		return reunionRespository.findById(id);
	}
	@Override
	public void ajouterReunion(Reunion reunion) {
		reunionRespository.save(reunion);
	}
	@Override
	public List<String> allReunions(){
		return reunionRespository.getAllReunions();
	}

}
