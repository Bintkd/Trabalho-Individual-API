package org.serratec.serratec_music.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.serratec_music.domain.entity.Musica;
import org.serratec.serratec_music.repository.MusicaRepository;
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
@RequestMapping("/musica")
public class MusicaController {

	@Autowired
	private MusicaRepository musicaRepository;

	@GetMapping
	public List<Musica> LIsta() {
		return musicaRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Musica> buscarPorId(@PathVariable Long id) {
		Optional<Musica> musica = musicaRepository.findById(id);

		if (musica.isPresent()) {
			return ResponseEntity.ok(musica.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus
	public Musica inserir(@Valid @RequestBody Musica musica) {
		return musicaRepository.save(musica);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Musica> atualizar(@Valid @RequestBody Musica musica, @PathVariable Long id) {
		if (!musicaRepository.existsById(id))
			;
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!musicaRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		musicaRepository.deleteById(id);
		return ResponseEntity.notFound().build();
	}

}
