package com.meetingplannerproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Demande {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	// id of the room
	private Date date;
	private int debut ;
	private int fin;
	private int nbrRequis;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private Reunion reunion;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      mappedBy = "demandes")
	@JsonIgnore
	private Set<Salle> salles ;
	
	
}
