package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.RegistroLibri;

public class RegistroLibriDao {

	public void inserisciregendente(RegistroLibri tur) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO registrolibri(id, idlibro, matricola,idcliente,data_prestito, data_scadenza,data_rientro) VALUES(?,?,?,?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, tur.getId());
			cmd.setInt(2, tur.getIdlibro());
			cmd.setInt(3, tur.getMatricola());
			cmd.setInt(4, tur.getIdcliente());
			cmd.setDate(5, tur.getData_prestito());
			cmd.setDate(6, tur.getData_scadenza());
			cmd.setDate(7, tur.getData_rientro());
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

	public List<RegistroLibri> ritornaListaRegistroLibri() {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<RegistroLibri> l1 = new ArrayList<>();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM registrolibri";
			cmd = dbConnection.prepareStatement(query);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				RegistroLibri nuovo = new RegistroLibri(res.getInt("id"),res.getInt("idLibro"),res.getInt("idCliente"),res.getInt("matricola"),res.getDate("data_prestito"),res.getDate("data_scadenza"),res.getDate("data_rientro"));
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
	
	public RegistroLibri ritornaRegistroLibri(int id) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		RegistroLibri nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM registrolibri WHERE id=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new RegistroLibri(res.getInt("id"),res.getInt("idLibro"),res.getInt("idCliente"),res.getInt("matricola"),res.getDate("data_prestito"),res.getDate("data_scadenza"),res.getDate("data_rientro"));
			}else {
				nuovo = new RegistroLibri(0,0,0,0,null,null,null);
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

	public void aggiornaRegistroLibri(RegistroLibri reg) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE turni SET idlibro, matricola,data_prestito, data_scadenza,data_rientro where id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(6, reg.getId());
			cmd.setInt(1, reg.getIdlibro());
			cmd.setInt(2, reg.getMatricola());
			cmd.setDate(3, reg.getData_prestito());
			cmd.setDate(4, reg.getData_scadenza());
			cmd.setDate(5, reg.getData_rientro());
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

	public void cancellaRegistroLibri(RegistroLibri reg) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM registrolibri WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, reg.getId());
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
}