package repositorio;

import java.util.List;
import modelo.Consulta;

public interface RepositorioGerais {
	public String buscarObservacoes(String hora);
	public boolean atualizarObservacoes(Consulta plano, String hora);
	public List<Consulta> buscarTodosConsultas();
	public Consulta buscarDataHora(String dataa, String hora);
}
