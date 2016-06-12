package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import repositorio.RepositorioGerais;
import modelo.*;

public class ConsultaGeraisDAO implements RepositorioGerais {
	private Connection connection;

	public ConsultaGeraisDAO() {
		this.connection = new Conexao().getConnection();
	}

	public String buscarObservacoes(String hora) {
		String plano = "";
		String sql = "select observacoes from consulta where hora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, hora);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				plano = rs.getString("observacoes");
			} 
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Consulta não encontrada!" + e.getMessage());
		}
		return plano;
	}
	
	public Consulta buscarDataHora(String dataa, String hora) {
		Consulta consul = null;
		String sql = "select dataa,hora from consulta where dataa=? and hora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, dataa);
			stmt.setString(2, hora);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				consul = new Consulta();
				consul.setCrm_medico(rs.getString("crm_medico"));
			} 
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Data e Hora não encontrados!" + e.getMessage());
		}
		return consul;
	}

	public boolean atualizarObservacoes(Consulta plano, String hora) {
		String sql = "update consulta set observacoes=? where hora=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, plano.getObservacoes());
			stmt.setString(2, hora);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Observações não atualizadas!" + e.getMessage());
			return false;
		}
		JOptionPane.showMessageDialog(null, "Observações atualizadas!");
		return true;
	}
	
	public List<Consulta> buscarTodosConsultas() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		String sql = "select crm_medico,cpf_paciente,hora,dataa,consulta_plano from consulta";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setCrm_medico(rs.getString(1));
				consulta.setCpf_paciente(rs.getString(2));
				consulta.setHora(rs.getString(3));
				consulta.setData(rs.getString(4));
				consultas.add(consulta);
			}
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nenhuma consulta encontrada!");
			return null;
		}
//		JOptionPane.showMessageDialog(null, "Consultas encontradas!");
		return consultas;
	}
}