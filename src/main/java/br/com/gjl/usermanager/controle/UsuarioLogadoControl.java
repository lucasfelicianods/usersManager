package br.com.gjl.usermanager.controle;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.util.UtilLog;
import br.com.gjl.usermanager.entidade.Usuario;
import br.com.gjl.usermanager.persistencia.UsuarioDao;

@Named
@Scope("session")
public class UsuarioLogadoControl {

   private Usuario usuario;

   @Autowired
   private UsuarioDao usuarioDao;

   @PostConstruct
   public void init(){
      try {
         Principal principal = UtilFaces.getRequest().getUserPrincipal();
         if(principal != null){
            String usuarioStr = principal.getName();
            this.usuario = usuarioDao.consultar(usuarioStr);
         }
      } catch (Exception e) {
         UtilLog.getLog().error(e.getMessage(), e);
      }
   }

   public Usuario getUsuario() {
      return usuario;
   }
}
