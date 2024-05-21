package com.example.bunker;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GuiController {
    @FXML
    private HBox main;
    @FXML
    private HBox configurationBtn;
    @FXML
    private HBox rechercheBtn;

    @FXML
    private HBox ajouterBtn;

    public HBox getMain() {
        return main;
    }
    public HBox getConfigurationBtn() {
        return configurationBtn;
    }

    public HBox getRechercheBtn() {
        return rechercheBtn;
    }
    public HBox getAjouterBtn() {
        return ajouterBtn;
    }
}