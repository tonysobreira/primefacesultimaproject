package br.com.base.rn;

import java.util.List;

import br.com.base.model.Usuario;

public interface UsuarioRn {
	
	public Usuario salvarUsuario(Usuario usuario);
	
	public List<Usuario> findAllUsuario();
	
	public Usuario findUsuarioByPk(Integer pk);
	
	public Usuario getUsuarioLogado();

}
