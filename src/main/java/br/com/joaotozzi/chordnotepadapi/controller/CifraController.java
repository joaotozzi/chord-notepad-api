package br.com.joaotozzi.chordnotepadapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.joaotozzi.chordnotepadapi.dto.CifraDTO;
import br.com.joaotozzi.chordnotepadapi.form.CifraForm;
import br.com.joaotozzi.chordnotepadapi.model.Cifra;
import br.com.joaotozzi.chordnotepadapi.repository.CifraRepository;
import br.com.joaotozzi.chordnotepadapi.utils.TonalidadeUtils;

@RestController
@RequestMapping("/cifras")
public class CifraController {
	
	@Autowired
	private CifraRepository cifraRepository;
	
	@GetMapping
	public List<CifraDTO> listar(){
		List<Cifra> cifras = cifraRepository.findAll();
		return cifras.stream().map(CifraDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CifraDTO> consultar(@PathVariable Long id, @RequestParam String tom){
		Optional<Cifra> optional = cifraRepository.findById(id);
		if(optional.isPresent()) {
			
			Cifra cifra = optional.get();
			
			if(!tom.isBlank()) {
				cifra.setConteudo(TonalidadeUtils.mudarTom(cifra.getConteudo(), cifra.getTomOriginal(), tom));
			}
			
			return ResponseEntity.ok(new CifraDTO(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Void> criar(@RequestBody CifraForm cifraForm, UriComponentsBuilder uriBuilder){
		Cifra cifra = new Cifra(cifraForm);
		cifraRepository.save(cifra);
		
		URI uri = uriBuilder.path("cifras/{id}").buildAndExpand(cifra.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CifraDTO> alterar(@PathVariable Long id, @RequestBody CifraForm cifraForm, UriComponentsBuilder uriBuilder){
		Cifra cifra = new Cifra(cifraForm);
		if (cifraRepository.existsById(id)) {
			cifra.setId(id);
			cifraRepository.save(cifra);
			return ResponseEntity.ok(new CifraDTO(cifra));
		}
		
		cifraRepository.save(cifra);
		URI uri = uriBuilder.path("cifras/{id}").buildAndExpand(cifra.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Long id) {
		cifraRepository.deleteById(id);
	}
	
	
}
