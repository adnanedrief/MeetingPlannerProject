package com.meetingplannerproject.Repository;

import com.meetingplannerproject.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findDemandesBySallesId(Long reunionId);
    @Query(
            value = "select debut,fin,nbr_requis,id ,date from demande",
            nativeQuery = true
    )
    List<String> getAllDemande();
}

