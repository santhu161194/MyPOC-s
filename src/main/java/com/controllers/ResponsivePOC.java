package com.controllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ResponsivePOC extends Application{
@FXML Screen screen;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ResponsivePOC.class.getResource("CompleteSaleDialogPanel.fxml"));
		loader.setController(this);
		AnchorPane pane=loader.load();
		Scene scene =new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.show();
		
	}

}
