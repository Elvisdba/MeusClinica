package repositorio;

import modelo.ConsultaParticular;

public interface RepositorioConsultaParticular {
	public boolean adicionarConsultaParticular(ConsultaParticular consulta);
	public boolean buscarDataHora(String data, String hora);
}
