import javafx.application.Application;
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

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane layout = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("File");
		Menu menu2 = new Menu("Edit");

		MenuItem itemOpen = new MenuItem("Open");
		MenuItem itemQuit = new MenuItem("Quit");
		
		menu1.getItems().addAll(itemOpen, itemQuit);
		menuBar.getMenus().addAll(menu1, menu2);
		layout.setTop(menuBar);
		
		itemOpen.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Open is Clicked");
			}
		});
		
		itemQuit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Quit is Clicked");
			}
		});
			
		Scene scene = new Scene(layout, 500, 500);
		stage.setScene(scene);
		stage.centerOnScreen();
	
		stage.show();	
	}

}
