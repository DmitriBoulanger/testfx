package org.testfx.playground.basics.counter;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class CounterTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new CounterPane(), 200, 50));
        stage.show();
    }

    @Test
    public void should_initialize_countValue() {
        // expect:
        verifyThat("#countValue", hasText("0"));
    }

    @Test
    public void should_increment_countValue() {
        // when:
        clickOn("count");
        
        // then:
        verifyThat("#countValue", hasText("1"));
    }

    @Test
    public void should_increment_countValue_again() {
        // when:
        clickOn("count").clickOn("count");

        // then:
        verifyThat("#countValue", hasText("2"));
    }

}
