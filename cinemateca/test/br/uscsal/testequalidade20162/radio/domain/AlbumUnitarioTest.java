package br.uscsal.testequalidade20162.radio.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Musica.class, Album.class })
public class AlbumUnitarioTest {

	// Método a ser testado: private void validarMusica(Musica musica) throws
	// RegistroDuplicadoException {
	// Verificar que é levantada a exceção adequada quando uma música já
	// existente em um album é validada.

	@Mock
	Album album;

	@SuppressWarnings("unchecked")
	@Test(expected = RegistroDuplicadoException.class)
	public void validarMusica() throws Exception {

		PowerMockito.mockStatic(Album.class);

		album = Whitebox.invokeMethod(album);

		PowerMockito.when(album, "validarMusica").thenThrow(RegistroDuplicadoException.class);

		PowerMockito.verifyPrivate(album);

	}

}
