package com.controllers;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/** @see http://stackoverflow.com/a/31576647/230513 */
public class GenericWebViewPOC {

    private void initAndShowGUI() {
        // This method is invoked on the EDT thread
        JFrame frame = new JFrame("Swing and JavaFX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JFXPanel fxPanel = new JFXPanel(){

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(640, 480);
            }
        };
        frame.add(fxPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Platform.runLater(() -> {
            initFX(fxPanel);
        });
    }

    private WebView webView;

    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private Scene createScene() {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://www.google.com");
        root.getChildren().add(webView);
        return scene;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GenericWebViewPOC()::initAndShowGUI);
    }
}