package br.com.joaotozzi.chordnotepadapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaotozzi.chordnotepadapi.model.Cifra;

public interface CifraRepository extends JpaRepository<Cifra, Long> {
	public List<Cifra> findAllByOrderByUltimaModificacaoDesc();		
}