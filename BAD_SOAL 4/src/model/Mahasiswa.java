package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import utility.Connect;

public class Mahasiswa {
	
	private int id;
	private String nama, alamat, no_hp, jurusan;
	
	Connect con = Connect.getConnection();
	
	public int getId() {
		return id;
	}

	public String getNama() {
		return nama;
	}

	public String getAlamat() {
		return alamat;
	}


	public String getNo_hp() {
		return no_hp;
	}

	public String getJurusan() {
		return jurusan;
	}
	
	public Mahasiswa(int id, String nama, String alamat, String noHp, String jurusan) {
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.no_hp = noHp;
		this.jurusan = jurusan;
	}
	
	private Mahasiswa map(ResultSet rs) {
		int id;
		String nama, alamat, noHp, jurusan;
		try {
			id = rs.getInt("id");
			nama = rs.getString("nama");
			alamat = rs.getString("alamat");
			noHp = rs.getString("no_hp");
			jurusan = rs.getString("jurusan");
			return new Mahasiswa(id, nama,alamat, noHp, jurusan);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public boolean insertMahasiswa() {
		String query = "INSERT INTO mahasiswa(nama,alamat,no_hp,jurusan) VALUES(?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		try {
			preparedStatement.setString(1, nama);
			preparedStatement.setString(2, alamat);
			preparedStatement.setString(3, no_hp);
			preparedStatement.setString(4, jurusan);
			return preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	public Vector<Mahasiswa> getAll() {
		con.resultSet = con.execQuery("SELECT * FROM mahasiswa");
		Vector<Mahasiswa> mahasiswaVector = new Vector<>();
		try {
			while (con.resultSet.next()) {
				Mahasiswa  mahasiswa = map(con.resultSet);
				mahasiswaVector.add(mahasiswa);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mahasiswaVector;
	}
}
