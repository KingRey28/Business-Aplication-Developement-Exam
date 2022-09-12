package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MasterTemplate {
	
	public MasterTemplate(Stage stage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		
		BorderPane layout = new BorderPane();
		
		Menu menu = new Menu("Account");
		MenuBar menuBar = new MenuBar();
		MenuItem itemLogout = new MenuItem("Logout");
		
		menu.getItems().add(itemLogout);
		menuBar.getMenus().add(menu);
		layout.setTop(menuBar);
		
		itemLogout.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				new Login(stage);
			}
		});
		
		new Management(stage, layout);
		
		Scene scene = new Scene(layout, 1000, 1000);
		stage.setScene(scene);
		stage.centerOnScreen();
	}
}
