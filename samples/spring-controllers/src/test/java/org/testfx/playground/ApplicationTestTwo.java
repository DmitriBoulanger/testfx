package org.testfx.playground;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.playground.model.Player;

import javafx.scene.control.TableColumn;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationTestTwo extends ApplicationTestAbstraction {
    
    @Test
    public void test_000_pause() { 
	sleep(INITIAL_ÜAUSE);
    }


    @Test
    public void test_100_ImportTeamsAndPlayers() {

	clickOn("File").moveTo("Import").clickOn("More Teams");
	clickOn("Miami Heat");

	assertThat(playerTable.getItems(), hasSize(0));

	clickOn("File").moveTo("Import").clickOn("More Players");
	clickOn("Chris Bosh");

	assertThat("Chris Bosh", equalTo(playerTable.getSelectionModel().getSelectedItem().getName()));
    }

    @Test
    public void test_200_ToggleFieldGoalPercentage() {
	// TODO: lookup the TableColumn directly (by id)?
	TableColumn<Player, ?> fieldGoalPercentageColumn = null;
	for (TableColumn<Player, ?> column : playerTable.getColumns()) {
	    if (column.getText().equals("FG %")) {
		fieldGoalPercentageColumn = column;
	    }
	}
	
	assertThat(fieldGoalPercentageColumn, notNullValue());
	
	assertThat(fieldGoalPercentageColumn.isVisible(), is(true));

	clickOn("View").sleep(100).clickOn("Show FG %");
	assertThat(fieldGoalPercentageColumn.isVisible(), is(false));

	clickOn("View").sleep(100).clickOn("Show FG %");
	assertThat(fieldGoalPercentageColumn.isVisible(), is(true));

    }

}
