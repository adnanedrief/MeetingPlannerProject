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
@AllArgsConstructor
@NoArgsConstructor
public class Reunion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String typeReunion;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(joinColumns = { @JoinColumn(name = "reunion_id") },inverseJoinColumns = { @JoinColumn(name = "materiel_id") })
	private Set<Materiel> materiels;

    @OneToMany(mappedBy = "reunion", fetch = FetchType.LAZY)
    private Set<Demande> demandes;

}
