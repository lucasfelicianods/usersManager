package br.com.gjl.usermanager.controle;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.gjl.usermanager.entidade.ActiveDirectory;
import br.com.gjl.usermanager.persistencia.ActiveDirectoryDao;

@Controller("AdControl")
@Scope("conversation")
public class AdControl {

	private ActiveDirectory ad = new ActiveDirectory();

	@Autowired
	private ActiveDirectoryDao adDao;

	private List<ActiveDirectory> ads = new ArrayList<ActiveDirectory>();

	private String nomeOuTarefas;

	private String telefone;

	private ActiveDirectory adSelecionado;

	public AdControl() {

		adSelecionado = ad;
	}

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		try {
			if (ad.getNome().isEmpty() && ad.getAutorizacao().isEmpty()) {
				UtilFaces.addMensagemFaces("Campo Nome e tarefas estão vazios.");
			} else {

				adDao.incluir(ad);
				listar(evt);
				ad = new ActiveDirectory();
				UtilFaces.addMensagemFaces("Informações Salvo com sucesso.");
			}

		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Por favor clique em Salvar Alterações.");
		}

	}

	public void listar(ActionEvent evt) {
		try {
			ads = adDao.listar();
			ad = new ActiveDirectory();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void pesquisar() {
		ads = adDao.consultarNomeOuTarefas(nomeOuTarefas);
	}

	public void excluir(ActiveDirectory ad) throws PersistenciaException {

		try {
			adDao.excluirPorId(ad.getId());
			ads = adDao.listar();
			UtilFaces.addMensagemFaces("Informações excluido com sucesso.");

		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e.getMessage());
		}

	}

	public void update(ActionEvent evt) {
		try {
			ad = adSelecionado;
			adDao.alterar(ad);
			listar(evt);
			ad = new ActiveDirectory();
			UtilFaces.addMensagemFaces("Informações Salvo com sucesso.");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void alterar(ActionEvent evt) {
		try {
			adDao.alterar(ad);
			listar(evt);
			ad = new ActiveDirectory();
			UtilFaces.addMensagemFaces("Informações Salvo com sucesso.");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void selecionarContatoParaEdicao(ActiveDirectory ad) {

		try {
			this.ad = adDao.consultar(ad.getId());
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificar(ActiveDirectory ad) throws PersistenciaException {
		adDao.alterar(ad);
	}

	public void selecionarContato(ActiveDirectory ad) {
		try {

			adSelecionado = ad;
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Houve um erro ao obter o ad Selecionado");
		}

	}
	
	public String process() {
	    return "activedirectory.xhtml?faces-redirect=true";
	}

	public ActiveDirectory getAd() {
		return ad;
	}

	public void setAd(ActiveDirectory ad) {
		this.ad = ad;
	}

	public ActiveDirectoryDao getAdDao() {
		return adDao;
	}

	public void setAdDao(ActiveDirectoryDao adDao) {
		this.adDao = adDao;
	}

	public List<ActiveDirectory> getAds() {
		return ads;
	}

	public void setAds(List<ActiveDirectory> ads) {
		this.ads = ads;
	}

	public String getNomeOuTarefas() {
		return nomeOuTarefas;
	}

	public void setNomeOuTarefas(String nomeOuTarefas) {
		this.nomeOuTarefas = nomeOuTarefas;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ActiveDirectory getAdSelecionado() {
		return adSelecionado;
	}

	public void setAdSelecionado(ActiveDirectory adSelecionado) {
		this.adSelecionado = adSelecionado;
	}
	
	

}
