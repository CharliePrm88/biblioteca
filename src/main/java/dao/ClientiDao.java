package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Clienti;

public class ClientiDao {
	public void inserisciCliente(Clienti c) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO clienti(nome, cognome,codiceFiscale) VALUES(?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, c.getNome());
			cmd.setString(2, c.getCognome());
			cmd.setString(3, c.getCodiceFiscale());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Clienti> ritornaListaClienti() {
		List<Clienti> l1 = new ArrayList<>();
		try {
		DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
		Connection dbConnection = ds.getConnection();
		java.sql.PreparedStatement cmd = null;
		String query = "SELECT * FROM clienti";
		cmd = dbConnection.prepareStatement(query);
		// execute update SQL statement
		ResultSet res = cmd.executeQuery();
		System.out.println("Record retrieved!");
		boolean esci = res.next();
		while(esci) {
			Clienti nuovo = new Clienti(res.getInt("idCliente"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			l1.add(nuovo);
			esci = res.next();
		}
		cmd.close();
		dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l1;
	}
	
	public Clienti ritornaClienti(int id) {
		Clienti nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM clienti WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			// execute update SQL statement
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
			nuovo = new Clienti(res.getInt("idCliente"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			}else {nuovo= new Clienti(0,"Cliente","Non","Trovato");}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nuovo;
	}

	public void aggiornaClienti(Clienti cli) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE clienti SET nome=?, cognome=?,codiceFiscale=? WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, cli.getNome());
			cmd.setString(2, cli.getCognome());
			cmd.setInt(4, cli.getIdCliente());
			cmd.setString(3, cli.getCodiceFiscale());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaClienti(Clienti cli) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM clienti WHERE idCliente=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, cli.getIdCliente());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
