package br.uscsal.testequalidade20162.radio.persistence;

import java.util.ArrayList;
import java.util.List;

import br.uscsal.testequalidade20162.radio.domain.Musica;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

public class MusicaDao {
	
	private static final String MENS_MUSICA_NAO_ENCONTRADA = "Musica com nome %s nao encontrada.";
	
	private static List<Musica> musicas = new ArrayList<>();
	
	public static void incluir(Musica musica){
		musicas.add(musica);
	}

	public static Musica buscarPorNome(String nome) throws RegistroNaoEncontradoException{
		for(Musica musica:musicas){
			if(musica.getNome().equalsIgnoreCase(nome)){
				return musica;
			}
		}
		throw new RegistroNaoEncontradoException(String.format(MENS_MUSICA_NAO_ENCONTRADA, nome)); 
	}
	
}
