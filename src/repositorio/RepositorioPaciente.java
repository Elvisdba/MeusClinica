package repositorio;

import java.util.List;

import modelo.Paciente;

public interface RepositorioPaciente {
	public boolean adicionarPaciente(Paciente paciente);
	public Paciente buscarPaciente(String nomePaciente);
	public boolean atualizarPaciente(Paciente paciente);
	public boolean removerPaciente(Paciente paciente);
	public List<Paciente> buscarTodosPacientes();
}
