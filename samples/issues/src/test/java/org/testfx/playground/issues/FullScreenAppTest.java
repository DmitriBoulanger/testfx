package org.testfx.playground.issues;

import static org.hamcrest.Matchers.equalTo;
import static org.testfx.api.FxAssert.verifyThat;

import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxToolkit;

import javafx.stage.Stage;

public class FullScreenAppTest {
    Stage stage;

    @Before
    public void setup() throws Exception {
        stage = FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(FullScreenApp.class);
    }

    @Test
    public void stage_should_be_visible() {
        // expect:
        verifyThat(stage.isFullScreen(), equalTo(true));
    }
}
