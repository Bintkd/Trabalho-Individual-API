package org.serratec.serratec_music.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.serratec_music.domain.entity.Artista;
import org.serratec.serratec_music.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	@Autowired
	private ArtistaRepository artistaRepository;

	@GetMapping
	public List<Artista> listar() {
		return artistaRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Artista> buscarPorId(@PathVariable Long id) {
		Optional<Artista> artista = artistaRepository.findById(id);
		if (artista.isPresent()) {
			return ResponseEntity.ok(artista.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus
	public Artista inserir(@Valid @RequestBody Artista artista) {
		return artistaRepository.save(artista);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Artista> atualizar(@Valid @RequestBody Artista artista, @PathVariable Long id) {
		if (!artistaRepository.existsById(id))
			;
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!artistaRepository.existsById(id))
			;
		{
			return ResponseEntity.notFound().build();
		}
	}
}
