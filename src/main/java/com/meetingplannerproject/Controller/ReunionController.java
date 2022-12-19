package com.meetingplannerproject.Controller;

import com.meetingplannerproject.Model.*;
import com.meetingplannerproject.Service.Interface.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ReunionController {
	@Autowired
	ReunionInterface reunionInterface;
	@Autowired
    MaterielInterface materielInterface;
    @PostMapping("/Add_materiel_a_la_reunion_type")
    public String AjouterMaterielReunionType(@RequestBody Map<String, Long> map){
    	Optional <Reunion> rechercherReunion = reunionInterface.findById(map.get("reunionid"));
    	Optional <Materiel> rechercherMateriel = materielInterface.findById(map.get("materielid"));
    	Materiel materielTrouver = new Materiel();
    	Reunion reunionTrouver = new Reunion();
    	if (rechercherReunion.isPresent()) {
    		reunionTrouver = rechercherReunion.get();
    		if(rechercherMateriel.isPresent()) {
    			materielTrouver = rechercherMateriel.get();
    			reunionTrouver.getMateriels().add(materielTrouver);
    			reunionInterface.ajouterReunion(reunionTrouver);
    		}
    		else {
    			 System.out.printf("Aucun materiel Trouvé !!");
    		}
        } else {
            System.out.printf("Aucune reunion trouvé !!");
        }
        return "L'ajout est bien fait";
    }
	@GetMapping("/all_reunion_type")
	public List<String> allreunion(){
		return reunionInterface.allReunions();
	}
	@PostMapping("/add_reunion_type")
	public String addreunion(@RequestBody Reunion reunion){
		reunionInterface.ajouterReunion(reunion);
		return "La reunion a été bien ajouté";
	}
}
