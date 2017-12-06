package br.uscsal.testequalidade20162.radio.enums;

public enum TipoMidia {
	VINIL("V"), CD("C"), DIGITAL("D");

	private String sigla;

	private TipoMidia(String sigla) {
		this.sigla = sigla;
	}

	public String getSigla() {
		return sigla;
	}

	public static TipoMidia valueOfSigla(String sigla) {
		for (TipoMidia tipoMidia : values()) {
			if (tipoMidia.getSigla().equalsIgnoreCase(sigla)) {
				return tipoMidia;
			}
		}
		throw new IllegalArgumentException();
	}
}
