package org.testfx.playground.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
    
	public final StringProperty name;
	public Item(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public String getName() {
		return name.get();
	}
}
