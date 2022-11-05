package br.com.joaotozzi.chordnotepadapi.dto;

import br.com.joaotozzi.chordnotepadapi.model.Cifra;

public class CifraDTO {
	private Long id;
	private String titulo;
	private String compositor;
	private String tomOriginal;
	private String conteudo;
	
	public CifraDTO(Cifra cifra) {
		this.id = cifra.getId();
		this.titulo = cifra.getTitulo();
		this.compositor = cifra.getCompositor();
		this.tomOriginal = cifra.getTomOriginal();
		this.conteudo = cifra.getConteudo();
	}

	public Long getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCompositor() {
		return compositor;
	}
	public String getTomOriginal() {
		return tomOriginal;
	}
	public String getConteudo() {
		return conteudo;
	}
	
	
	
}
