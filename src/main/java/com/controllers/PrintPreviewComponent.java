package com.controllers;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * 
 * @author Santhosh
 * Custom Component implementing the JAVAFx HTMLEditor But removing the Editable Property and also the Controls
 *
 */
public class PrintPreviewComponent extends HTMLEditor{
	
	public PrintPreviewComponent() {
		 this.setVisible(false);
		 Node[] nodes = this.lookupAll(".tool-bar").toArray(new Node[0]);
		            for(Node node : nodes)
		            {
		                node.setVisible(false);
		                node.setManaged(false);
		            }
		           
		            this.addEventFilter(KeyEvent.ANY, (Event event)->{
		            	event.consume();
		            });
		            
		            this.setVisible(true);
		        }
	@Override
	public void setHtmlText(String htmlText) {
		if(htmlText.contains("contenteditable=\"true\"")){
			htmlText=htmlText.replace("contenteditable=\"true\"", "contenteditable=\"false\"");
		}
		htmlText= "<html><head>"
		        + "</head><body contenteditable='false'>"
		        +htmlText+"</body></html>";
		super.setHtmlText(htmlText);
		
	}
	
	
	
	
	
	
	
}
