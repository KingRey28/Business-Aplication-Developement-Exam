import java.awt.Label;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Scene scene = new Scene(grid, 400, 400);
		stage.setScene(scene);
		stage.centerOnScreen();
		
		Button btn = new Button("Click Me");
		HBox hbBtn= new HBox(0);
		hbBtn.setAlignment(Pos.TOP_LEFT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 0, 0, 2, 1);
		
		Text label = new Text();
		label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
		grid.add(label, 0, 1);
		
		
		btn.setOnMouseClicked(arg0 -> {
			label.setText("Button is Clicked");
		});
		
		btn.setOnMouseEntered(arg0 -> {
			label.setText("Entering The Button");
		});
		
		btn.setOnMouseExited(arg0 -> {
			label.setText("Exited The Button");
		});
		
		stage.show();
	}
	
	
	


}
