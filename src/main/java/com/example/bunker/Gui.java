package com.example.bunker;

import com.example.bunker.pkgBunker.pkgGestionnaire.Administrateur;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Gui extends Application {
    BunkerManager manager = new BunkerManager();
    @Override
    public void start(Stage stage) throws IOException {
        //chargement de la configuration
        BunkerManager.loadConfig();
        BunkerManager.deserealize();
        BunkerManager.initData();
        BunkerManager.trierPersonnelsParDateNaissance();

        // Chargement du fichier FXML principal
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bunker-view.fxml"));
        Parent root = fxmlLoader.load();




        // Récupération des contrôleurs
        GuiController controller = fxmlLoader.getController();
        FXMLLoader configurationLoader = new FXMLLoader(getClass().getResource("configuration-view.fxml"));
        Parent configurationRoot = configurationLoader.load();


        // Ajout de la vue de configuration au contrôleur principal
        controller.getMain().getChildren().add(configurationRoot);
        controller.getConfigurationBtn().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            controller.getMain().getChildren().remove(1);
            controller.getMain().getChildren().add(configurationRoot);
        });
        controller.getRechercheBtn().addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            BunkerManager.trierPersonnelsParDateNaissance();

            try{
                FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("search-view.fxml"));
                Parent searchRoot = searchLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(searchRoot);
            }catch (IOException e1){
                e1.printStackTrace();
            }

        });
        controller.getAjouterBtn().addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            BunkerManager.trierPersonnelsParDateNaissance();
            try{
                FXMLLoader editLoader = new FXMLLoader(getClass().getResource("add-view.fxml"));
                Parent editRoot = editLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(editRoot);
            }catch (IOException e1){

            }
        });
        controller.getBtnEdit().addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            BunkerManager.trierPersonnelsParDateNaissance();

            try{
                FXMLLoader addLoader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
                Parent addRoot = addLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(addRoot);
            }catch (IOException e1){
                System.out.println(e1);
            }
        });
        // Création de la scène
        Scene scene = new Scene(root, 900, 640);

        // Ajout d'une icône à la fenêtre
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.jpg"))));
        // Configuration de la fenêtre
        stage.setResizable(false);
        stage.setTitle("BunkerManager");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            BunkerManager.saveConfig();
            BunkerManager.serealize();
            BunkerManager.initWriteFile();
            BunkerManager.trierPersonnelsParDateNaissance();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
