package model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Column
    @Id
    @NotBlank
    private Long id;

    @Column
    @NotBlank
    private String login;

    @Column
    @NotBlank
    private String senha;
    
    public Usuario(long id, String login, String senha) {
    	this.id=id;
    	this.login=login;
    	this.senha=senha;
    }

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@OneToMany
	private List<Contato> contatos;
}