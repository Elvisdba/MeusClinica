package repositorio;

import modelo.ConsultaPorPlano;

public interface RepositorioConsultaPorPlano {
	public boolean adicionarConsultaPorPlano(ConsultaPorPlano consulta);
	public boolean buscarDataHora(String data, String hora);
}
