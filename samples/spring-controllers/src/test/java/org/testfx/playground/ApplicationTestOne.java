package org.testfx.playground;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.testfx.api.FxRobotException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApplicationTestOne extends ApplicationTestAbstraction {

    @Test
    public void test_000_pause() { 
	sleep(INITIAL_ÜAUSE);
    }

    @Test(expected = FxRobotException.class)
    public void test_100_clickNonexistentElement() {
	clickOn("Nonexistent Element");
    }

    @Test
    public void test_200_selectPlayer() {
	clickOn("Cleveland Cavaliers");
	clickOn("LeBron James");
	assertThat("LeBron James", equalTo(playerTable.getSelectionModel().getSelectedItem().getName()));
    }

}
