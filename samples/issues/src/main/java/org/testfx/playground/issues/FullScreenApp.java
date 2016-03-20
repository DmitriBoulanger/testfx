package org.testfx.playground.issues;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FullScreenApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
	Label label = new Label("content");
	stage.setScene(new Scene(new StackPane(label), 100, 100));
	stage.setFullScreen(true);
	stage.show();
    }
}