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
public class SalleController {
    @Autowired
    SalleInterface salleService;
    @Autowired
    MaterielInterface materielInterface;

    @PostMapping("/add_materiel_au_salle")
    public String AjouterMaterielSalle(@RequestBody Map<String, Long> map){

    	Optional <Salle> rechercherSalle = salleService.findById(map.get("salleid"));
    	Optional <Materiel> rechercherMateriel = materielInterface.findById(map.get("materielid"));
    	Materiel materielTrouver = new Materiel();
    	Salle salleTrouver = new Salle();
    	
    	if (rechercherSalle.isPresent()) {
    		salleTrouver = rechercherSalle.get();
    		if(rechercherMateriel.isPresent()) {
    			materielTrouver = rechercherMateriel.get();
    			salleTrouver.getMateriels().add(materielTrouver);
    			salleService.ajouterSalle(salleTrouver);
    		}
    		else {
    			 System.out.printf("Aucun Materiel est trouvé !!");
    		}
        } else {
            System.out.printf("Aucune Salle trouvé !!");
        }
        return "L'ajout est bien fait!!";
    }
    @GetMapping("/allsalles")
    public List<String> Allsalles(){
        return  salleService.allsalles();
    }
    @PostMapping("/addsalle")
    public String addSalle(@RequestBody Salle salle){
        salleService.ajouterSalle(salle);
        return "La salle est bien ajouté ! ";
    }
}
