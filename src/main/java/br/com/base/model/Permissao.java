package br.com.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

	private static final long serialVersionUID = 1168839742884154062L;

	@Id
	@SequenceGenerator(name = "permissaoGenerator", sequenceName = "seq_permissao", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permissaoGenerator")
	private Integer pkPermissao;

	@Column(name = "nome")
	private String nome;

	@ManyToMany(mappedBy = "permissoes", fetch = FetchType.EAGER)
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public Permissao() {
	}

	public Permissao(Integer pkPermissao, String nome) {
		super();
		this.pkPermissao = pkPermissao;
		this.nome = nome;
	}

	public Integer getPkPermissao() {
		return pkPermissao;
	}

	public void setPkPermissao(Integer pkPermissao) {
		this.pkPermissao = pkPermissao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkPermissao == null) ? 0 : pkPermissao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		if (pkPermissao == null) {
			if (other.pkPermissao != null)
				return false;
		} else if (!pkPermissao.equals(other.pkPermissao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Permissao [pkPermissao=" + pkPermissao + ", nome=" + nome + ", usuarios=" + usuarios + "]";
	}

}
