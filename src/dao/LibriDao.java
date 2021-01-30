package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Libri;

public class LibriDao {

	public void inserisciLibri(Libri lib) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO libri(annoDiStampa,numeroPagine,titolo,genere,autore,isbn,casaeditrice,posizione) VALUES(?,?,?,?,?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setDate(1, lib.getAnnoDiStampa());
			cmd.setInt(2, lib.getNumeroPagine());
			cmd.setString(3, lib.getTitolo());
			cmd.setString(4, lib.getGenere());
			cmd.setString(5, lib.getAutore());
			cmd.setString(6, lib.getISBN());
			cmd.setString(7, lib.getCasaEditrice());
			cmd.setString(8, lib.getPosizione());
			// execute update SQL statement
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

	public List<Libri> ritornaListaLibri() {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Libri> l1 = new ArrayList<>();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM libri";
			cmd = dbConnection.prepareStatement(query);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				Libri nuovo = new Libri(res.getInt("idlibro"),res.getDate("annodistampa"),res.getInt("numeropagine"),res.getString("titolo"),res.getString("genere"),res.getString("autore"),res.getString("isbn"),res.getString("casaeditrice"),res.getString("posizione"));
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
	
	public Libri ritornaLibro(int idLibro) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Libri nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM libri WHERE idLibro=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, idLibro);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			System.out.print(res);
			if(esci) {	
			nuovo = new Libri(res.getInt("idlibro"),res.getDate("annodistampa"),res.getInt("numeropagine"),res.getString("titolo"),res.getString("genere"),res.getString("autore"),res.getString("isbn"),res.getString("casaeditrice"),res.getString("posizione"));
			}else {
				nuovo = new Libri(0,null,0,"Libro","Non","Trovato",null,null,null);
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

	public void aggiornaLibri(Libri lib) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE libri SET annoDiStampa=?,numeroPagine=?,titolo=?,genere=?,autore=?,isbn=?,casaeditrice=?,posizione=? WHERE idLibro=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(9, lib.getIdlibro());
			cmd.setDate(1, lib.getAnnoDiStampa());
			cmd.setInt(2, lib.getNumeroPagine());
			cmd.setString(3, lib.getTitolo());
			cmd.setString(4, lib.getGenere());
			cmd.setString(5, lib.getAutore());
			cmd.setString(6, lib.getISBN());
			cmd.setString(7, lib.getCasaEditrice());
			cmd.setString(8, lib.getPosizione());
			// execute update SQL statement
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

	public void cancellaLibri(Libri lib) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM libri WHERE idLibro=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, lib.getIdlibro());
			// execute update SQL statement
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
}