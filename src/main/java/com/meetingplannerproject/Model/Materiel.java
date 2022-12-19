package com.meetingplannerproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Materiel {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String nom;
	
	@ManyToMany(fetch = FetchType.LAZY,
		      mappedBy = "materiels")
	@JsonIgnore
	private Set<Reunion> reunions;

	@ManyToMany(fetch = FetchType.LAZY,
		      mappedBy = "materiels")
	@JsonIgnore
	private Set<Salle> salles ;
}
