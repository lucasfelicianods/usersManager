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
public class Citrix extends Entidade{
	
 @Id
 @GeneratedValue
 @Column(name="ID_CITRIX")
 private int id;
 private String loja;
 private String area;
 private String departamento;
 private String nome;
 private String ferramentas;
 private String office;
 private String proprios;
 private String sefaz;
 private String terceiro;
 private String situacao;
 private String tarefasCriacao;
 
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
 
 
 

   
   
}
