package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioMedico;
import modelo.*;

public class MedicoDAO implements RepositorioMedico {
	private Connection connection;

	public MedicoDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean adicionarMedico(Medico medico) {
		String sql = "insert into medico(numcrm,nome,endereco,telefone,diasdeatendimento,especialidades,planosdesaude,login,senha) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, medico.getNumeroCRM());
			stmt.setString(2, medico.getNome());
			stmt.setString(3, medico.getEndereco());
			stmt.setString(4, medico.getTelefone());
			stmt.setString(5, medico.getDiasDeAtendimento());
			stmt.setString(6, medico.getEspecialidades());
			stmt.setString(7, medico.getPlanosDeSaude());
			stmt.setString(8, medico.getLogin());
			stmt.setString(9, medico.getSenha());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Médico não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Médico cadastrado!");
		return true;
	}

	public Medico buscarMedico(String numeroCRM) {
		Medico medico = null;
		String sql = "select numcrm,nome,endereco,telefone,diasdeatendimento,especialidades,planosdesaude,login,senha from medico where numcrm=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, numeroCRM);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				medico = new Medico();
				medico.setNumeroCRM(rs.getString(1));
				medico.setNome(rs.getString(2));
				medico.setEndereco(rs.getString(3));
				medico.setTelefone(rs.getString(4));
				medico.setDiasDeAtendimento(rs.getString(5));
				medico.setEspecialidades(rs.getString(6));
				medico.setPlanosDeSaude(rs.getString(7));
				medico.setLogin(rs.getString(8));
				medico.setSenha(rs.getString(9));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Médico não encontrado!");
			return null;
		}
		return medico;
	}

	public Medico buscarMedicoPorEspecialidade(String especialidade) {
		Medico medico = null;
		String sql = "select numcrm,nome,endereco,telefone,diasdeatendimento,especialidades,planosdesaude,login,senha from medico where especialidades=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, especialidade);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				medico = new Medico();
				medico.setNumeroCRM(rs.getString(1));
				medico.setNome(rs.getString(2));
				medico.setEndereco(rs.getString(3));
				medico.setTelefone(rs.getString(4));
				medico.setDiasDeAtendimento(rs.getString(5));
				medico.setEspecialidades(rs.getString(6));
				medico.setPlanosDeSaude(rs.getString(7));
				medico.setLogin(rs.getString(8));
				medico.setSenha(rs.getString(9));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Médico não encontrado!");
			return null;
		}
		return medico;
	}

	public boolean atualizarMedico(Medico medico) {
		String sql = "update medico set numcrm=?,nome=?,endereco=?,telefone=?,dias_atendimento=?,especialidade=?,planodesaude=? where num_crm=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, medico.getNumeroCRM());
			stmt.setString(2, medico.getNome());
			stmt.setString(3, medico.getEndereco());
			stmt.setString(4, medico.getTelefone());
			stmt.setString(5, medico.getDiasDeAtendimento());
			stmt.setString(6, medico.getEspecialidades());
			stmt.setString(7, medico.getPlanosDeSaude());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Médico não atualizado!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Médico atualizado!");
		return true;
	}

	public boolean removerMedico(Medico medico) {
		String sql = "delete from medico where numcrm=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, medico.getNumeroCRM());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Médico não removido!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Médico removido!");
		return true;
	}

	public List<Medico> buscarTodosMedicos() {
		List<Medico> medicos = new ArrayList<Medico>();
		String sql = "select numcrm,nome,endereco,telefone,diasatendimento,especialidade,planosaude from medico";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setNumeroCRM(rs.getString(1));
				medico.setNome(rs.getString(2));
				medico.setEndereco(rs.getString(3));
				medico.setTelefone(rs.getString(4));
				medico.setDiasDeAtendimento(rs.getString(5));
				medico.setEspecialidades(rs.getString(6));
				medico.setPlanosDeSaude(rs.getString(7));
				medicos.add(medico);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhum médico encontrado!");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Médicos encontrados!");
		return medicos;
	}

	public boolean buscarLogin(String login, String senha) {
		boolean fim = false;
		String sql = "select login,senha from medico where login=? and senha=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setLogin(rs.getString(1));
				medico.setSenha(rs.getString(2));
				fim = true;
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Login ou Senha incorretos!");
			return false;
		}
		return fim;
	}

	public String buscarDiaMedico() {
		String fim = "";
		String sql = "select diasdeatendimento from medico";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Medico medico = new Medico();
				medico.setDiasDeAtendimento(rs.getString(1));
				fim = medico.getDiasDeAtendimento();
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Dia incorreto!" + e.getMessage());
			return null;
		}
		return fim;
	}
}
