package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class Login {

	public Login(Stage stage) {
		stage.setTitle("Authentication");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Scene scene = new Scene(grid, 400, 400);
		stage.setScene(scene);
		stage.centerOnScreen();

		Text scenetitle = new Text("LOGIN");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("Username:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		userTextField.setText("reynaldi.rasubala");
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		pwBox.setText("123456");
		grid.add(pwBox, 1, 2);

		Button btnLogin = new Button("Login");
		HBox hbBtnLogin = new HBox(0);
		hbBtnLogin.setAlignment(Pos.TOP_LEFT);
		hbBtnLogin.getChildren().add(btnLogin);


		GridPane grid_inner = new GridPane();
		grid_inner.setHgap(10);
		grid_inner.setPadding(new Insets(0, 0, 0, 25));
		grid_inner.add(hbBtnLogin, 0, 0);

		grid.add(grid_inner, 1, 4);

		btnLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String username = userTextField.getText().toString();
				String pass = pwBox.getText().toString();
				User user = getAuthentication(username, pass);

				if (user != null) {
					information();
					new MasterTemplate(stage);
				} else {
					alert();
				}
			}
		});



		stage.show();
	}
	
	private User getAuthentication(String username, String password) {
		User user = new User(-1, null, null);
		user = user.getUser(username, password);
		
		if (user != null) {
			return user;
		}

		return null;
	}
	
	private void alert() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("Invalid username/password");
		alert.showAndWait();
	}
	
	private void information() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Logged in!");
		alert.showAndWait();
	}
}
