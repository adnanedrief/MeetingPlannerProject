package com.meetingplannerproject.Repository;

import com.meetingplannerproject.Model.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReunionRepository extends JpaRepository<Reunion, Long>{
    @Query(
            value = "select type_reunion from reunion",
            nativeQuery = true
    )
    List<String> getAllReunions();
}
