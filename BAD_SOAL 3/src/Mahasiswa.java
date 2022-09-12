import java.sql.ResultSet;


public class Mahasiswa {
	private int id,umur;
	private String name, alamat;
	
	public Mahasiswa(ResultSet rs) {
		try {
			id = rs.getInt("id");
			umur = rs.getInt("umur");
			name = rs.getString("name");
			alamat = rs.getString("alamat");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getId() {
		return id;
	}

	public int getUmur() {
		return umur;
	}

	public String getName() {
		return name;
	}

	public String getAlamat() {
		return alamat;
	}
	
}
