package br.com.base.dao.impl;

import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.base.dao.AbstractJpaRepository;
import br.com.base.dao.PermissaoDao;
import br.com.base.model.Permissao;

@Repository("permissaoDao")
public class PermissaoDaoImpl extends AbstractJpaRepository<Permissao, Integer> implements PermissaoDao {

	@Autowired
	private DataSource dataSource;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public Permissao findPermissaoByNome(String nome) {
		StringBuilder jpql = new StringBuilder();

		jpql.append(" SELECT p FROM Permissao p ");
		jpql.append(" where p.nome = :nome ");

		Query query = this.getEntityManager().createQuery(jpql.toString());

		query.setParameter("nome", nome);

		Permissao p = (Permissao) query.getSingleResult();

		return p;
	}

}
