package br.com.base.dao;

import br.com.base.model.Permissao;

public interface PermissaoDao {

	public Permissao findPermissaoByNome(String nome);

}
