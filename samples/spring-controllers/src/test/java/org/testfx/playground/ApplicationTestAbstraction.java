package org.testfx.playground;

import org.junit.Before;
import org.junit.BeforeClass;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.playground.model.Player;

import javafx.scene.control.TableView;
import javafx.stage.Stage;

public abstract class ApplicationTestAbstraction extends ApplicationTest {
    
    	public static final long INITIAL_ÜAUSE = 1600;

	protected TableView<Player> playerTable;

	@BeforeClass
	public static void setUpClass() throws Exception {
		ApplicationTest.launch(ClientApplication.class);
	}

	@Before
	public void setUp() {
		playerTable = lookup("#playerTable").query();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.show();
	}

}
