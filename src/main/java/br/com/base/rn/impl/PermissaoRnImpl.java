package br.com.base.rn.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.base.dao.PermissaoDao;
import br.com.base.model.Permissao;
import br.com.base.rn.PermissaoRn;

@Service("permissaoRn")
public class PermissaoRnImpl implements PermissaoRn, Serializable {

	private static final long serialVersionUID = 4299004118619671912L;

	@Autowired
	private PermissaoDao permissaoDao;

	@Override
	@Transactional
	public Permissao findPermissaoByNome(String nome) {
		return permissaoDao.findPermissaoByNome(nome);
	}

}
