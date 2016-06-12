package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioPaciente;
import modelo.*;

public class PacienteDAO implements RepositorioPaciente {
	private Connection connection;

	public PacienteDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean adicionarPaciente(Paciente paciente) {
		String sql = "insert into paciente(nome,cpf,endereco,telefone) values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEndereço());
			stmt.setString(4, paciente.getTelefone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Paciente não cadastrado!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Paciente cadastrado!");
		return true;
	}

	public Paciente buscarPaciente(String CPFpaciente) {
		Paciente paciente = null;
		String sql = "select nome,cpf,endereco,telefone from paciente where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, CPFpaciente);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				paciente = new Paciente();
				paciente.setNome(rs.getString(1));
				paciente.setCpf(rs.getString(2));
				paciente.setEndereço(rs.getString(3));
				paciente.setTelefone(rs.getString(4));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Paciente não encontrado!");
			return null;
		}
		return paciente;
	}

	public boolean atualizarPaciente(Paciente paciente) {
		String sql = "update contato set nome=?,cpf=?,endereco=?,telefone=? where nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEndereço());
			stmt.setString(4, paciente.getTelefone());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Paciente não atualizado!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Paciente atualizado!");
		return true;
	}

	public boolean removerPaciente(Paciente cpf) {
		String sql = "delete from paciente where cpf=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cpf.getCpf());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Paciente não removido, verifique se ele está em alguma Consulta!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Paciente removido!");
		return true;
	}

	public List<Paciente> buscarTodosPacientes() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		String sql = "select nome,cpf,email,telefone from contato";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setNome(rs.getString(1));
				paciente.setCpf(rs.getString(2));
				paciente.setEndereço(rs.getString(3));
				paciente.setTelefone(rs.getString(4));
				pacientes.add(paciente);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhum paciente encontrado!");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Pacientes encontrados!");
		return pacientes;
	}
}