package br.uscsal.testequalidade20162.radio.tui;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import br.uscsal.testequalidade20162.radio.business.RadioBO;
import br.uscsal.testequalidade20162.radio.enums.TipoMidia;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroDuplicadoException;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;
import br.uscsal.testequalidade20162.radio.util.DateUtil;

public class RadioTui {

	private static final String ROTULO_TIPO_MIDIA = "Informe C (CD), V(Vinil) ou D(Digital).";
	private static final String MENS_TIPO_MIDIA_NAO_VALIDO = "Tipo de midia nao valido. "
			+ ROTULO_TIPO_MIDIA;
	private static final String MENS_DATA_NAO_VALIDA = "Data nao valida.";
	private static final String NOME_MUSICA = "Nome da misica:";
	private static final String TITULO_ALBUM = "Titulo do album:";
	private static final String ROTULO_NOME = "Nome:";
	private static final String ROTULO_NOME_INTERPRETE_PRINCIPAL = "Nome do interprete principal:";
	private static final String ROTULO_DURACAO = "Duracao:";
	private static final String ROTULO_DATA_LANCAMENTO = "Data de lancamento (dd/mm/aaaa):";
	private static final String ROTULO_TITULO = "Titulo:";
	private static final String REMOCAO_MUSICA_ALBUM = "Remocao de musica do album";
	private static final String INCLUSAO_MUSICA_ALBUM = "Inclusao de musica em album";
	private static final String TITULO_INCLUSAO_MUSICA = "Incusao de musica";
	private static final String TITULO_INCLUSAO_ALBUM = "Incusão de album";

	private static Scanner sc = new Scanner(System.in);

	public static void incluirAlbum() {
		System.out.println(TITULO_INCLUSAO_ALBUM);
		String titulo = obterTexto(ROTULO_TITULO);
		Date dataLancamento = obterData(ROTULO_DATA_LANCAMENTO);
		TipoMidia tipoMidia = obterTipoMidia();
		RadioBO.incluirAlbum(titulo, dataLancamento, tipoMidia);
	}

	public static void incluirMusica() {
		System.out.println(TITULO_INCLUSAO_MUSICA);
		String nome = obterTexto(ROTULO_NOME);
		Integer duracao = obterNumero(ROTULO_DURACAO);
		String nomeInterpretePrincipal = obterTexto(ROTULO_NOME_INTERPRETE_PRINCIPAL);
		RadioBO.incluirMusica(nome, duracao, nomeInterpretePrincipal);
	}

	public static void adicionarMusica() {
		System.out.println(INCLUSAO_MUSICA_ALBUM);
		String tituloAlbum = obterTexto(TITULO_ALBUM);
		String nomeMusica = obterTexto(NOME_MUSICA);
		try {
			RadioBO.adicionarMusica(tituloAlbum, nomeMusica);
		} catch (RegistroNaoEncontradoException | RegistroDuplicadoException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void removerMusica() {
		System.out.println(REMOCAO_MUSICA_ALBUM);
		String tituloAlbum = obterTexto(TITULO_ALBUM);
		String nomeMusica = obterTexto(NOME_MUSICA);
		try {
			RadioBO.removerMusica(tituloAlbum, nomeMusica);
		} catch (RegistroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
	}

	private static Date obterData(String mensagem) {
		System.out.println(mensagem);
		Date data = null;
		do {
			String dataString = sc.nextLine();
			try {
				return DateUtil.parse(dataString);
			} catch (ParseException e) {
				System.out.println(MENS_DATA_NAO_VALIDA);
			}
		} while (data != null);
		return data;
	}

	private static String obterTexto(String mensagem) {
		System.out.println(mensagem);
		return sc.nextLine();
	}

	private static Integer obterNumero(String mensagem) {
		System.out.println(mensagem);
		Integer numero = sc.nextInt();
		sc.nextLine();
		return numero;
	}

	private static TipoMidia obterTipoMidia() {
		System.out.println(ROTULO_TIPO_MIDIA);
		TipoMidia tipoMidia = null;
		do {
			String siglaTipoMidia = sc.nextLine();
			try {
				tipoMidia = TipoMidia.valueOfSigla(siglaTipoMidia);
			} catch (IllegalArgumentException e) {
				System.out.println(MENS_TIPO_MIDIA_NAO_VALIDO);
			}
		} while (tipoMidia == null);
		return tipoMidia;
	}

}
