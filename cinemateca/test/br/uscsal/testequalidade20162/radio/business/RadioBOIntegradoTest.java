package br.uscsal.testequalidade20162.radio.business;

import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

public class RadioBOIntegradoTest {

	private RadioBO radio;
	private static final String QUEBRA_LINHA = System.getProperty("line.separator");

	// Método a ser testado: public static void adicionarMusica(String tituloAlbum,
	// String nomeMusica) throws
	// RegistroNaoEncontradoException,
	// Verificar se a inclusão de uma música duplicada em um album retorna a
	// exceção adequada.
	// LEMBRE-SE DE QUE ESTE TESTE DEVE SER INTEGRADO!!!

	@Before
	public void setUp() throws RegistroNaoEncontradoException, RegistroDuplicadoException, ParseException {

		String nomeAlbum = "Album 1";
		String nomeMusica = "Musica 1";
		String interprete = "Interprete 1";
		String dataString = "06/05/2004";
		DateUtil dateUtil = new DateUtil();
		radio = new RadioBO();

		Date datalancamento = dateUtil.parse(dataString);
		radio.incluirAlbum(nomeAlbum, datalancamento, TipoMidia.CD);
		radio.incluirMusica(nomeMusica, 4, interprete);
		radio.adicionarMusica(nomeAlbum, nomeMusica);
	}

	@Test(expected = RegistroDuplicadoException.class)
	public void adicionarMusicaDuplicadaTeste() throws RegistroNaoEncontradoException, RegistroDuplicadoException {

		// Dados de Entrada
		String nomeMusica = "Musica 1";
		String nomeAlbum = "Album 1";

		// Executar o metodo a ser testado
		radio.adicionarMusica(nomeAlbum, nomeMusica);

	}
}
