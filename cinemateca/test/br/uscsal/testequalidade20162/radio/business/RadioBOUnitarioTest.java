package br.uscsal.testequalidade20162.radio.business;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.persistence.AlbumDao;
import br.uscsal.testequalidade20162.radio.persistence.MusicaDao;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AlbumDao.class, MusicaDao.class, Musica.class, Album.class })
public class RadioBOUnitarioTest {

	// MÃ©todo a ser testado: public static void adicionarMusica(String tituloAlbum,
	// String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusÃ£o de uma mÃºsica duplicada em um album retorna a
	// exceÃ§Ã£o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER UNITÃ�RIO!!!

	private RadioBO radio;
	
	@Mock
	AlbumDao albumDaoMock;
	MusicaDao musicaDaoMock;

	@Before
	public void setUp() throws ParseException, RegistroNaoEncontradoException, RegistroDuplicadoException {
		radio = new RadioBO();
		
		// Criação do Album
		String nomeAlbum = "Album 1";
		String dataString = "06/05/2001";
		DateUtil date = new DateUtil();
		Date dataLancamento = date.parse(dataString);
		Album album = new Album(nomeAlbum, dataLancamento, TipoMidia.CD);

		// Criação da Musica
		String nomeMusica = "Musica 1";
		Integer duracao = 4;
		String nomeInterprete = "Interprete 1";
		Musica musica = new Musica(nomeMusica, duracao, nomeInterprete);
		
		PowerMockito.mockStatic(albumDaoMock.getClass());
		PowerMockito.mockStatic(musicaDaoMock.getClass());
		
		PowerMockito.doNothing().when(albumDaoMock).incluir(album);
		PowerMockito.doNothing().when(musicaDaoMock).incluir(musica);
		
		PowerMockito.doNothing().when(albumDaoMock).buscarPorTitulo(nomeAlbum);
		PowerMockito.doNothing().when(musicaDaoMock).buscarPorNome(nomeMusica);
		
		radio.incluirAlbum(nomeAlbum, dataLancamento, TipoMidia.CD);
		radio.incluirMusica(nomeMusica, duracao, nomeInterprete);
		
		radio.adicionarMusica(nomeAlbum, nomeMusica);

	}

	@Test(expected = RegistroNaoEncontradoException.class)
	public void adicionarMusicaDuplicada() throws RegistroNaoEncontradoException, RegistroDuplicadoException {
		
		String nomeAlbum = "Album 1";
		String nomeMusica = "Musica 1";
		
		radio.adicionarMusica(nomeAlbum, nomeMusica);
		
	}
}
