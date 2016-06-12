package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioPlanoDeSaude;
import modelo.*;

public class PlanoDeSaudeDAO implements RepositorioPlanoDeSaude{
	private Connection connection;

	public PlanoDeSaudeDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean adicionarPLano(PlanoDeSaude plano) {
		String sql = "insert into plano_de_saude(razaosocial,cnpj,endereco,telefone) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getRazaoSocial());
			stmt.setString(2, plano.getCNPJ());
			stmt.setString(3, plano.getEndereco());
			stmt.setString(4, plano.getTelefone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Plano não cadastrado!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Plano cadastrado!");
		return true;
	}

	public PlanoDeSaude buscarPlano(String nomePlano) {
		PlanoDeSaude plano = null;
		String sql = "select razaosocial,cnpj,endereco,telefone from plano_de_saude where cnpj=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, nomePlano);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				plano = new PlanoDeSaude();
				plano.setRazaoSocial(rs.getString(1));
				plano.setCNPJ(rs.getString(2));
				plano.setEndereco(rs.getString(3));
				plano.setTelefone(rs.getString(4));
				
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Plano não encontrado!");
			return null;
		}
		return plano;
	}

	public boolean atualizarPlano(PlanoDeSaude plano) {
		String sql = "update contato set razao=?,cnpj=?,endereco=?,telefone=? where razao=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getRazaoSocial());
			stmt.setString(2, plano.getCNPJ());
			stmt.setString(3, plano.getEndereco());
			stmt.setString(4, plano.getTelefone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Plano não atualizado!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Plano atualizado!");
		return true;
	}

	public boolean removerPlano(PlanoDeSaude plano) {
		String sql = "delete from plano_de_saude where cnpj=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getCNPJ());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Plano não removido!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Plano removido!");
		return true;
	}

	public List<PlanoDeSaude> buscarTodosPlanos() {
		List<PlanoDeSaude> planos = new ArrayList<PlanoDeSaude>();
		String sql = "select nome,cnpj,endereco,telefone from contato";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PlanoDeSaude plano = new PlanoDeSaude();
				plano.setRazaoSocial(rs.getString(1));
				plano.setCNPJ(rs.getString(2));
				plano.setEndereco(rs.getString(3));
				plano.setTelefone(rs.getString(4));
				planos.add(plano);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado!");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Pacientes encontrados!");
		return planos;
	}
}