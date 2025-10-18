package org.serratec.serratec_music.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.serratec_music.domain.entity.PlayList;
import org.serratec.serratec_music.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

	@Autowired
	private PlayListRepository playlistRepository;

	@GetMapping
	public List<PlayList> listarPlaylists() {
		return playlistRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<PlayList> buscarPorId(@PathVariable Long id) {
		Optional<PlayList> playlist = playlistRepository.findById(id);

		if (playlist.isPresent()) {
			return ResponseEntity.ok(playlist.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus
	public PlayList inserir(@Valid @RequestBody PlayList playList) {
		return playlistRepository.save(playList);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlayList> atualizar(@Valid @RequestBody PlayList playList, @PathVariable Long id) {
		if (!playlistRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		playList.setId(id);
		playList = playlistRepository.save(playList);
		return ResponseEntity.ok(playList);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		if (!playlistRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		playlistRepository.deleteById(id);
		return ResponseEntity.notFound().build();
	}
}
