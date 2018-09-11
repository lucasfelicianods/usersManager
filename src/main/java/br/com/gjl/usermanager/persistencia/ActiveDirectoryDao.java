package br.com.gjl.usermanager.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.gjl.usermanager.entidade.ActiveDirectory;

public interface ActiveDirectoryDao extends Persistencia<ActiveDirectory> {
	
	 List<ActiveDirectory> consultarNomeOuTarefas(String nomeOuTarefas);
	 public void update(ActiveDirectory ad);

}
