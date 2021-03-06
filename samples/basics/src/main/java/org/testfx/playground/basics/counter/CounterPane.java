package org.testfx.playground.basics.counter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

@SuppressWarnings("restriction")
public class CounterPane extends StackPane {
    
    private static int asInteger(String value) { 
	return Integer.parseInt(value); 
    }
    private static String asString(int value) { 
	return value + ""; 
    }

    public CounterPane() {
        // create countButton.
        Button countButton = new Button("count");
        countButton.setId("countButton");

        // create countValue.
        TextField countValue = new TextField("0");
        countValue.setId("countValue");

        // initialize controls.
        countButton.setOnAction(event -> {
            int value = asInteger(countValue.getText());
            int incrementedValue = value + 1;
            countValue.setText(asString(incrementedValue));
        });
        countValue.setEditable(false);
        countValue.setPrefWidth(50);

        // create and add containers.
        HBox box = new HBox(10, countButton, countValue);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER);
        getChildren().add(box);
    }
}
