package repositorio;

import java.util.List;

import modelo.PlanoDeSaude;

public interface RepositorioPlanoDeSaude {
	public boolean adicionarPLano(PlanoDeSaude plano);
	public PlanoDeSaude buscarPlano(String nomePlano);
	public boolean atualizarPlano(PlanoDeSaude plano);
	public boolean removerPlano(PlanoDeSaude plano);
	public List<PlanoDeSaude> buscarTodosPlanos();
}
