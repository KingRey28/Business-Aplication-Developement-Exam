package view;

import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jfxtras.labs.scene.control.window.Window;
import model.Mahasiswa;

public class Management {

	GridPane gridPane;
	TableView<Mahasiswa> tableMahasiswa;
	
	Label lblNama, lblAlamat, lblNoTelp, lblJurusan;
	TextField inputNama, inputAlamat, inputNoTelp, inputJurusan;
	
	public Management(Stage stage, BorderPane borderPane) {
		Window window = new Window("Mahasiswa");
		borderPane.setCenter(window);

		gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT);
		gridPane.setPadding(new Insets(25));
		gridPane.setVgap(10);
		gridPane.setHgap(20);
		
		tableMahasiswa = new TableView<>();
		gridPane.add(tableMahasiswa, 0, 1, 10, 1);

		lblNama = new Label("Nama");
		gridPane.add(lblNama, 0, 3);

		inputNama = new TextField();
		gridPane.add(inputNama, 0, 4);

		lblAlamat = new Label("Alamat");
		gridPane.add(lblAlamat, 0, 5);

		inputAlamat = new TextField();
		gridPane.add(inputAlamat, 0, 6);
		
		lblNoTelp = new Label("No. Telp");
		gridPane.add(lblNoTelp, 1, 3);

		inputNoTelp = new TextField();
		gridPane.add(inputNoTelp, 1, 4);
		
		lblJurusan = new Label("Jurusan");
		gridPane.add(lblJurusan, 1, 5);

		inputJurusan = new TextField();
		gridPane.add(inputJurusan, 1, 6);

		Button btnSave = new Button("Save");
		btnSave.setMaxHeight(Double.MAX_VALUE);
		btnSave.setMinWidth(466);
		gridPane.add(btnSave, 0, 9, 7, 1);
		
		addTableColumn();
		getData();
		
		btnSave.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				String nama = inputNama.getText().toString();
				String alamat = inputAlamat.getText().toString();
				String noHP = inputNoTelp.getText().toString();
				String jurusan = inputJurusan.getText().toString();
				
				int validation = validateInputField(nama, alamat, noHP, jurusan);
				if(validation == 4) {
					Mahasiswa mahasiswa = new Mahasiswa (-1, nama, alamat, noHP, jurusan);
					mahasiswa.insertMahasiswa();
					info("Data telah disimpan!");
					getData();
				} 
					
			
			}
		});
		
		window.getContentPane().getChildren().add(gridPane);
	}
	
	private void addTableColumn() {
		TableColumn<Mahasiswa, Integer> id = new TableColumn<>("ID");
		TableColumn<Mahasiswa, String> nama = new TableColumn<>("Nama");
		TableColumn<Mahasiswa, String> alamat = new TableColumn<>("Alamat");
		TableColumn<Mahasiswa, String> noHP = new TableColumn<>("No HP");
		TableColumn<Mahasiswa, String> jurusan = new TableColumn<>("Jurusan");

		id.setResizable(false);
		id.setMinWidth(100);
		id.setReorderable(false);
		id.setCellValueFactory(new PropertyValueFactory<Mahasiswa, Integer>("id"));

		nama.setResizable(false);
		nama.setReorderable(false);
		nama.setMinWidth(250);
		nama.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));

		alamat.setResizable(false);
		alamat.setMinWidth(200);
		alamat.setReorderable(false);
		alamat.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("alamat"));

		noHP.setResizable(false);
		noHP.setMinWidth(170);
		noHP.setReorderable(false);
		noHP.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("no_hp"));

		jurusan.setResizable(false);
		jurusan.setMinWidth(250);
		jurusan.setReorderable(false);
		jurusan.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("jurusan"));

		tableMahasiswa.getColumns().addAll(id, nama, alamat, noHP, jurusan);
	}
	
	private void alert(String alertMsg) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(alertMsg);
		alert.showAndWait();
	}
	
	private void info(String alertMsg) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Notification");
		alert.setHeaderText(alertMsg);
		alert.showAndWait();
	}
	
	private int validateInputField(String nama, String alamat, String noHp, String jurusan) {
		int counter = 0;
		if (nama.length() <= 0) {
			alert("Kolom nama tidak boleh kosong!");
		} else {
			counter++;
		}
		if (alamat.length() <= 0) {
			alert("Kolom alamat tidak boleh kosong!");
		} else {
			counter++;
		}
		if (noHp.length() <= 0) {
			alert("Kolom No HP tidak boleh kosong!");
		} else {
			counter++;
		}
		if (jurusan.length() <= 0) {
			alert("Kolom jurusan tidak boleh kosong!");
		} else {
			counter++;
		}
		return counter;
	}
	
	private void getData() {
		tableMahasiswa.getItems().clear();
		Mahasiswa mahasiswa = new Mahasiswa(-1, null, null, null, null);
		Vector<Mahasiswa> mahasiswaVector = new Vector<Mahasiswa>();
		mahasiswaVector = mahasiswa.getAll();
		mahasiswa = new Mahasiswa(-1, null, null, null, null);
		for(Mahasiswa data : mahasiswaVector) {
			mahasiswa = new Mahasiswa(data.getId(), data.getNama(),data.getAlamat(), data.getNo_hp(), data.getJurusan());
			tableMahasiswa.getItems().add(mahasiswa);
		}
	}
}
