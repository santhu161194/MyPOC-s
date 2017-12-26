package com.controllers;

import javax.swing.JOptionPane;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DomEventsPOC extends Application{
	static Element div;
	static Document document;
	static Element text1;
	static WebEngine webEngine;
	@Override
	public void start(Stage primaryStage) throws Exception {
		WebView webView = new WebView();
		webEngine  = webView.getEngine();
        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue<? extends State> ov,
                                        State oldState, State newState)
                    {
                        if (newState == State.SUCCEEDED) {
                        	document = (Document) webEngine.executeScript("document");
                            EventTarget button = (EventTarget) document.getElementById("click_me_button");
                            EventTarget text = (EventTarget) document.getElementById("box");
                            div=document.getElementById("box");
                            /*EventTarget doc = (EventTarget) document.getDocumentElement();
                            EventTarget select = (EventTarget) document.getElementById("select");
                            doc.addEventListener("resize", new MyEventListener(), false); 
                            button.addEventListener("click", new MyEventListener1(), true); 
                            text.addEventListener("focus", new MyEventListener(), false);
                            text.addEventListener("blur", new MyEventListener(), false);
                            button.addEventListener("mouseover", new MyEventListener(), true);
                            button.addEventListener("mouseout", new MyEventListener(), true);
                            select.addEventListener("change", new MyEventListener(), false);*/
                           // div=document.getElementById("div");
                            button.addEventListener("click", new MyEventListener1(), true);
                            text.addEventListener("focus", new MyEventListener(), false);
                            text1=document.getElementById("box");
                            webEngine.setOnAlert(new EventHandler<WebEvent<String>>() {

								@Override
								public void handle(WebEvent<String> event) {
									System.out.println(event.getData());
								}
							});
                            
                        }
                    }
                });
        webEngine.load(DomEventsPOC.class.getResource("DEP.html").toExternalForm());
        
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
            text1.setAttribute("value", "from jzva");
            webEngine.executeScript( 
            		"myFunction(2000)");
            document.getElementById("div").setAttribute("ng-hide", "true");
            
        }
    }
    public static void main(String[] args) {
		launch(args);
	}

}
