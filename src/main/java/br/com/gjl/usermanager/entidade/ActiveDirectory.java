package br.com.gjl.usermanager.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ambientinformatica.util.Entidade;

@Entity
public class ActiveDirectory extends Entidade{
	
 @Id
 @GeneratedValue
 @Column(name="ID_AD")
 private int id;
 private String loja;
 private String area;
 private String departamento;
 private String nome;
 private String login;
 private String autorizacao;
 private String situação;
 
 @Temporal(TemporalType.DATE)
 private Date dataCricação = new Date();
 @Temporal(TemporalType.DATE)
 private Date dataAlteração = new Date();
 private String tarefasAlteração;
 private String obs;
 
 
 

@Override
public Object getId() {
	// TODO Auto-generated method stub
	return null;
}



public String getAutorizacao() {
	return autorizacao;
}



public void setAutorizacao(String autorizacao) {
	this.autorizacao = autorizacao;
}



public String getLoja() {
	return loja;
}

public void setLoja(String loja) {
	this.loja = loja;
}


public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getDepartamento() {
	return departamento;
}

public void setDepartamento(String departamento) {
	this.departamento = departamento;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getLogin() {
	return login;
}

public void setLogin(String login) {
	this.login = login;
}

public String getSituação() {
	return situação;
}

public void setSituação(String situação) {
	this.situação = situação;
}
public Date getDataCricação() {
	return dataCricação;
}

public void setDataCricação(Date dataCricação) {
	this.dataCricação = dataCricação;
}

public Date getDataAlteração() {
	return dataAlteração;
}

public void setDataAlteração(Date dataAlteração) {
	this.dataAlteração = dataAlteração;
}

public String getTarefasAlteração() {
	return tarefasAlteração;
}

public void setTarefasAlteração(String tarefasAlteração) {
	this.tarefasAlteração = tarefasAlteração;
}
public String getObs() {
	return obs;
}
public void setObs(String obs) {
	this.obs = obs;
}

public void setId(int id) {
	this.id = id;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((area == null) ? 0 : area.hashCode());
	result = prime * result + ((autorizacao == null) ? 0 : autorizacao.hashCode());
	result = prime * result + ((dataAlteração == null) ? 0 : dataAlteração.hashCode());
	result = prime * result + ((dataCricação == null) ? 0 : dataCricação.hashCode());
	result = prime * result + ((departamento == null) ? 0 : departamento.hashCode());
	result = prime * result + id;
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((loja == null) ? 0 : loja.hashCode());
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((obs == null) ? 0 : obs.hashCode());
	result = prime * result + ((situação == null) ? 0 : situação.hashCode());
	result = prime * result + ((tarefasAlteração == null) ? 0 : tarefasAlteração.hashCode());
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	ActiveDirectory other = (ActiveDirectory) obj;
	if (area == null) {
		if (other.area != null)
			return false;
	} else if (!area.equals(other.area))
		return false;
	if (autorizacao == null) {
		if (other.autorizacao != null)
			return false;
	} else if (!autorizacao.equals(other.autorizacao))
		return false;
	if (dataAlteração == null) {
		if (other.dataAlteração != null)
			return false;
	} else if (!dataAlteração.equals(other.dataAlteração))
		return false;
	if (dataCricação == null) {
		if (other.dataCricação != null)
			return false;
	} else if (!dataCricação.equals(other.dataCricação))
		return false;
	if (departamento == null) {
		if (other.departamento != null)
			return false;
	} else if (!departamento.equals(other.departamento))
		return false;
	if (id != other.id)
		return false;
	if (login == null) {
		if (other.login != null)
			return false;
	} else if (!login.equals(other.login))
		return false;
	if (loja == null) {
		if (other.loja != null)
			return false;
	} else if (!loja.equals(other.loja))
		return false;
	if (nome == null) {
		if (other.nome != null)
			return false;
	} else if (!nome.equals(other.nome))
		return false;
	if (obs == null) {
		if (other.obs != null)
			return false;
	} else if (!obs.equals(other.obs))
		return false;
	if (situação == null) {
		if (other.situação != null)
			return false;
	} else if (!situação.equals(other.situação))
		return false;
	if (tarefasAlteração == null) {
		if (other.tarefasAlteração != null)
			return false;
	} else if (!tarefasAlteração.equals(other.tarefasAlteração))
		return false;
	return true;
}


@Override
public String toString() {
	return "ActiveDirectory [id=" + id + ", loja=" + loja + ", area=" + area + ", departamento=" + departamento
			+ ", nome=" + nome + ", login=" + login + ", autorizaçao=" + autorizacao + ", situação=" + situação
			+ ", dataCricação=" + dataCricação + ", dataaAlteração=" + dataAlteração + ", tarefasAlteração="
			+ tarefasAlteração + ", obs=" + obs + "]";
}



   
   
}
