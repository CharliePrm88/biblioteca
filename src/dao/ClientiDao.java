package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Clienti;

public class ClientiDao {
	List<Clienti> l1 = new ArrayList<>();

	public void inserisciCliente(Clienti c) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "INSERT INTO clienti(nome, cognome,idCliente,codiceFiscale) VALUES(?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, c.getNome());
			cmd.setString(2, c.getCognome());
			cmd.setInt(3, c.getIdCliente());
			cmd.setString(4, c.getCodiceFiscale());
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
	
	public List<Clienti> ritornaListaClienti() {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		List<Clienti> l1 = new ArrayList<>();
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM clienti";
			cmd = dbConnection.prepareStatement(query);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				Clienti nuovo = new Clienti(res.getInt("idCliente"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
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
	
	public Clienti ritornaClienti(int id) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		Clienti nuovo = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String query = "SELECT * FROM clienti WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL stetement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
			nuovo = new Clienti(res.getInt("idCliente"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			}else {nuovo= new Clienti(0,"Cliente","Non","Trovato");}}
			 catch (Exception e) {
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

	public void aggiornaClienti(Clienti cli) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "UPDATE clienti SET nome=?, cognome=?,codiceFiscale=? WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, cli.getNome());
			cmd.setString(2, cli.getCognome());
			cmd.setInt(4, cli.getIdCliente());
			cmd.setString(3, cli.getCodiceFiscale());
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

	public void cancellaClienti(Clienti cli) {
		Connection dbConnection = null;
		java.sql.PreparedStatement cmd = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);
			// Creiamo la stringa di connessione
			String url = "jdbc:mysql://localhost:3306/biblioteca?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Otteniamo una connessione con username e password
			dbConnection = DriverManager.getConnection(url, "root", "CharliePrm88");
			String updateTableSQL = "DELETE FROM clienti WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, cli.getIdCliente());
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
