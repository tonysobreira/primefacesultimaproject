package br.com.base.facade;

import java.util.List;

import br.com.base.model.Permissao;
import br.com.base.model.Usuario;

public interface Facade {

	/******************** USUÁRIO ***********************/

	public Usuario salvarUsuario(Usuario usuario);

	public List<Usuario> findAllUsuario();

	public Usuario findUsuarioByPk(Integer pk);

	public Usuario getUsuarioLogado();

	/******************** FIM USUÁRIO ***********************/

	/******************** PERMISSÃO ***********************/

	public Permissao findPermissaoByNome(String nome);

	/******************** FIM PERMISSÃO ***********************/

}
