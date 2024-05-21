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
        System.out.println(BunkerManager.personnels);
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
            try{
                FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("search-view.fxml"));
                Parent searchRoot = searchLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(searchRoot);
            }catch (IOException e1){

            }

        });
        controller.getAjouterBtn().addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            try{
                FXMLLoader editLoader = new FXMLLoader(getClass().getResource("add-view.fxml"));
                Parent editRoot = editLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(editRoot);
            }catch (IOException e1){

            }
        });
        controller.getBtnEdit().addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            System.out.print(10);
            try{
                FXMLLoader addLoader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
                Parent addRoot = addLoader.load();
                controller.getMain().getChildren().remove(1);
                controller.getMain().getChildren().add(addRoot);
            }catch (IOException e1){

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
            if(BunkerManager.personnels.isEmpty()){
                Administrateur administrateur = new Administrateur("2304249","zaz","koula",new GregorianCalendar(),true,10,"paris",
                        1,"test","mission");
                BunkerManager.personnels.add(administrateur);
                administrateur = new Administrateur("2304249","zaz","koula",new GregorianCalendar(),true,10,"paris",
                        1,"test","mission");
            }

            BunkerManager.saveConfig();
            BunkerManager.serealize();
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
