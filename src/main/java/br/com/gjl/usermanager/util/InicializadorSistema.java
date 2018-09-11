package br.com.gjl.usermanager.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ambientinformatica.util.UtilLog;
import br.com.gjl.usermanager.entidade.EnumPapelUsuario;
import br.com.gjl.usermanager.entidade.Usuario;
import br.com.gjl.usermanager.persistencia.UsuarioDao;

@Service("inicializadorSistema")
public class InicializadorSistema {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@PostConstruct
	public void iniciar(){
		inicializarUsuarioAdmin();
	}
	
	private void inicializarUsuarioAdmin(){
		try {
			List<Usuario> usuarios = usuarioDao.listar();
			if(usuarios.isEmpty()){
				Usuario usu = new Usuario();
				usu.setNome("admin");
				usu.setLogin("admin");
				usu.setSenhaNaoCriptografada("123456");
				usu.addPapel(EnumPapelUsuario.ADMIN);
				usu.addPapel(EnumPapelUsuario.USUARIO);
				usuarioDao.incluir(usu);
				UtilLog.getLog().info("*** USU�?RIO admin CRIADO com a senha 123456 ***");
			}
		} catch (Exception e) {
			UtilLog.getLog().error(e.getMessage(), e);
		}
	}
	
}
