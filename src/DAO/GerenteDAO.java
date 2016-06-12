package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import repositorio.RepositorioGerente;
import modelo.*;

public class GerenteDAO implements RepositorioGerente {
	private Connection connection;

	public GerenteDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean buscarLogin(String login, String senha){
		boolean fim = false;
		String sql = "select login,senha from gerente where login=? and senha=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Atendente atendente = new Atendente();
				atendente.setLogin(rs.getString(1));
				atendente.setSenha(rs.getString(2));
				fim = true;
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
			return false;
		}
		return fim;
	}
}
