package com.meetingplannerproject.Controller;

import com.meetingplannerproject.Model.Materiel;
import com.meetingplannerproject.Service.Interface.MaterielInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaterielController {
	@Autowired
    MaterielInterface materielService;
    @PostMapping("/ajoutermateriel")
    public String ajouterMateriel(@RequestBody Materiel materiel){
        materielService.ajouterMateriel(materiel);
         return "Le materiel est bien ajouté !!";
    }

}
