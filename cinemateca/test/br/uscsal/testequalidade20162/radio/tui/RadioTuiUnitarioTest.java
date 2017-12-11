package br.uscsal.testequalidade20162.radio.tui;

import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ RadioTui.class })
public class RadioTuiUnitarioTest {

	// Método a ser testado: private static Integer obterTexto(String mensagem)
	// Verificar o processo de entrada e saída para obtenção de um texto.
	// Obs: fazer o mock do System.in e do System.out.

	@Test
	public void verificarObterTexto() throws Exception {

		Scanner scannerMock = PowerMockito.mock(Scanner.class);
		Whitebox.setInternalState(RadioTui.class, "sc", scannerMock);

		PrintStream printMock = PowerMockito.mock(PrintStream.class);
		System.setOut(printMock);
		
		String mensagemEsperada = "Texto Recebido";

		PowerMockito.when(scannerMock.nextLine()).thenReturn("Texto Recebido");

		String respostaAtual = Whitebox.invokeMethod(RadioTui.class, "obterTexto", "Texto Exibido");

		Mockito.verify(printMock).println("Texto Exibido");

		Assert.assertEquals(mensagemEsperada, respostaAtual);

	}
}
