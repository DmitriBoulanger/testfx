package org.testfx.playground;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.testfx.api.FxRobotException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClientApplicationTestOne extends ClientApplicationTestAbstraction {

	@Test(expected = FxRobotException.class)
	public void test_000_clickNonexistentElement() {
		clickOn("Nonexistent Element");
	}

	@SuppressWarnings("restriction")
	@Test
	public void test_100_selectPlayer() {
		clickOn("Cleveland Cavaliers");
		clickOn("LeBron James");
		assertThat("LeBron James", equalTo(playerTable.getSelectionModel().getSelectedItem().getName()));
	}

}
