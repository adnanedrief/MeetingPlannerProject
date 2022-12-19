package com.meetingplannerproject.Repository;

import com.meetingplannerproject.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long>{
	List<Materiel> findMaterielByReunionsId(Long reunionId);
}