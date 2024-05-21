package com.example.bunker;
import java.util.*;

import com.example.bunker.pkgBunker.pkgEmployeMaintenance.Ingenieur;
import com.example.bunker.pkgBunker.pkgEmployeMaintenance.Ouvrier;
import com.example.bunker.pkgBunker.pkgForceSecurite.Armee;
import com.example.bunker.pkgBunker.pkgForceSecurite.Milice;
import com.example.bunker.pkgBunker.pkgGestionnaire.Administrateur;
import com.example.bunker.pkgBunker.pkgGestionnaire.Scientifique;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AddController {
    VBox container = new VBox();
    @FXML
    private ComboBox<String> select;

    @FXML
    private ScrollPane content;

    @FXML
    private Button valider;

    SimpleBooleanProperty vivant = new SimpleBooleanProperty(false);
    SimpleStringProperty matricule = new SimpleStringProperty();
    SimpleStringProperty prenom = new SimpleStringProperty();
    SimpleStringProperty nom = new SimpleStringProperty();
    SimpleStringProperty dateNaissance = new SimpleStringProperty();
    SimpleStringProperty grade = new SimpleStringProperty();
    SimpleStringProperty poste = new SimpleStringProperty();
    SimpleStringProperty anneeService = new SimpleStringProperty();
    SimpleStringProperty arme = new SimpleStringProperty();
    SimpleStringProperty nombrePlainte = new SimpleStringProperty();
    SimpleStringProperty nombreVictime = new SimpleStringProperty();
    SimpleStringProperty nombreSortie = new SimpleStringProperty();
    SimpleStringProperty matricules = new SimpleStringProperty();
    SimpleStringProperty secteur = new SimpleStringProperty();
    SimpleStringProperty specialite = new SimpleStringProperty();
    SimpleStringProperty dateFinEtude = new SimpleStringProperty();
    SimpleStringProperty niveauEtude = new SimpleStringProperty();
    SimpleStringProperty quartDeTravail = new SimpleStringProperty();
    SimpleStringProperty genreTravail = new SimpleStringProperty();
    SimpleStringProperty nombreEmploye = new SimpleStringProperty();
    SimpleStringProperty nombreProjet = new SimpleStringProperty();
    SimpleStringProperty projet = new SimpleStringProperty();
    SimpleStringProperty titre = new SimpleStringProperty();
    SimpleStringProperty listeProjet = new SimpleStringProperty();

    @FXML
    public void initialize() {
        container.setAlignment(Pos.CENTER);
        container.setPadding(new Insets(10, 10, 10, 10));
        // Initialisation du ComboBox avec les types de personnel
        select.getItems().addAll("Armee", "Milice", "Ouvrier", "Ingenieur", "Administrateur", "Scientifique");

        // Ajouter un ChangeListener pour mettre à jour le ScrollPane en fonction de la
        // sélection
        select.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                updateContent(newVal);
            }
        });
        content.setFitToWidth(true);
        content.setFitToHeight(true);
        content.setContent(container);
    }

    private void updateContent(String type) {
        if (!type.isEmpty()) {
            container.getChildren().clear();
            createBasicFields();
        }

        switch (type) {
            case "Armee":
                createArmeeFields();
                break;
            case "Milice":
                createMiliceFields();
                break;
            case "Ingenieur":
                createIngenieurFields();
                break;
            case "Ouvrier":
                createOuvrierFields();
                break;
            case "Scientifique":
                createScientifiqueFields();
                break;
            case "Administrateur":
                createAdministrateurFields();
        }
        valider.setOnAction(e->{
            ArrayList errors = new ArrayList();
            switch (type) {
                case "Armee":
                     errors = validateArmeeFields();
                     System.out.print(errors);
                     if(errors.isEmpty()){
                         Armee armee = new Armee(
                                 matricule.get(),
                                 nom.get(),
                                 prenom.get(),
                                 new GregorianCalendar(
                                         Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                         Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                         Integer.parseInt(dateNaissance.get().substring(8, 10))
                                 ),
                                 vivant.get(),
                                 grade.get(),
                                 poste.get(),
                                 Integer.parseInt(anneeService.get()),
                                 arme.get(),
                                 Integer.parseInt(nombreVictime.get()),
                                 Integer.parseInt(nombreSortie.get()),
                                 matricules.get().split("\n")

                         );
                         BunkerManager.add(armee);
                         System.out.println(armee);

                     }
                    break;
                case "Milice":
                    errors = validateMiliceFields();
                    System.out.print(errors);
                    if(errors.isEmpty()) {
                        Milice milice = new Milice(
                                matricule.get(),
                                nom.get(),
                                prenom.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                        Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateNaissance.get().substring(8, 10))
                                ),
                                vivant.get(),
                                grade.get(),
                                poste.get(),
                                Integer.parseInt(anneeService.get()),
                                arme.get(),
                                Integer.parseInt(nombrePlainte.get())
                        );
                        BunkerManager.add(milice);
                        System.out.println(milice);
                    }
                    break;
                case "Ingenieur":
                    errors = validateIngenieurFields();
                    System.out.print(errors);
                    if(errors.isEmpty()) {
                        Ingenieur ingenieur = new Ingenieur(
                                matricule.get(),
                                nom.get(),
                                prenom.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                        Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateNaissance.get().substring(8, 10))
                                ),
                                vivant.get(),
                                secteur.get(),
                                specialite.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateFinEtude.get().substring(0, 4)),
                                        Integer.parseInt(dateFinEtude.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateFinEtude.get().substring(8, 10))
                                ),
                                Integer.parseInt(niveauEtude.get())

                        );
                        BunkerManager.add(ingenieur);
                        System.out.println(ingenieur);
                    }
                    break;
                case "Ouvrier":
                    errors = validateOuvrierFields();
                    System.out.print(errors);
                    if(errors.isEmpty()) {
                        Ouvrier ouvrier = new Ouvrier(
                                matricule.get(),
                                nom.get(),
                                prenom.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                        Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateNaissance.get().substring(8, 10))
                                ),
                                vivant.get(),
                                secteur.get(),
                                Integer.parseInt(quartDeTravail.get()),
                                genreTravail.get()

                        );
                        BunkerManager.add(ouvrier);
                        System.out.println(ouvrier);
                    }
                    break;
                case "Scientifique":
                    errors = validateScientifiqueFields();
                    System.out.print(errors);
                    if(errors.isEmpty()) {
                        Scientifique scientifique = new Scientifique(
                                matricule.get(),
                                nom.get(),
                                prenom.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                        Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateNaissance.get().substring(8, 10))
                                ),
                                vivant.get(),
                                Integer.parseInt(nombreEmploye.get()),
                                secteur.get(),
                                Integer.parseInt(nombreProjet.get()),
                                listeProjet.get().split("\n")

                        );
                        BunkerManager.add(scientifique);
                        System.out.println(scientifique);
                    }
                    break;
                case "Administrateur":
                    errors = validateAdministrateurFields();
                    System.out.print(errors);
                    if(errors.isEmpty()) {
                        Administrateur administrateur = new Administrateur(
                                matricule.get(),
                                nom.get(),
                                prenom.get(),
                                new GregorianCalendar(
                                        Integer.parseInt(dateNaissance.get().substring(0, 4)),
                                        Integer.parseInt(dateNaissance.get().substring(5, 7)) - 1,
                                        Integer.parseInt(dateNaissance.get().substring(8, 10))
                                ),
                                vivant.get(),
                                Integer.parseInt(nombreEmploye.get()),
                                secteur.get(),
                                Integer.parseInt(nombreProjet.get()),
                                projet.get(),
                                titre.get()

                        );
                        BunkerManager.add(administrateur);
                        System.out.println(administrateur);
                    }
                    break;
            }
            Alert alert;
            if(!errors.isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de validation");
                alert.setHeaderText("Des erreurs ont été trouvées");
                alert.setContentText(String.join("\n", errors));
                alert.showAndWait();
            }else{
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succès");
                alert.setHeaderText("Ajout Réussi");
                alert.setContentText("a été ajoutée avec succès !");
                alert.showAndWait();
            }
        });
    }

    private void createBasicFields() {
        VBox basicFields = new VBox();
        TextField matriculefield = new TextField();
        matriculefield.textProperty().bindBidirectional(matricule);
        TextField nomfield = new TextField();
        nomfield.textProperty().bindBidirectional(nom);
        TextField prenomfield = new TextField();
        prenomfield.textProperty().bindBidirectional(prenom);
        TextField datefield = new TextField();
        datefield.textProperty().bindBidirectional(dateNaissance);
        CheckBox vivantfield = new CheckBox();
        vivantfield.selectedProperty().bindBidirectional(vivant);
        basicFields.getChildren().addAll(
                new Label("Matricule:"),
                matriculefield,
                new Label("Nom:"),
                nomfield,
                new Label("Prenom:"),
                prenomfield,
                new Label("Date de Naissance:"),
                datefield,
                new Label("Vivant:"),
                vivantfield);
        container.getChildren().addAll(basicFields);
    }

    private void createArmeeFields() {
        VBox armeeFields = new VBox();
        TextField gradeField = new TextField();
        gradeField.textProperty().bindBidirectional(grade);
        TextField posteField = new TextField();
        posteField.textProperty().bindBidirectional(poste);
        TextField anneeServicefield = new TextField();
        anneeServicefield.textProperty().bindBidirectional(anneeService);
        TextField armeField = new TextField();
        armeField.textProperty().bindBidirectional(arme);
        TextField nombreVictimesField = new TextField();
        nombreVictimesField.textProperty().bindBidirectional(nombreVictime);
        TextField nombreSortiesField = new TextField();
        nombreSortiesField.textProperty().bindBidirectional(nombreSortie);
        TextArea matriculesArea = new TextArea();
        matriculesArea.textProperty().bindBidirectional(matricules);
        armeeFields.getChildren().addAll(
                new Label("Grade:"),
                gradeField,
                new Label("Poste:"),
                posteField,
                new Label("Année de Service:"),
                anneeServicefield,
                new Label("Arme:"),
                armeField,
                new Label("Nombre de Victimes:"),
                nombreVictimesField,
                new Label("Nombre de Sorties:"),
                nombreSortiesField,
                new Label("Matricules (un par ligne):"),
                matriculesArea);
        container.getChildren().addAll(armeeFields);
    }

    private void createMiliceFields() {
        VBox miliceFields = new VBox(10);
        TextField gradeField = new TextField();
        gradeField.textProperty().bindBidirectional(grade);
        TextField posteField = new TextField();
        posteField.textProperty().bindBidirectional(poste);
        TextField anneeServicePicker = new TextField();
        anneeServicePicker.textProperty().bindBidirectional(anneeService);
        TextField armeField = new TextField();
        armeField.textProperty().bindBidirectional(arme);
        TextField nombrePlaintesField = new TextField();
        nombrePlaintesField.textProperty().bindBidirectional(nombrePlainte);
        miliceFields.getChildren().addAll(
                new Label("Grade:"),
                gradeField,
                new Label("Poste:"),
                posteField,
                new Label("Année de Service:"),
                anneeServicePicker,
                new Label("Arme:"),
                armeField,
                new Label("Nombre de Plaintes:"),
                nombrePlaintesField);
        container.getChildren().addAll(miliceFields);
    }

    private void createIngenieurFields() {
        VBox ingenieurFields = new VBox(10);
        TextField secteurField = new TextField();
        secteurField.textProperty().bindBidirectional(secteur);
        TextField specialisteField = new TextField();
        specialisteField.textProperty().bindBidirectional(specialite);
        TextField dateFinEtudeField = new TextField();
        dateFinEtudeField.textProperty().bindBidirectional(dateFinEtude);
        TextField niveauEtudeField = new TextField();
        niveauEtudeField.textProperty().bindBidirectional(niveauEtude);
        ingenieurFields.getChildren().addAll(
                new Label("Secteur:"),
                secteurField,
                new Label("Nombre de Projets:"),
                new Label("Spécialiste:"),
                specialisteField,
                new Label("Date de Fin d'Étude:"),
                dateFinEtudeField,
                new Label("Niveau d'Étude:"),
                niveauEtudeField);

        container.getChildren().addAll(ingenieurFields);
    }

    private void createOuvrierFields() {
        VBox ouvrierFields = new VBox(10);
        TextField secteurField = new TextField();
        secteurField.textProperty().bindBidirectional(secteur);
        TextField quartDeTravailField = new TextField();
        quartDeTravailField.textProperty().bindBidirectional(quartDeTravail);
        TextField genreTravailField = new TextField();
        genreTravailField.textProperty().bindBidirectional(genreTravail);
        ouvrierFields.getChildren().addAll(
                new Label("Secteur:"),
                secteurField,
                new Label("Quart de Travail:"),
                quartDeTravailField,
                new Label("Genre de Travail:"),
                genreTravailField);

        container.getChildren().addAll(ouvrierFields);
    }

    private void createScientifiqueFields() {
        VBox scientifiqueFields = new VBox(10);
        TextField nombreEmployesField = new TextField();
        nombreEmployesField.textProperty().bindBidirectional(nombreEmploye);
        TextField secteurField = new TextField();
        secteurField.textProperty().bindBidirectional(secteur);
        TextField nombreProjetsField = new TextField();
        nombreProjetsField.textProperty().bindBidirectional(nombreProjet);
        TextArea listeProjetsArea = new TextArea();
        listeProjetsArea.textProperty().bindBidirectional(listeProjet);
        scientifiqueFields.getChildren().addAll(
                new Label("Nombre d'Employés:"),
                nombreEmployesField,
                new Label("Secteur:"),
                secteurField,
                new Label("Nombre de Projets:"),
                nombreProjetsField,
                new Label("Liste de Projets (un par ligne):"),
                listeProjetsArea);
        container.getChildren().addAll(scientifiqueFields);
    }

    private void createAdministrateurFields() {
        VBox administrateurFields = new VBox(10);
        TextField nombreEmployesField = new TextField();
        nombreEmployesField.textProperty().bindBidirectional(nombreEmploye);
        TextField secteurField = new TextField();
        secteurField.textProperty().bindBidirectional(secteur);
        TextField nombreProjetsField = new TextField();
        nombreProjetsField.textProperty().bindBidirectional(nombreProjet);
        TextField projetAffecteField = new TextField();
        projetAffecteField.textProperty().bindBidirectional(projet);
        TextField titreField = new TextField();
        titreField.textProperty().bindBidirectional(titre);
        administrateurFields.getChildren().addAll(
                new Label("Nombre d'Employés:"),
                nombreEmployesField,
                new Label("Secteur:"),
                secteurField,
                new Label("Nombre de Projets:"),
                nombreProjetsField,
                new Label("Projet Affecté:"),
                projetAffecteField,
                new Label("Titre:"),
                titreField);
        container.getChildren().addAll(administrateurFields);
    }

    private ArrayList<String> validateBasicFields() {
        ArrayList<String> errors = new ArrayList<>();
        String nomValue = nom.get();
        String matriculeValue = matricule.get();
        String prenomValue = prenom.get();
        String dateNaissanceValue = dateNaissance.get();
        if (nomValue == null || nomValue.trim().isEmpty()) {
            errors.add("Le champ Nom est vide.");
        }
        if (matriculeValue == null || matriculeValue.trim().isEmpty()) {
            errors.add("Le champ Matricule est vide.");
        } else {
            boolean matriculeExists = BunkerManager.personnels.stream().anyMatch(personnel -> personnel.getMatricule().equals(matriculeValue));
            if (matriculeExists) {
                errors.add("Ce matricule est déjà utilisé par un autre personnel.");
            }
        }
        if (prenomValue == null || prenomValue.trim().isEmpty()) {
            errors.add("Le champ Prénom est vide.");
        }
        if (dateNaissanceValue == null || !dateNaissanceValue.matches("\\d{4}-\\d{2}-\\d{2}")) {
            errors.add("Format de la Date de Naissance invalide. Utilisez le format AAAA-MM-JJ.");
        } else {
            String[] dateParts = dateNaissanceValue.split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]) - 1;
            int day = Integer.parseInt(dateParts[2]);
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            if (calendar.get(Calendar.YEAR) != year ||
                    calendar.get(Calendar.MONTH) != month ||
                    calendar.get(Calendar.DAY_OF_MONTH) != day) {
                errors.add("La Date de Naissance est invalide.");
            } else {
                GregorianCalendar currentDate = new GregorianCalendar();
                if (calendar.after(currentDate)) {
                    errors.add("La Date de Naissance ne peut pas être dans le futur.");
                }
            }
        }
        return errors;
    }

    private ArrayList<String> validateArmeeFields() {
        ArrayList<String> errors = validateBasicFields();
        // Validation du grade
        if (grade.get() == null || grade.get().trim().isEmpty()) {
            errors.add("Le grade est requis.");
        }
        // Validation du poste
        if (poste.get() == null || poste.get().trim().isEmpty()) {
            errors.add("Le poste est requis.");
        }
        // Validation de l'année de service
        if (anneeService.get() == null || anneeService.get().trim().isEmpty()) {
            errors.add("L'année de service est requise.");
        } else {
            try {
                int annee = Integer.parseInt(anneeService.get());
                if (annee <= 0) {
                    errors.add("L'année de service doit être un nombre positif.");
                }
            } catch (NumberFormatException e) {
                errors.add("L'année de service doit être un nombre.");
            }
        }
        // Validation de l'arme
        if (arme.get() == null || arme.get().trim().isEmpty()) {
            errors.add("L'arme est requise.");
        }
        // Validation du nombre de victimes
        if (nombreVictime.get() == null || nombreVictime.get().trim().isEmpty()) {
            errors.add("Le nombre de victimes est requis.");
        } else {
            try {
                int victimes = Integer.parseInt(nombreVictime.get());
                if (victimes < 0) {
                    errors.add("Le nombre de victimes ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre de victimes doit être un nombre.");
            }
        }
        // Validation du nombre de sorties
        if (nombreSortie.get() == null || nombreSortie.get().trim().isEmpty()) {
            errors.add("Le nombre de sorties est requis.");
        } else {
            try {
                int sorties = Integer.parseInt(nombreSortie.get());
                if (sorties < 0) {
                    errors.add("Le nombre de sorties ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre de sorties doit être un nombre.");
            }
        }
        // Validation des matricules
        if (matricules.get() == null || matricules.get().trim().isEmpty() || matricules.get().split("\n").length != 5) {
            errors.add("5 matricules sont requis.");
        }
        return errors;
    }

    private ArrayList<String> validateMiliceFields() {
        ArrayList<String> errors = validateBasicFields();

        // Validation du grade
        if (grade.get() == null || grade.get().trim().isEmpty()) {
            errors.add("Le grade est requis.");
        }

        // Validation du poste
        if (poste.get() == null || poste.get().trim().isEmpty()) {
            errors.add("Le poste est requis.");
        }

        // Validation de l'année de service
        if (anneeService.get() == null || anneeService.get().trim().isEmpty()) {
            errors.add("L'année de service est requise.");
        } else {
            try {
                int annee = Integer.parseInt(anneeService.get());
                if (annee <= 0) {
                    errors.add("L'année de service doit être un nombre positif.");
                }
            } catch (NumberFormatException e) {
                errors.add("L'année de service doit être un nombre.");
            }
        }

        // Validation de l'arme
        if (arme.get() == null || arme.get().trim().isEmpty()) {
            errors.add("L'arme est requise.");
        }

        // Validation du nombre de plaintes
        if (nombrePlainte.get() == null || nombrePlainte.get().trim().isEmpty()) {
            errors.add("Le nombre de plaintes est requis.");
        } else {
            try {
                int plaintes = Integer.parseInt(nombrePlainte.get());
                if (plaintes < 0) {
                    errors.add("Le nombre de plaintes ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre de plaintes doit être un nombre.");
            }
        }
        return errors;
    }

    private ArrayList<String> validateIngenieurFields() {
        ArrayList<String> errors = validateBasicFields();

        if (secteur.get() == null || secteur.get().trim().isEmpty()) {
            errors.add("Le secteur est requis.");
        }
        if (specialite.get() == null || specialite.get().trim().isEmpty()) {
            errors.add("Le spécialiste est requis.");
        }

        if (dateFinEtude.get() == null || !dateFinEtude.get().matches("\\d{4}-\\d{2}-\\d{2}")) {
            errors.add("Format de la Date de Fin d'etude invalide. Utilisez le format AAAA-MM-JJ.");
        } else {
            String[] dateParts = dateFinEtude.get().split("-");
            int year = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]) - 1;
            int day = Integer.parseInt(dateParts[2]);
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            if (calendar.get(Calendar.YEAR) != year ||
                    calendar.get(Calendar.MONTH) != month ||
                    calendar.get(Calendar.DAY_OF_MONTH) != day) {
                errors.add("La Date de fin d'etude est invalide.");
            } else {
                GregorianCalendar currentDate = new GregorianCalendar();
                if (calendar.after(currentDate)) {
                    errors.add("La Date de fin d'etude ne peut pas être dans le futur.");
                }
            }
        }
        if (niveauEtude.get() == null || niveauEtude.get().trim().isEmpty()) {
            errors.add("Le niveau d'étude est requis.");
        } else {
            try {
                int niveau = Integer.parseInt(niveauEtude.get());
            } catch (NumberFormatException e) {
                errors.add("Le niveau d'étude doit être un nombre.");
            }
        }
        return errors;
    }

    private ArrayList<String> validateOuvrierFields() {
        ArrayList<String> errors = validateBasicFields();
        if (secteur.get() == null || secteur.get().trim().isEmpty()) {
            errors.add("Le secteur est requis.");
        }
        if (quartDeTravail.get() == null || quartDeTravail.get().trim().isEmpty()) {
            errors.add("Le quart de travail est requis.");
        } else {
            try {
                int quart = Integer.parseInt(quartDeTravail.get());
                if (quart <= 0) {
                    errors.add("Le quart de travail doit être un nombre positif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le quart de travail doit être un nombre.");
            }
        }
        if (genreTravail.get() == null || genreTravail.get().trim().isEmpty()) {
            errors.add("Le genre de travail est requis.");
        }
        return errors;
    }

    private ArrayList<String> validateScientifiqueFields() {
        ArrayList<String> errors = validateBasicFields();
        if (nombreEmploye.get() == null || nombreEmploye.get().trim().isEmpty()) {
            errors.add("Le nombre d'employés est requis.");
        } else {
            try {
                int employes = Integer.parseInt(nombreEmploye.get());
                if (employes < 0) {
                    errors.add("Le nombre d'employés ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre d'employés doit être un nombre.");
            }
        }

        if (secteur.get() == null || secteur.get().trim().isEmpty()) {
            errors.add("Le secteur est requis.");
        }
        if (nombreProjet.get() == null || nombreProjet.get().trim().isEmpty()) {
            errors.add("Le nombre de projets est requis.");
        } else {
            try {
                int projets = Integer.parseInt(nombreProjet.get());
                if (projets < 0) {
                    errors.add("Le nombre de projets ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre de projets doit être un nombre.");
            }
        }
        if (listeProjet.get() == null || listeProjet.get().trim().isEmpty()) {
            errors.add("La liste de projets est requise.");
        }
        return errors;
    }

    private ArrayList<String> validateAdministrateurFields() {
        ArrayList<String> errors = validateBasicFields();

        // Validation du nombre d'employés
        if (nombreEmploye.get() == null || nombreEmploye.get().trim().isEmpty()) {
            errors.add("Le nombre d'employés est requis.");
        } else {
            try {
                int employes = Integer.parseInt(nombreEmploye.get());
                if (employes < 0) {
                    errors.add("Le nombre d'employés ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre d'employés doit être un nombre.");
            }
        }

        // Validation du secteur
        if (secteur.get() == null || secteur.get().trim().isEmpty()) {
            errors.add("Le secteur est requis.");
        }

        // Validation du nombre de projets
        if (nombreProjet.get() == null || nombreProjet.get().trim().isEmpty()) {
            errors.add("Le nombre de projets est requis.");
        } else {
            try {
                int projets = Integer.parseInt(nombreProjet.get());
                if (projets < 0) {
                    errors.add("Le nombre de projets ne peut pas être négatif.");
                }
            } catch (NumberFormatException e) {
                errors.add("Le nombre de projets doit être un nombre.");
            }
        }

        // Validation du projet affecté
        if (projet.get() == null || projet.get().trim().isEmpty()) {
            errors.add("Le projet affecté est requis.");
        }

        // Validation du titre
        if (titre.get() == null || titre.get().trim().isEmpty()) {
            errors.add("Le titre est requis.");
        }

        return errors;
    }

}
