package org.serratec.serratec_music.domain.entity;

import java.util.List;

import org.serratec.serratec_music.Enum.GeneroMusical;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "musica")
public class Musica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O titulo da musica é obrigatorio")
	private String titulo;

	@NotNull(message = "A duração (em minutos) é obrigatorio")
	@Positive(message = "A duração deve ser um valor positivo")
	private Integer minutos;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O genero musical é obrigatorio")
	private GeneroMusical generoMusical;

	@ManyToMany
	@JoinTable(name = "musica_artista ",
	joinColumns = @JoinColumn(name = "musica_id"),
	inverseJoinColumns = @JoinColumn(name = "artista_id"))
	private List<Artista> artistas;
	
	@ManyToMany(mappedBy = "musicas")
	private List<PlayList> playlists;

	public Musica() {
		super();
	}

	public Musica(Long id, String titulo, Integer minutos, GeneroMusical generoMusical, List<Artista> artistas,
			List<PlayList> playlists) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.minutos = minutos;
		this.generoMusical = generoMusical;
		this.artistas = artistas;
		this.playlists = playlists;
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

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}

	public GeneroMusical getGeneroMusical() {
		return generoMusical;
	}

	public void setGeneroMusical(GeneroMusical generoMusical) {
		this.generoMusical = generoMusical;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public List<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}

}
