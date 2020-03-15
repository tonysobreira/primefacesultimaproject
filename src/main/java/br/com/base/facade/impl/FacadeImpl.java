package br.com.base.facade.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.base.constants.RolesConstantes;
import br.com.base.facade.Facade;
import br.com.base.model.Permissao;
import br.com.base.model.Usuario;
import br.com.base.rn.PermissaoRn;
import br.com.base.rn.UsuarioRn;

@Service("facade")
public class FacadeImpl implements Facade {

	private UsuarioRn usuarioRn;
	private PermissaoRn permissaoRn;

	@Autowired
	public FacadeImpl(@Qualifier("usuarioRn") final UsuarioRn usuarioRn,
			@Qualifier("permissaoRn") final PermissaoRn permissaoRn) {
		this.usuarioRn = usuarioRn;
		this.permissaoRn = permissaoRn;
	}

	/******************** USUÁRIO ***********************/

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario salvarUsuario(Usuario usuario) {
		Set<Permissao> permissoes = new HashSet<Permissao>();
		
		Permissao permissao = findPermissaoByNome(RolesConstantes.ROLE_ADMIN);
		permissoes.add(permissao);
		permissao = findPermissaoByNome(RolesConstantes.ROLE_USUARIO);
		permissoes.add(permissao);
		
		usuario.setPermissoes(permissoes);

		return this.usuarioRn.salvarUsuario(usuario);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<Usuario> findAllUsuario() {
		return this.usuarioRn.findAllUsuario();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario findUsuarioByPk(Integer pk) {
		return this.usuarioRn.findUsuarioByPk(pk);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Usuario getUsuarioLogado() {
		return this.usuarioRn.getUsuarioLogado();
	}

	/******************** FIM USUÁRIO ***********************/

	/******************** PERMISSÃO ***********************/

	@Override
	public Permissao findPermissaoByNome(String nome) {
		return permissaoRn.findPermissaoByNome(nome);
	}

	/******************** FIM PERMISSÃO ***********************/

}
