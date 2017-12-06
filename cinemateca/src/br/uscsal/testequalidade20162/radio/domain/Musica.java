package br.uscsal.testequalidade20162.radio.domain;

public class Musica {

	public String nome;

	public Integer duracao;

	public String nomeInterpretePrincipal;

	public Musica(String nome, Integer duracao, String nomeInterpretePrincipal) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.nomeInterpretePrincipal = nomeInterpretePrincipal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getNomeInterpretePrincipal() {
		return nomeInterpretePrincipal;
	}

	public void setNomeInterpretePrincipal(String nomeInterpretePrincipal) {
		this.nomeInterpretePrincipal = nomeInterpretePrincipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime
				* result
				+ ((nomeInterpretePrincipal == null) ? 0
						: nomeInterpretePrincipal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeInterpretePrincipal == null) {
			if (other.nomeInterpretePrincipal != null)
				return false;
		} else if (!nomeInterpretePrincipal
				.equals(other.nomeInterpretePrincipal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Musica [nome=" + nome + ", duracao=" + duracao
				+ ", nomeInterpretePrincipal=" + nomeInterpretePrincipal + "]";
	}

}
