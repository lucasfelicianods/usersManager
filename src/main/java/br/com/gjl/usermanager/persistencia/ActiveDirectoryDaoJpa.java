package br.com.gjl.usermanager.persistencia;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.gjl.usermanager.entidade.ActiveDirectory;

@Repository("activeDirectoryDao")
public class ActiveDirectoryDaoJpa extends PersistenciaJpa<ActiveDirectory> implements ActiveDirectoryDao {

	private static final long serialVersionUID = 1L;

	@Override
	@SuppressWarnings("unchecked")
	public List<ActiveDirectory> consultarNomeOuTarefas(String nomeOuTarefas) {

		Query query = em.createQuery(
				"select c from ActiveDirectory c where UPPER(c.nome) LIKE :nome OR UPPER(c.tarefas) LIKE :tarefas");
		query.setParameter("nome", nomeOuTarefas.toUpperCase() + "%");
		query.setParameter("tarefas", nomeOuTarefas.toUpperCase() + "%");
		return query.getResultList();
	}

	@Override
	public void update(ActiveDirectory ad) {
		em.merge(ad);

	}

}
