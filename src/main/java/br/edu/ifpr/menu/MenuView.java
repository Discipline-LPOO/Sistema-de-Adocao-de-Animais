package br.edu.ifpr.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuView extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Sistema de Adoção de Animais");
        stage.show();
    }

    public static void main(String[] args) {

        System.out.println(MenuView.class.getResource("/images/logo.png"));
        launch();
    }
}
