package repositorio;

import java.util.List;

import modelo.Especialidade;

public interface RepositorioEspecialidades {
	public boolean adicionarEspecialidade(Especialidade especialidade);
	public Especialidade buscarEspecialidade(String nomeEspecialidade);
	public boolean atualizarESpecialidade(Especialidade especialidade);
	public boolean removerEspecialidade(Especialidade especialidade);
	public List<Especialidade> buscarTodosEspecialidades();
}
