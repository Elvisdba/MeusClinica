package modelo;

public class Medico extends Usuario {
	private String nome;
	private String numeroCRM;
	private String endereco;
	private String telefone;
	private String diasDeAtendimento;
	private String especialidades;
	private String planosDeSaude;
	
	public Medico(){}
	
	public Medico(String nome, String numeroCRM, String endereco,
			String telefone, String diasDeAtendimento, String especialidades,
			String planosDeSaude) {
		this.nome = nome;
		this.numeroCRM = numeroCRM;
		this.endereco = endereco;
		this.telefone = telefone;
		this.diasDeAtendimento = diasDeAtendimento;
		this.especialidades = especialidades;
		this.planosDeSaude = planosDeSaude;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroCRM() {
		return numeroCRM;
	}

	public void setNumeroCRM(String numeroCRM) {
		this.numeroCRM = numeroCRM;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiasDeAtendimento() {
		return diasDeAtendimento;
	}

	public void setDiasDeAtendimento(String diasDeAtendimento) {
		this.diasDeAtendimento = diasDeAtendimento;
	}

	public String getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(String especialidades) {
		this.especialidades = especialidades;
	}

	public String getPlanosDeSaude() {
		return planosDeSaude;
	}

	public void setPlanosDeSaude(String planosDeSaude) {
		this.planosDeSaude = planosDeSaude;
	}
}
