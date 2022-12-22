package de.bs1bt.ams.mvc;

import de.bs1bt.ams.factories.MySqlDaoFactory;
import de.bs1bt.ams.gateways.*;
import eu.hansolo.tilesfx.Command;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("BS1 BT - Asset Management System");
        stage.setScene(scene);


        MainController mc = fxmlLoader.getController();

        var test = MySqlDaoFactory.class;

        try {
            mc.setRaumDao(test.getDeclaredConstructor().newInstance().createRaumDao());
        } catch (InstantiationException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
//        mc.setRaumDao(new RaumDao());
        mc.zeigeRaeumeInTabelle();
        mc.zeigeGesamtflaeche();

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}