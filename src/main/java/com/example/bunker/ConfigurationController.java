package com.example.bunker;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class ConfigurationController {
    private SimpleStringProperty  bunkerpath = new SimpleStringProperty(BunkerManager.configMap.get("bunker"));
    private  SimpleStringProperty maintenancepath = new SimpleStringProperty(BunkerManager.configMap.get("maintenance"));
    private SimpleStringProperty gestionnairepath = new SimpleStringProperty(BunkerManager.configMap.get("gestionnaire"));
    private SimpleStringProperty armeepath = new SimpleStringProperty(BunkerManager.configMap.get("armee"));

    @FXML
    private Label inputBunker;
    @FXML
    private Label inputMaintenance;

    @FXML
    private Label inputGestionnaire;

    @FXML
    private Label inputArmee;

    @FXML
    private Button modifierBunker;

    @FXML
    private Button modifierMaintenance;

    @FXML
    private Button modifierGestionnaire;

    @FXML
    private Button modifierArmee;
    @FXML
    private VBox main;
    @FXML
    private Button sauvegarder;
    public VBox getMain() {
        return main;
    }

    @FXML
    private void initialize() {

        modifier(modifierBunker,inputBunker,bunkerpath,true);
        modifier(modifierMaintenance,inputMaintenance,maintenancepath,false);
        modifier(modifierArmee,inputArmee,armeepath,false);
        modifier(modifierGestionnaire,inputGestionnaire,gestionnairepath,false);
        sauvegarder.setOnAction(e->{
            BunkerManager.changeConfig("maintenance",maintenancepath.get());
            BunkerManager.changeConfig("bunker",bunkerpath.get());
            BunkerManager.changeConfig("gestionnaire",gestionnairepath.get());
            BunkerManager.changeConfig("armee",armeepath.get());
            BunkerManager.saveConfig();

        });

    }
    private void modifier(Button button,Label input,SimpleStringProperty path,boolean bunker) {
        input.textProperty().bindBidirectional(path);
        button.setOnAction( e ->{
            FileChooser fileChooser = new FileChooser();
            String extension = bunker  ? "*.ser" : "*txt";
            fileChooser.setTitle("Choisir un fichier");
            try{
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier", extension));
                File file = fileChooser.showOpenDialog(modifierBunker.getScene().getWindow());
                path.set(file.getAbsolutePath());

            }catch (Exception exception){

                Alert alert = new Alert(Alert.AlertType.WARNING);

                alert.setTitle("Attention");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez entrer un fichier valide");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(getClass().getResourceAsStream("error.png")));
                alert.showAndWait();
            }

        });
    }


}
