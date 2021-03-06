package br.com.base.dao;

import java.util.List;

import br.com.base.model.Usuario;

public interface UsuarioDao {

	public Usuario salvarUsuario(Usuario usuario);

	public List<Usuario> findAllUsuario();

	public Usuario findUsuarioByPk(Integer pk);

	public Usuario getUsuarioLogado() throws Exception;

}
