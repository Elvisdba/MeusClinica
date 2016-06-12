package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioEspecialidades;
import modelo.*;

public class EspecialidadesDAO  implements RepositorioEspecialidades {
	private Connection connection;

	public EspecialidadesDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean adicionarEspecialidade(Especialidade especialidade) {
		String sql = "insert into especialidade(nome,codigo) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, especialidade.getNome());
			stmt.setString(2, especialidade.getCodigoID());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Especialidade não cadastrada!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Especialidade cadastrada!");
		return true;
	}

	public Especialidade buscarEspecialidade(String nomeEspecialidade) {
		Especialidade especialidade = null;
		String sql = "select nome,codigo from especialidade where nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, nomeEspecialidade);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				especialidade = new Especialidade();
				especialidade.setNome(rs.getString(1));
				especialidade.setCodigoID(rs.getString(2));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Especialidade não encontrada!");
			return null;
		}
		return especialidade;
	}

	public boolean atualizarESpecialidade(Especialidade especialidade) {
		String sql = "update contato set nome=?,codigo=? where nome=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, especialidade.getNome());
			stmt.setString(2, especialidade.getCodigoID());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Especialidade não atualizada!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Especialidade atualizada!");
		return true;
	}

	public boolean removerEspecialidade(Especialidade especialidade) {
		String sql = "delete from contato where codigo=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, especialidade.getNome());
			stmt.setString(2, especialidade.getCodigoID());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Especialidade não removida!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Especialidade removida!");
		return true;
	}

	public List<Especialidade> buscarTodosEspecialidades() {
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		String sql = "select nome,codigo from contato";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Especialidade especialidade = new Especialidade();
				especialidade.setNome(rs.getString(1));
				especialidade.setCodigoID(rs.getString(2));
				especialidades.add(especialidade);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhuma especialidade encontrada!");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Especialidades encontradas!");
		return especialidades;
	}
}