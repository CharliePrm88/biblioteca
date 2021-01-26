package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Turni;

public class TurniDao {
	public void inserisciTurni(Turni tur) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO turni(matricola, data_inizio_turno,data_fine_turno) VALUES(?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, tur.getMatricola());
			cmd.setDate(2, tur.getData_inizio_turno());
			cmd.setDate(3, tur.getData_fine_turno());
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

	public List<Turni> ritornaListaTurni() {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Turni> l1 = new ArrayList<>();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM turni";
			cmd = dbConnection.prepareStatement(query);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				Turni nuovo = new Turni(res.getInt("id"), res.getInt("matricola"),res.getDate("data_inizio_turno"),res.getDate("data_fine_turno"));
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
	
	public Turni ritornaTurni(int id) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Turni nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM turni WHERE id=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new Turni(res.getInt("id"), res.getInt("matricola"),res.getDate("data_inizio_turno"),res.getDate("data_fine_turno"));
			}else {
				nuovo = new Turni(0,0,null,null);
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

	public void aggiornaTurni(Turni tur) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE turni SET matricola=?,data_inizio_turno=?,data_fine_turno=? WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, tur.getMatricola());
			cmd.setDate(2, tur.getData_inizio_turno());
			cmd.setDate(3, tur.getData_fine_turno());
			cmd.setInt(4, tur.getId());
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

	public void cancellaTurni(Turni tur) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM turni WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, tur.getId());
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