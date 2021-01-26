package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Dipendenti;
import model.Turni;

public class DipendenteDao {
	public void inserisciDipendente(Dipendenti dip) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO dipendenti(nome, cognome,codiceFiscale) VALUES(?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, dip.getNome());
			cmd.setString(2, dip.getCognome());
			cmd.setString(3, dip.getCodiceFiscale());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<Dipendenti> ritornaListaDipendenti() {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Dipendenti> l1 = new ArrayList<>();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM dipendenti";
			cmd = dbConnection.prepareStatement(query);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				Dipendenti nuovo = new Dipendenti(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
				l1.add(nuovo);
				esci = res.next();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		return l1;
	}
	
	public Dipendenti ritornaDipendenti(int id) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Dipendenti nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM dipendenti WHERE matricola=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new Dipendenti(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			}else {
				nuovo= new Dipendenti(0, "Dipendente", "Non", "Trovato");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
		return nuovo;
	}

	public void aggiornaDipendenti(Dipendenti dip) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE dipendenti SET nome=?, cognome=?, codiceFiscale=? WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, dip.getNome());
			cmd.setString(2, dip.getCognome());
			cmd.setInt(4, dip.getMatricola());
			cmd.setString(3, dip.getCodiceFiscale());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public void cancellaDipendenti(Dipendenti dip) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM dipendenti WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, dip.getMatricola());
			// execute update SQL stetement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cmd != null) {
				try {
					cmd.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	public static void main(String[] args) throws SQLException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date1 = sdf.parse("31/12/2025");
		Date d1 = new Date(date1.getTime());
		TurniDao td= new TurniDao();
		Turni tur = new Turni(11,444, d1,d1);
		td.inserisciTurni(tur);
	}
	
}
