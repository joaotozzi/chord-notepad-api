package br.com.joaotozzi.chordnotepadapi.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.joaotozzi.chordnotepadapi.form.CifraForm;

@Entity
public class Cifra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String compositor;
	private String tomOriginal;
	private String conteudo;
	private LocalDateTime ultimaModificacao;
	
	public Cifra() {}
	
	public Cifra(CifraForm cifraForm) {
		this.titulo = cifraForm.getTitulo();
		this.compositor = cifraForm.getCompositor();
		this.tomOriginal = cifraForm.getTomOriginal();
		this.conteudo = cifraForm.getConteudo();
		this.ultimaModificacao =  LocalDateTime.now();
	}
	
	
	
	public LocalDateTime getUltimaModificacao() {
		return ultimaModificacao;
	}

	public void setUltimaModificacao(LocalDateTime ultimaModificacao) {
		this.ultimaModificacao = ultimaModificacao;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCompositor() {
		return compositor;
	}
	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}
	public String getTomOriginal() {
		return tomOriginal;
	}
	public void setTomOriginal(String tomOriginal) {
		this.tomOriginal = tomOriginal;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
}
