package repositorio;

import java.util.List;

import modelo.Medico;

public interface RepositorioMedico {
	public boolean adicionarMedico(Medico medico);
	public Medico buscarMedico(String nomeMedico);
	public Medico buscarMedicoPorEspecialidade(String especialidade);
	public boolean atualizarMedico(Medico medico);
	public boolean removerMedico(Medico medico);
	public List<Medico> buscarTodosMedicos();
	public boolean buscarLogin(String login, String senha);
	public String buscarDiaMedico();
}
