package com.controllers;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
 
public class CustomHTMLEditorPOC extends Application {
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(400);
        stage.setHeight(300);   
        final HTMLEditor htmlEditor = new PrintPreviewComponent();
        htmlEditor.setPrefHeight(245);
        //hideHTMLEditorToolbars(htmlEditor);
        htmlEditor.setOnInputMethodTextChanged(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				System.out.println("Emo idni");
				
			}
		});
        htmlEditor.setHtmlText("<b>SNO</b></br><h1>ghfgjksagh</h1>"
        		+ "sdfhkjshfjksdhjfhsfjkafdshfkjsdh;fsdjf;sf"
        		+ "dfsh'kfjfsd;fhsdfh;sjdfdhfksdfs;jksdhksd;j"
        		+ "jksdfhjsh;dfhsdkjfsdhfjkdshfjksdhfkjsda"
        		+ "<h1>jksfhsdkjfsdj;fh;sdhfjsdk;fksdhf</h1>"
        		+ "dhfkjshfkjsdhfhsdkjfhsdkjfhsad;"
        		+ "<h1>jksfhsdkjfsdj;fh;sdhfjsdk;fksdhf</h1>"
        		+ "<h1>jksfhsdkjfsdj;fh;sdhfjsdk;fksdhf</h1>"
        		+ "<h1>jksfhsdkjfsdj;fh;sdhfjsdk;fksdhf</h1></body>");
        //AnchorPane pane=addAnchorPane(addGridPane());
        Scene scene = new Scene(htmlEditor); 
        
        stage.setScene(scene);
        stage.show();
       
      
    }
    


public static void hideHTMLEditorToolbars(final HTMLEditor editor)
{
    editor.setVisible(false);
    Platform.runLater(new Runnable()
    {
        @Override
        public void run()
        {
            Node[] nodes = editor.lookupAll(".tool-bar").toArray(new Node[0]);
            for(Node node : nodes)
            {
                node.setVisible(false);
                node.setManaged(false);
            }
            editor.setVisible(true);
        }
    });
}

public GridPane addGridPane() {
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(0, 10, 0, 10));

    // Category in column 2, row 1
    Text category = new Text("Sales:");
    category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    grid.add(category, 1, 0); 

    // Title in column 3, row 1
    Text chartTitle = new Text("Current Year");
    chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
    grid.add(chartTitle, 2, 0);

    // Subtitle in columns 2-3, row 2
    Text chartSubtitle = new Text("Goods and Services");
    grid.add(chartSubtitle, 1, 1, 2, 1);

   

    // Left label in column 1 (bottom), row 3
    Text goodsPercent = new Text("Goods\n80%");
    GridPane.setValignment(goodsPercent, VPos.BOTTOM);
    grid.add(goodsPercent, 0, 2); 

   

    // Right label in column 4 (top), row 3
    Text servicesPercent = new Text("Services\n20%");
    GridPane.setValignment(servicesPercent, VPos.TOP);
    grid.add(servicesPercent, 3, 2);

    return grid;
}

public AnchorPane addAnchorPane(GridPane grid) {
    AnchorPane anchorpane = new AnchorPane();
    Button buttonSave = new Button("Save");
    Button buttonCancel = new Button("Cancel");

    HBox hb = new HBox();
    hb.setPadding(new Insets(0, 10, 10, 10));
    hb.setSpacing(10);
    hb.getChildren().addAll(buttonSave, buttonCancel);

    anchorpane.getChildren().addAll(grid,hb);   // Add grid from Example 1-5
    AnchorPane.setBottomAnchor(hb, 8.0);
    AnchorPane.setRightAnchor(hb, 5.0);
    AnchorPane.setTopAnchor(grid, 10.0);

    return anchorpane;
}



 
    public static void main(String[] args) {
        launch(args);
    }
}