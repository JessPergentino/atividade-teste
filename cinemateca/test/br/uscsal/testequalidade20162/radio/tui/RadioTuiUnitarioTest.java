package br.uscsal.testequalidade20162.radio.tui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;
import org.powermock.reflect.Whitebox;



@RunWith(PowerMockRunner.class)
@PrepareForTest({ RadioTui.class })
public class RadioTuiUnitarioTest {

	// Método a ser testado: private static Integer obterTexto(String mensagem)
	// Verificar o processo de entrada e saída para obtenção de um texto.
	// Obs: fazer o mock do System.in e do System.out.

	@Mock
	RadioTui radio;
	
	@Test
	public void verificarObterTexto() throws Exception {

		PowerMockito.mockStatic(System.class);
		
		radio = Whitebox.invokeMethod(radio);
		
		radio.adicionarMusica();
		
		PowerMockito.verifyPrivate(radio);

	}
}
