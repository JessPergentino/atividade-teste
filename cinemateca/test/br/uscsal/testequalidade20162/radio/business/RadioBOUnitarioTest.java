package br.uscsal.testequalidade20162.radio.business;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.persistence.AlbumDao;
import br.uscsal.testequalidade20162.radio.persistence.MusicaDao;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ AlbumDao.class, MusicaDao.class })
public class RadioBOUnitarioTest {

	// MÃ©todo a ser testado: public static void adicionarMusica(String tituloAlbum,
	// String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusÃ£o de uma mÃºsica duplicada em um album retorna a
	// exceÃ§Ã£o adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER UNITÃ�RIO!!!

	private RadioBO radio;

	@Before
	public void setUp() throws Exception {

		String dataString = "06/07/2008";
		DateUtil date = new DateUtil();
		Date dataLancamento = date.parse(dataString);

		Musica musica = new Musica("Musica 1", 4, "Interprete");
		Album album = new Album("Album 1", dataLancamento, TipoMidia.CD);

		PowerMockito.mockStatic(AlbumDao.class);
		PowerMockito.mockStatic(MusicaDao.class);

		PowerMockito.when(AlbumDao.class, "buscarPorTitulo", "Album 1").thenReturn(album);
		PowerMockito.when(MusicaDao.class, "buscarPorNome", "Musica 1").thenReturn(musica);

		radio.adicionarMusica("Album 1", "Musica 1");
	}

	@Test(expected = RegistroDuplicadoException.class)
	public void adicionarMusicaDuplicada() throws RegistroNaoEncontradoException, RegistroDuplicadoException {

		radio.adicionarMusica("Album 1", "Musica 1");

	}
}
