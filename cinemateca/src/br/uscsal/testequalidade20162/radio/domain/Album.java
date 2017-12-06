package br.uscsal.testequalidade20162.radio.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

public class Album {

	private static final String MENS_MUSICA_JA_PARTE_ALBUM = "Musica %s ja faz parte do album";

	private static final String MENS_MUSICA_NAO_PARTE_ALBUM = "Musica %s nao faz parte do album.";

	public String titulo;

	public Date dataLancamento;

	public TipoMidia tipoMidia;

	public List<Musica> musicas = new ArrayList<>();

	public Album(String titulo, Date dataLancamento, TipoMidia tipoMidia) {
		super();
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.tipoMidia = tipoMidia;
	}

	public void adicionarMusica(Musica musica)
			throws RegistroDuplicadoException {
		validarMusica(musica);
		musicas.add(musica);
	}

	public void removerMusica(Musica musica)
			throws RegistroNaoEncontradoException {
		if (!musicas.contains(musica)) {
			throw new RegistroNaoEncontradoException(String.format(
					MENS_MUSICA_NAO_PARTE_ALBUM, musica.getNome()));
		}
	}

	private void validarMusica(Musica musica) throws RegistroDuplicadoException {
		if (musicas.contains(musica)) {
			throw new RegistroDuplicadoException(String.format(
					MENS_MUSICA_JA_PARTE_ALBUM, musica.getNome()));
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	@Override
	public String toString() {
		return "Album [titulo=" + titulo + ", dataLancamento=" + dataLancamento
				+ ", musicas=" + musicas + "]";
	}

}
