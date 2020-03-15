package br.com.base.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4670100267535671015L;

	@Id
	@SequenceGenerator(name = "usuarioGenerator", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioGenerator")
	private Integer pkUsuario;

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "ativo")
	private Boolean ativo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_permissao", joinColumns = @JoinColumn(name = "fkusuario"), inverseJoinColumns = @JoinColumn(name = "fkpermissao"))
	private Set<Permissao> permissoes = new HashSet<Permissao>();

	public Usuario() {
	}

	public Usuario(Integer pkUsuario, String matricula, String cpf, String senha, String nome, String email,
			Boolean ativo) {
		super();
		this.pkUsuario = pkUsuario;
		this.matricula = matricula;
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.ativo = ativo;
	}

	public Integer getPkUsuario() {
		return pkUsuario;
	}

	public void setPkUsuario(Integer pkUsuario) {
		this.pkUsuario = pkUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkUsuario == null) ? 0 : pkUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (pkUsuario == null) {
			if (other.pkUsuario != null)
				return false;
		} else if (!pkUsuario.equals(other.pkUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [pkUsuario=" + pkUsuario + ", matricula=" + matricula + ", cpf=" + cpf + ", senha=" + senha
				+ ", nome=" + nome + ", email=" + email + ", ativo=" + ativo + ", permissoes=" + permissoes + "]";
	}

}
