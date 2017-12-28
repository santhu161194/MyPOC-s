package com.controllers;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ProgressBarCustom extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400);
       // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        Service<Void> serv = new Service<Void>() {

            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {
                        int maxWork = 10;
                        for (int i = 0; i < maxWork; i++) {
                            Thread.sleep(1000);
                            updateProgress(i + 1, maxWork);
                        }

                        return null;
                    }

                    @Override
                    protected void succeeded() {
                        super.succeeded();
                        updateProgress(1, 1);
                    }

                    @Override
                    protected void cancelled() {
                        super.cancelled();
                        updateProgress(1, 1);
                    }

                    @Override
                    protected void failed() {
                        super.failed();
                        updateProgress(1, 1);
                    }

                };
            }
        };

        ProgressIndicator pi = new ProgressIndicator();
        pi.progressProperty().bind(serv.progressProperty());


        Button bStart = new Button("Start");
        bStart.setOnAction(e -> {
            serv.reset();
            serv.start();
        });

        root.setCenter(bStart);
        root.setBottom(pi);

        primaryStage.setScene(scene);
        primaryStage.show();

        pi.getScene().getRoot().disableProperty().bind(serv.runningProperty());
    }

    public static void main(String[] args) {
        launch(args);
    }
}