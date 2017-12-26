package com.controllers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DomEvents1POC extends Application {
	static Element div;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov,
                                        State oldState, State newState)
                    {
                        if (newState == State.SUCCEEDED) {
                            Document document = (Document) webEngine.executeScript("document");
                            EventTarget button = (EventTarget) document.getElementById("click_me_button");
                            EventTarget text = (EventTarget) document.getElementById("box");
                            EventTarget doc = (EventTarget) document.getDocumentElement();
                            EventTarget select = (EventTarget) document.getElementById("select");
                            doc.addEventListener("resize", new MyEventListener(), false); 
                            button.addEventListener("click", new MyEventListener1(), true); 
                            text.addEventListener("focus", new MyEventListener(), false);
                            text.addEventListener("blur", new MyEventListener(), false);
                            button.addEventListener("mouseover", new MyEventListener(), true);
                            button.addEventListener("mouseout", new MyEventListener(), true);
                            select.addEventListener("change", new MyEventListener(), false);
                            div=document.getElementById("div");
                            
                        }
                    }
                });
        webEngine.loadContent("<script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js\"></script>"+"<button type='button' id='click_me_button'>Click Me</button>"
        		+ "<input type='text' id='box'>"
        		+" <select id='select'>\n" + 
        		"  <option value=\"volvo\">Volvo</option>\n" + 
        		"  <option value=\"saab\">Saab</option>\n" + 
        		"  <option value=\"mercedes\">Mercedes</option>\n" + 
        		"  <option value=\"audi\">Audi</option>\n" + 
        		"</select> "+
        		"<div id='div'><input type=\"checkbox\" ng-model=\"myVar\">\n" + 
        		"<div ng-hide=\"false\">\n" + 
        		"<h1>Welcome</h1>\n" + 
        		"<p>Welcome to my home.</p>\n" + 
        		"</div>");
        
        primaryStage.setScene(new Scene(webView, 800, 600));
        primaryStage.show();
    }

    private static class MyEventListener implements EventListener {
        @Override
        public void handleEvent(Event event) {
            System.out.println("Event received: " + event.getType());
        }
    }
    private static class MyEventListener1 implements EventListener {
        @Override
        public void handleEvent(Event event) {
            System.out.println("Event received1: " + event.getType());
            div.setAttribute("ng-hide", "true");
        }
    }
}