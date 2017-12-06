package br.uscsal.testequalidade20162.radio.business;

import java.util.Date;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.persistence.AlbumDao;
import br.uscsal.testequalidade20162.radio.persistence.MusicaDao;

public class RadioBO {

	public static void incluirAlbum(String titulo, Date dataLancamento, TipoMidia tipoMidia) {
		Album album = new Album(titulo, dataLancamento, tipoMidia);
		AlbumDao.incluir(album);
	}

	public static void incluirMusica(String nome, Integer duracao, String nomeInterpretePrincipal ) {
		Musica musica = new Musica(nome, duracao, nomeInterpretePrincipal);
		MusicaDao.incluir(musica);
	}

	public static void adicionarMusica(String tituloAlbum, String nomeMusica) throws RegistroNaoEncontradoException,
			RegistroDuplicadoException {
		Album album = AlbumDao.buscarPorTitulo(tituloAlbum);
		Musica musica = MusicaDao.buscarPorNome(nomeMusica);
		album.adicionarMusica(musica);
	}

	public static void removerMusica(String tituloAlbum, String nomeMusica) throws RegistroNaoEncontradoException {
		Album album = AlbumDao.buscarPorTitulo(tituloAlbum);
		Musica musica = MusicaDao.buscarPorNome(nomeMusica);
		album.removerMusica(musica);
	}

}
