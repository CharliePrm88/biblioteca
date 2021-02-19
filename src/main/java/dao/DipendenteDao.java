package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.Dipendenti;

public class DipendenteDao {
	public void inserisciDipendente(Dipendenti dip) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO dipendenti(nome, cognome,codiceFiscale) VALUES(?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, dip.getNome());
			cmd.setString(2, dip.getCognome());
			cmd.setString(3, dip.getCodiceFiscale());
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

	public List<Dipendenti> ritornaListaDipendenti() {
		List<Dipendenti> l1 = new ArrayList<>();
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM dipendenti";
			cmd = dbConnection.prepareStatement(query);
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				Dipendenti nuovo = new Dipendenti(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
				l1.add(nuovo);
				esci = res.next();
			}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l1;
	}
	
	public Dipendenti ritornaDipendenti(int id) {
		Dipendenti nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM dipendenti WHERE matricola=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new Dipendenti(res.getInt("matricola"),res.getString("nome"),res.getString("cognome"), res.getString("codiceFiscale"));
			}else {
				nuovo= new Dipendenti(0, "Dipendente", "Non", "Trovato");
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
		return nuovo;
	}

	public void aggiornaDipendenti(Dipendenti dip) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE dipendenti SET nome=?, cognome=?, codiceFiscale=? WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setString(1, dip.getNome());
			cmd.setString(2, dip.getCognome());
			cmd.setInt(4, dip.getMatricola());
			cmd.setString(3, dip.getCodiceFiscale());
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

	public void cancellaDipendenti(Dipendenti dip) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM dipendenti WHERE matricola=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, dip.getMatricola());
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
