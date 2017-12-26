package com.controllers;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;

public class CardLayoutPOC extends JFrame{
	public CardLayoutPOC() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel pane = new panel();
		//pane.setBackground(Color.BLUE);
		pane.setBounds(20, 30, 100, 200);
		add(pane);
		pack();
		setVisible(true);
	
	}
	public static void main(String[] args) {
		CardLayoutPOC sx=new CardLayoutPOC();
		}
}

class panel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1753510127666222053L;

	panel() {
		
		CardLayout cl= new CardLayout();
		setLayout(cl);
		FX fx = new FX();
		add("fx", fx);
		cl.show(this,"fx");
	}

}

class FX extends JFXPanel{
	public FX() {
	BorderPane lay=new BorderPane();
	//lay.setStyle("-fx-background-color: #000;");
	lay.setCenter(new Label("5465sa4d8asd4a5ds1a6sd4as8f48as61fdfhsajdfalskdlfhsliwudfhuwekasgbeufggefurguebuaegfwigfwsfihfskdjghdjfhsdjklfhsiofhwefhnwuiefbdjkvbjksdviuewrbhvurueigfbfhsiufhsiodfhsdlfhksiofhsifojsf;fhsdfoishgdfisuhdfkjdsfhusidfewgofhsuifhbnsifsdjkvbsdnjkfshfksdjhfeiowfheruifheoifhwfjkslfshfd's;odfihwafpwe'wwwwwwwwwww[fispfdsiofhdsfs;ldkfhsdl;j"));
	Scene scene=new Scene(lay);
	setScene(scene);
	}	
}
