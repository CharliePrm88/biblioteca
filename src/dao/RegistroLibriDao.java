package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.RegistroLibri;

public class RegistroLibriDao {

	public void inserisciregendente(RegistroLibri tur) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "INSERT INTO registrolibri(idlibro, matricola,idcliente,data_prestito, data_scadenza,data_rientro) VALUES(?,?,?,?,?,?)";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, tur.getIdlibro());
			cmd.setInt(2, tur.getMatricola());
			cmd.setInt(3, tur.getIdcliente());
			cmd.setDate(4, tur.getData_prestito());
			cmd.setDate(5, tur.getData_scadenza());
			cmd.setDate(6, tur.getData_rientro());
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<RegistroLibri> ritornaListaRegistroLibri() {
		List<RegistroLibri> l1 = new ArrayList<>();
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM registrolibri";
			cmd = dbConnection.prepareStatement(query);
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			while(esci) {
				RegistroLibri nuovo = new RegistroLibri(res.getInt("id"),res.getInt("idLibro"),res.getInt("idCliente"),res.getInt("matricola"),res.getDate("data_prestito"),res.getDate("data_scadenza"),res.getDate("data_rientro"));
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
	
	public RegistroLibri ritornaRegistroLibri(int id) {
		RegistroLibri nuovo = null;
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String query = "SELECT * FROM registrolibri WHERE id=?";
			cmd = dbConnection.prepareStatement(query);
			cmd.setInt(1, id);
			ResultSet res = cmd.executeQuery();
			System.out.println("Record retrieved!");
			boolean esci = res.next();
			if(esci) {
				nuovo = new RegistroLibri(res.getInt("id"),res.getInt("idLibro"),res.getInt("idCliente"),res.getInt("matricola"),res.getDate("data_prestito"),res.getDate("data_scadenza"),res.getDate("data_rientro"));
			}else {
				nuovo = new RegistroLibri(0,0,0,0,null,null,null);
			}
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nuovo;
	}

	public void aggiornaRegistroLibri(RegistroLibri reg) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "UPDATE registrolibri SET idlibro=?, idcliente=?, matricola=?,data_prestito=?, data_scadenza=?,data_rientro=? where id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(7, reg.getId());
			cmd.setInt(1, reg.getIdlibro());
			cmd.setInt(2, reg.getIdcliente());
			cmd.setInt(3, reg.getMatricola());
			cmd.setDate(4, reg.getData_prestito());
			cmd.setDate(5, reg.getData_scadenza());
			cmd.setDate(6, reg.getData_rientro());
			cmd.executeUpdate();
			cmd.close();
			dbConnection.close();
			System.out.println("Record is updated to DBUSER table!");
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cancellaRegistroLibri(RegistroLibri reg) {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:/biblioteca");
			Connection dbConnection = ds.getConnection();
			java.sql.PreparedStatement cmd = null;
			String updateTableSQL = "DELETE FROM registrolibri WHERE id=?";
			cmd = dbConnection.prepareStatement(updateTableSQL);
			cmd.setInt(1, reg.getId());
			// execute update SQL statement
			cmd.executeUpdate();
			System.out.println("Record is updated to DBUSER table!");
			cmd.close();
			dbConnection.close();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}