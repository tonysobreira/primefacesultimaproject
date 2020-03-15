package br.com.base.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import br.com.base.model.Usuario;
import br.com.base.util.CryptoUtil;
import br.com.base.util.Util;

@ManagedBean
@SessionScoped
public class CadastroBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = 925736215818479352L;

	private String cpf;
	private String nome;
	private String email;
	private String senha;

	public void cadastrarUsuario() {
		Usuario usuario = new Usuario();

		usuario.setCpf(this.cpf);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);

		usuario.setMatricula(usuario.getCpf());

		try {
			usuario.setSenha(CryptoUtil.encryptAES(this.senha));
		} catch (Exception e) {
			e.printStackTrace();
		}

		usuario.setAtivo(Boolean.TRUE);

		Usuario u = getFacade().salvarUsuario(usuario);

		if (!Util.isEmptyOrNull(u)) {
			addMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Usuário " + u.getNome() + " cadastrado com sucesso!");
		}

	}

	public void finalizar() {
		redirectToPage("../publico/login.xhtml");
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
