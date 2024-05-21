package com.example.bunker;

import com.example.bunker.pkgBunker.Personnel;
import com.example.bunker.pkgBunker.pkgEmployeMaintenance.EmployeMaintenance;
import com.example.bunker.pkgBunker.pkgEmployeMaintenance.Ingenieur;
import com.example.bunker.pkgBunker.pkgForceSecurite.Armee;
import com.example.bunker.pkgBunker.pkgForceSecurite.Milice;
import com.example.bunker.pkgBunker.pkgGestionnaire.Administrateur;
import com.example.bunker.pkgBunker.pkgGestionnaire.Gestionnaire;
import com.example.bunker.pkgBunker.pkgGestionnaire.Scientifique;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class SearchController {
    SimpleStringProperty searchvalue = new SimpleStringProperty();
    @FXML
    private TextField inputSearch;

    @FXML
    private ScrollPane content;

    @FXML
    public void initialize() {
        content.setFitToWidth(true);
        content.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
        content.getStyleClass().add("content-search");

        inputSearch.textProperty().bindBidirectional(searchvalue);
        buildContent(BunkerManager.personnels);
        inputSearch.textProperty().addListener((observable,oldValue,newValue)->{
            ArrayList<Personnel> newpersonnels = new ArrayList<Personnel>();
            for(Personnel p : BunkerManager.personnels) {
                if(p.getNom().startsWith(newValue) || p.getMatricule().startsWith(newValue)){
                    newpersonnels.add(p);
                }
            }
            buildContent(newpersonnels);
        });
    }
    private void buildContent(ArrayList<Personnel> personnels){
        VBox container = new VBox();
        container.setFillWidth(true);
        container.setSpacing(10);
        for(Personnel p : personnels){
            String value;
            if(p instanceof EmployeMaintenance){
                p = (EmployeMaintenance)p;

            }else if(p instanceof Ingenieur ){
                p = (Ingenieur)p;
            } else if (p instanceof Milice) {
                p = (Milice)p;
            }else if(p instanceof Armee){
                p = (Armee)p;
            } else if (p instanceof Scientifique) {
                p = (Scientifique)p;
            }else if(p instanceof Administrateur){
                p = (Administrateur)p;
            }

            HBox  hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            hbox.setSpacing(20);

            Label label = new Label(p.toString());
            Button delete = new Button("supprimer");
            hbox.getChildren().addAll(label, delete);
            container.getChildren().add(hbox);
            container.getChildren().add(new Separator());
            String matricule = p.getMatricule();
            delete.setOnAction(e->{
                if(BunkerManager.delete(matricule)){
                    buildContent(BunkerManager.personnels);
                }
            });




        }
        content.setContent(container);
    }

}
