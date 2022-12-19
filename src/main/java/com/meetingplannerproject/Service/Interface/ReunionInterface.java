package com.meetingplannerproject.Service.Interface;

import com.meetingplannerproject.Model.*;

import java.util.List;
import java.util.Optional;

public interface ReunionInterface {
	Optional<Reunion> findById(Long id);
	List<String> allReunions();
	void ajouterReunion(Reunion reunion);
}
