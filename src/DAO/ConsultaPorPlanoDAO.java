package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioConsultaPorPlano;
import modelo.*;

public class ConsultaPorPlanoDAO implements RepositorioConsultaPorPlano {
	private Connection connection;

	public ConsultaPorPlanoDAO() {
		this.connection = new Conexao().getConnection();
	}

	public boolean adicionarConsultaPorPlano(ConsultaPorPlano consulta) {
		String sql = "insert into consulta(crm_medico,cpf_paciente,hora,dataa,consulta_plano) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, consulta.getCrm_medico());
			stmt.setString(2, consulta.getCpf_paciente());
			stmt.setString(3, consulta.getHora());
			stmt.setString(4, consulta.getData());
			stmt.setString(5, consulta.getNomePlano());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Consulta não cadastrada!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Consulta cadastrada com Sucesso!");
		return true;
	}

	public ConsultaPorPlano buscarConsultaPorPlano(String cnpjPlano) {
		ConsultaPorPlano plano = null;
		String sql = "select cnpj from consulta where cnpj=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, cnpjPlano);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				plano = new ConsultaPorPlano();
				plano.setCrm_medico(rs.getString(1));
				plano.setCpf_paciente(rs.getString(2));
				plano.setHora(rs.getString(3));
				plano.setData(rs.getString(4));
				plano.setNomePlano(rs.getString(5));
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Consulta não encontrada!");
			return null;
		}
		return plano;
	}

	public boolean atualizarConsultaPorPlano(ConsultaPorPlano plano,
			String cnpjPlano) {
		String sql = "update consulta set crm_medico=?,cpf_paciente=?,hora=?,dataa=?,consulta_plano=? where cpf_paciente=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getCrm_medico());
			stmt.setString(2, plano.getCpf_paciente());
			stmt.setString(3, plano.getHora());
			stmt.setString(4, plano.getData());
			stmt.setString(5, plano.getNomePlano());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Consulta não atualizada!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Consulta atualizada!");
		return true;
	}

	public boolean removerConsultaPorPlano(ConsultaPorPlano plano) {
		String sql = "delete from consulta where cpf_paciente=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getCpf_paciente());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Consulta não removida!");
			return false;
		}
		JOptionPane.showMessageDialog(null, "Consulta removida!");
		return true;
	}

	public List<ConsultaPorPlano> buscarTodosConsultasPorPlanos() {
		List<ConsultaPorPlano> planos = new ArrayList<ConsultaPorPlano>();
		String sql = "select crm_medico,cpf_paciente,hora,dataa,consulta_plano from consulta";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ConsultaPorPlano plano = new ConsultaPorPlano();
				plano.setCrm_medico(rs.getString(1));
				plano.setCpf_paciente(rs.getString(2));
				plano.setHora(rs.getString(3));
				plano.setData(rs.getString(4));
				plano.setNomePlano(rs.getString(5));
				planos.add(plano);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada!");
			return null;
		}
		JOptionPane.showMessageDialog(null, "Consultas encontradas!");
		return planos;
	}

	public boolean buscarDataHora(String dataa, String hora) {
		boolean fim = false;
		String sql = "select dataa,hora from consulta where dataa=? and hora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, dataa);
			stmt.setString(2, hora);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setData(rs.getString(1));
				consulta.setHora(rs.getString(2));
				fim = true;
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Data ou Hora incorreta!" + e.getMessage());
			return false;
		}
		return fim;
	}
}