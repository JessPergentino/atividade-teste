package br.uscsal.testequalidade20162.radio.domain;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Musica.class, Album.class })
public class AlbumUnitarioTest {

	// Método a ser testado: private void validarMusica(Musica musica) throws
	// RegistroDuplicadoException {
	// Verificar que é levantada a exceção adequada quando uma música já
	// existente em um album é validada.

	private Album album;

	@Before
	public void setUp() throws Exception {
		DateUtil date = new DateUtil();
		String dataString = "04/05/2006";
		Date dataLancamento = date.parse(dataString);

		album = new Album("Album 1", dataLancamento, TipoMidia.CD);

		Musica musica = new Musica("Musica 1", 4, "Interprete");

		album.adicionarMusica(musica);
	}

	@Test(expected = RegistroDuplicadoException.class)
	public void validarMusica() throws Exception {

		Musica musica = new Musica("Musica 1", 4, "Interprete");

		Whitebox.invokeMethod(album, "validarMusica", musica);

	}

}
