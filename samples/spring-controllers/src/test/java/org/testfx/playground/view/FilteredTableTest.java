package org.testfx.playground.view;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.playground.ApplicationTestAbstraction.INITIAL_ÜAUSE;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.testfx.framework.junit.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FilteredTableTest extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {

	final TableView<Item> tableView = new TableView<>();
	TableColumn<Item, String> tableColumn = new TableColumn<>("Name");
	tableColumn.setCellValueFactory(cellData -> cellData.getValue().name);
	tableView.getColumns().add(tableColumn);
	tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	final FilteredTable<Item> filterableTable = new FilteredTable<>(tableView, new TextField());
	filterableTable.setItems(toItems("foo", "bar", "baz", "Testing", "Testing, testing, 1, 2, 3"));
	filterableTable.setFilterFunction((team, filterText) -> team.getName().contains(filterText));

	stage.setScene(new Scene(filterableTable, 600, 400));
	stage.show();
    }

    public ObservableList<Item> toItems(String... names) {
	final ObservableList<Item> items = FXCollections.observableArrayList();
	for (String name : names) {
	    items.add(new Item(name));
	}
	return items;
    }
    
    @Test
    public void test_000_pause() { 
	sleep(INITIAL_ÜAUSE);
    }

    @Test
    public void test_100_Filter() {

	final TableView<Item> tableView = lookup(".table-view").query();
	final TextField textField = lookup(".text-field").query();

	clickOn(textField);

	// add filter
	write("Testing");
	verifyThat(tableView, node -> node.getItems().size() == 2);

	// remove filter
	push(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
	push(KeyCode.BACK_SPACE);
	verifyThat(tableView, node -> node.getItems().size() == 5);

	// add filter
	write("1, 2, 3");
	verifyThat(tableView, node -> node.getItems().size() == 1);

    }

}
