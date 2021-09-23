/**
 * 
 */
package br.edu.ifs.ed2.dados.no;

/**
 * Classe que implementas as operações de um nó de uma árvore AVL.
 * 
 * 
 *
 */
public class NoAVL<G> extends NoTriplo<G> {

	/*
	 * Atributos -------------------------------------------------------------------
	 */

	/**
	 * Atributo que armazena a altura do nó.
	 */
	private int altura;

	/*
	 * Construtores ----------------------------------------------------------------
	 */

	/**
	 * Construtor da classe.
	 * 
	 * @param conteudo Conteúdo do nó.
	 */
	public NoAVL(G conteudo) {

		super(conteudo);

		this.setAltura(0);
	}

	/*
	 * Gets e Sets -----------------------------------------------------------------
	 */

	/*
	 * Gets e Sets -----------------------------------------------------------------
	 */

	/**
	 * Método que retorna uma referência para o nó pai.
	 * 
	 * @return Uma referência para o nó pai, caso exista, ou nulo, caso contrário.
	 */
	public NoAVL<G> getPai() {

		return (NoAVL<G>) super.getPai();
	}

	/**
	 * Método que altera a referência para do nó pai.
	 * 
	 * @param pai O nó a ser alterado.
	 * 
	 */
	protected void setPai(NoAVL<G> pai) {

		this.pai = pai;
	}

	/**
	 * Método que retorna uma referência para o nó filho esquerdo.
	 * 
	 * @return Uma referência para o nó filho esquerdo, caso exista, ou nulo, caso
	 *         contrário.
	 */
	public NoAVL<G> getEsquerdo() {

		return (NoAVL<G>) this.esquerdo;
	}

	/**
	 * Método que retorna uma referência para o nó filho direito.
	 * 
	 * @return Uma referência para o nó filho direito, caso exista, ou nulo, caso
	 *         contrário.
	 */
	public NoAVL<G> getDireito() {

		return (NoAVL<G>) this.direito;
	}

	/**
	 * Método que altera a referência para o nó filho esquerdo. Essa operação altera
	 * também a relação de paternidade entre os nós envolvidos.
	 * 
	 * @param esquerdo O nó a ser alterado.
	 * 
	 */
	public void setEsquerdo(NoAVL<G> esquerdo) {

		if (this.esquerdo == esquerdo) {

			return;
		}

		this.esquerdo = esquerdo;

		if (esquerdo != null) {

			esquerdo.setPai(this);
		}
	}

	/**
	 * Método que altera a referência para o nó filho direito. Essa operação altera
	 * também a relação de paternidade entre os nós envolvidos.
	 * 
	 * @param direito O nó a ser alterado.
	 * 
	 */
	public void setDireito(NoAVL<G> direito) {

		if (this.direito == direito) {

			return;
		}

		this.direito = direito;

		if (direito != null) {

			direito.setPai(this);
		}
	}

	/**
	 * @return o altura
	 */
	public int getAltura() {

		return this.altura;
	}

	/**
	 * @param altura o altura a ser configurado
	 */
	public void setAltura(int altura) {

		this.altura = altura;
	}
}
