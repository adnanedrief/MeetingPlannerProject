# MeetingPlannerProject
## Description
Ce projet est une API en SpringBoot qui permet la gestion des salles de réunion d'une PME durant le COVID.
## Technologies utilisées
SpringBoot, Swagger, JUnit.
## Fonctionnalitées
1- Ajouter un matériel(pieuvre,tableau,camera,écran) à une salle.<br>
2- Ajouter une salle.<br>
3- Lister toute les salles.<br>
4- Ajouter une matériel.<br>
5- Ajouter un matériel à une réunion.<br>
6- Lister toute les types de réunions possibles.<br>
7- Ajouter une demande de réservation d'une salle.<br>
8- Lister toute les demandes.<br>
9- Proposer une meilleur salle selon le type de la réunion et le nombre de places. <br>
## Structure
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com
    │   │   │       └───meetingplannerproject
    │   │   │           │   MeetingPlannerProjectApplication.java
    │   │   │           │
    │   │   │           ├───Controller
    │   │   │           │       DemandeController.java
    │   │   │           │       MaterielController.java
    │   │   │           │       ReunionController.java
    │   │   │           │       SalleController.java
    │   │   │           │
    │   │   │           ├───Model
    │   │   │           │       Demande.java
    │   │   │           │       DemanderEnregistrer.java
    │   │   │           │       Materiel.java
    │   │   │           │       Reunion.java
    │   │   │           │       Salle.java
    │   │   │           │
    │   │   │           ├───Repository
    │   │   │           │       DemandeRepository.java
    │   │   │           │       MaterielRepository.java
    │   │   │           │       ReunionRepository.java
    │   │   │           │       SalleRepository.java
    │   │   │           │
    │   │   │           └───Service
    │   │   │               │   DemandeService.java
    │   │   │               │   MaterielService.java
    │   │   │               │   ReunionService.java
    │   │   │               │   SalleService.java
    │   │   │               │
    │   │   │               └───Interface
    │   │   │                       DemandeInterface.java
    │   │   │                       MaterielInterface.java
    │   │   │                       ReunionInterface.java
    │   │   │                       SalleInterface.java
    │   │   │
    │   │   └───resources
    │   │       │   application.properties
    │   │       │
    │   │       ├───static
    │   │       └───templates
    │   └───test
    │       └───java
    │           └───com
    │               └───meetingplannerproject
    │                   │   MeetingPlannerProjectApplicationTests.java
    │                   │
    │                   ├───DemandeTest
    │                   │       DemandeTestCase.java
    │                   │
    │                   ├───MaterielTest
    │                   │       MaterielTestCase.java
    │                   │
    │                   ├───ReunionTest
    │                   │       ReunionTestCase.java
    │                   │
    │                   └───SalleTest
    │                           SalleTestCase.java
## Endpoints
##### L'ajout d'une sallle 
`http://localhost:8080/addsalle`
##### L'ajout d'un matériel à une salle 
`http://localhost:8080/add_materiel_au_salle`
##### L'ajout d'une demande 
`http://localhost:8080/ajouterdemande`
##### L'ajout d'une reunion 
`http://localhost:8080/add_reunion_type`
##### Avoir une propositon sur une salle 
`http://localhost:8080/proposersalle`
##### Voir toute les demandes
`http://localhost:8080/allDemandes`
##### Voir toute les salles
`http://localhost:8080/allsalles`
##### Voir toute les réunions 
`http://localhost:8080/add_materiel_au_salle`



## La documentation complète des Endpoints avec Swagger
On peut voir toute les Endpoints  avec toute les méthodes HTTP possibles via à lien :  http://localhost:8080/swagger-ui/index.html (Après le lancement de notre application bien sûr).
# Captures d'écran
## L'interface principal de Swagger

![](https://i.ibb.co/KKXTj2V/swagger1.png)
## Exemples
|Une requête POST  |Une requête GET |
| ------------ |  ------------ |
|  ![](https://i.ibb.co/7nzb0rR/swagger3.png)  | ![](https://i.ibb.co/kDTqLwv/swagger2.png)|




