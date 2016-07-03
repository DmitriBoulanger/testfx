package org.testfx.playground.basics.counter;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;

import java.awt.TextField;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import org.testfx.framework.junit.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CounterTest extends ApplicationTest {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setScene(new Scene(new CounterPane(), 200, 50));
        stage.show();
    }
    
    @Test
    public void test_000_pause() {
        sleep(1500);
    }


    @Test
    public void test_100_should_initialize_countValue() {
        // expect:
        verifyThat(lookup(hasText("0")), notNullValue());
    }

    @Test
    public void  test_200_should_increment_countValue() {
	
        // when:
        clickOn("count");
        
        // then:
        verifyThat(lookup(hasText("1")), notNullValue());
    }

    @Test
    public void  test_3000_should_increment_countValue_again() {
	
        // when:
        clickOn("count").clickOn("count");

        // then:
        verifyThat(lookup(hasText("2")), notNullValue());
    }

}
