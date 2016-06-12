package modelo;

public class Consulta {
	private String cpf_paciente;
	private String crm_medico;
	private String hora;
	private String data;
	private String observacoes;

	public Consulta() {
	}

	public Consulta(String cpf_paciente, String crm_medico, String hora,
			String data, String observacoes) {
		this.cpf_paciente = cpf_paciente;
		this.crm_medico = crm_medico;
		this.hora = hora;
		this.data = data;
		this.observacoes = observacoes;
	}

	public String getCpf_paciente() {
		return cpf_paciente;
	}

	public void setCpf_paciente(String cpf_paciente) {
		this.cpf_paciente = cpf_paciente;
	}

	public String getCrm_medico() {
		return crm_medico;
	}

	public void setCrm_medico(String crm_medico) {
		this.crm_medico = crm_medico;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
