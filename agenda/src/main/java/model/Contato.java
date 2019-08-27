package model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Contato")
public class Contato {
    @Column
    @Id
    @NotBlank
    private Long id;

    @Column
    @NotBlank
    private String nome;

    @Column
    @NotBlank
    private String telefone;

    public Contato(long id, String nome, String telefone) {
    	this.id=id;
    	this.nome=nome;
    	this.telefone=telefone;
    }
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@ManyToOne
	private Usuario usuario;
	
}