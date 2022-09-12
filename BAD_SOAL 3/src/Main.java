import java.util.Vector;

public class Main {
	
	Connect con = Connect.getConnection();
	
	public Main() {
		Vector<Mahasiswa> mahasiswaVector = new Vector<>();
		
		try {
			con.resultSet = con.execQuery(
					"SELECT * FROM mahasiswa");
			while (con.resultSet.next()) {
				Mahasiswa mahasiswa = new Mahasiswa(con.resultSet);
				mahasiswaVector.add(mahasiswa);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(Mahasiswa m: mahasiswaVector) {
			System.out.println("Id : " + m.getId());
			System.out.println("Name: " + m.getName());
			System.out.println("Alamat: " + m.getAlamat());
			System.out.println("Umur : " + m.getUmur());
			System.out.println("=========================");
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
