package com.meetingplannerproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Salle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String nom;

	private int nbrplaces;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "salle_materiel",joinColumns = { @JoinColumn(name = "salle_id") },inverseJoinColumns = { @JoinColumn(name = "materiel_id") })
	private Set<Materiel> materiels;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "demandes_salle",joinColumns = { @JoinColumn(name = "salle_id") },inverseJoinColumns = { @JoinColumn(name = "demande_id") })
	private Set<Demande> demandes;
}
