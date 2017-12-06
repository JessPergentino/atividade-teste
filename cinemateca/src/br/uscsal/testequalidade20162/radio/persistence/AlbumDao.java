package br.uscsal.testequalidade20162.radio.persistence;

import java.util.ArrayList;
import java.util.List;

import br.uscsal.testequalidade20162.radio.domain.Album;
import br.uscsal.testequalidade20162.radio.exceptions.RegistroNaoEncontradoException;

public class AlbumDao {
	
	private static final String MENS_ALBUM_NAO_ENCONTRADO = "Album com titulo %s nao encontrado.";
	
	private static List<Album> albuns = new ArrayList<>();
	
	public static void incluir(Album album){
		albuns.add(album);
	}

	public static Album buscarPorTitulo(String titulo) throws RegistroNaoEncontradoException{
		for(Album album:albuns){
			if(album.getTitulo().equalsIgnoreCase(titulo)){
				return album;
			}
		}
		throw new RegistroNaoEncontradoException(String.format(MENS_ALBUM_NAO_ENCONTRADO, titulo)); 
	}
	
}
