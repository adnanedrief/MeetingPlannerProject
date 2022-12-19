package com.meetingplannerproject.Controller;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
@RestController
public class DemandeController {
	@Autowired
	SalleInterface salleInterface;
	@Autowired
	ReunionInterface reunionInterface;
	@Autowired
	DemandeInterface demandeInterface;
	@Autowired
	MaterielInterface materielInterface;

	@GetMapping("/proposersalle")
    public String ProposerSalle(@RequestBody Demande demande){
		Demande demande1 = new Demande();
		Optional <Demande> demandeExistBd = demandeInterface.findById(demande.getId());
		Reunion reunionType = new Reunion();
		if (demandeExistBd.isPresent()) {
			demande1 = demandeExistBd.get();
			reunionType = demandeExistBd.get().getReunion();
        } else {
			return "Aucune Reunion n'est trouvé !!";
        }
		List<Materiel> materielsNecessaire = materielInterface.findMaterielByReunionsId(reunionType.getId());
		List<Salle> sallesAvecMateriels = new ArrayList<>();
		if (!materielsNecessaire.isEmpty()) {
			for(Materiel materiel : materielsNecessaire) {
				List<Salle> sallesNecessaire = salleInterface.findSallesByMaterielsId(materiel.getId());
				for(Salle salle :sallesNecessaire) {
					if((salle.getNbrplaces()*70/100)>= demande1.getNbrRequis()){
						sallesAvecMateriels.add(salle);
					}
				}
			}
		}
		else {
			List<Salle> sallesNecessaire = salleInterface.getAllSalles();
			for(Salle r :sallesNecessaire) {
				if((r.getNbrplaces()*70/100)>= demande1.getNbrRequis()){
					sallesAvecMateriels.add(r);
				}
			}
		}
		Map<Long, Long> idFrequence = sallesAvecMateriels.stream().collect(Collectors.groupingBy(Salle::getId,Collectors.counting()));
		Set<Entry<Long, Long>> set = idFrequence.entrySet();
		List<Entry<Long, Long>> list = new ArrayList<Entry<Long, Long>>(set);
		boolean libre =true;
		for (Entry<Long, Long> map : list) {
		    Long id = map.getKey();
		    Salle SalleChoisi = new Salle();
			Optional <Salle> laSalleChoisi = salleInterface.findById(id);
			if (laSalleChoisi.isPresent()) {
				SalleChoisi = laSalleChoisi.get();
	        } else {
				return "Aucune salle trouvé avec cette ID :  "+ id;
	        }
		    List<Demande> conflitSalle = demandeInterface.findDemandeBySalleId(id);
		    if(!conflitSalle.isEmpty()) {
		    	 for (Demande conflitDemande : conflitSalle) {
					if((conflitDemande.getDate().equals(demande1.getDate()) && conflitDemande.getDebut()== demande1.getDebut())) {
						libre=false;
					}
		       }
			   if(!libre) {
			    	System.out.println("La salle n'est pas libre "+id);
			    	continue;
			   }
			   else {
				   System.out.println("La meilleure salle pour cette demande est celle qui a l'id : "+id);
				   SalleChoisi.getDemandes().add(demande1);
				   salleInterface.ajouterSalle(SalleChoisi);
				   return "La meilleure salle pour cette demande est celle qui a l'id : "+ SalleChoisi.getNom() ;
			   }
		    }
		    else {
		    	System.out.println("La meilleure salle pour cette demande est celle qui a l'id :"+id);
		    	SalleChoisi.getDemandes().add(demande1);
		    	salleInterface.ajouterSalle(SalleChoisi);
		    	return "La meilleure salle pour cette demande est celle qui a l'id :"+ SalleChoisi.getNom()  ;
		    }
		}
         return "il n'y a pas de salles disponibles";
    }
	@GetMapping("/allDemandes")
	public List<String> alldemandes(){return demandeInterface.getDemandes();}
	@PostMapping("/ajouterdemande")
	public String AjouterDemande(@RequestBody DemanderEnregistrer demanderEnregistrer){
		Long reunionid = demanderEnregistrer.getReunionId();
		Optional <Reunion> rechercherReunion = reunionInterface.findById(reunionid);
		Reunion reunionTrouver = new Reunion();
		if (rechercherReunion.isPresent()) {
			reunionTrouver = rechercherReunion.get();
			Demande enregistrerReunion = Demande.builder()
					.date(demanderEnregistrer.getDate())
					.reunion(reunionTrouver)
					.debut(demanderEnregistrer.getDebut())
					.fin(demanderEnregistrer.getDebut()+2) // 2 : pour laisser 1h de nettoyage de COVID
					.nbrRequis(demanderEnregistrer.getNbrRequis())
					.build();
			demandeInterface.ajouterDemande(enregistrerReunion);
		} else {
			return  "Aucune réunion n'a été trouvée avec cette ID :"+ reunionid;
		}
		return "L'ajout est bien fait !!";
	}
}
