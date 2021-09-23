/**
 * 
 */
package br.edu.ifs.ed2.dados.hash.colisao;

import br.edu.ifs.ed2.dados.hash.Hash;
import br.edu.ifs.ed2.dados.hash.HashAberto;

/**
 * Classe que implementa a técnica linear de tratamento de colisões.
 * 
 * 
 *
 */
public class ColisaoLinear<G> implements EstrategiaColisao<G> {

	/**
	 * 
	 */
	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela) {

		/*
		 * Coerção da tabela para um hash aberto.
		 */
		HashAberto<G> hash = (HashAberto<G>) tabela;

		/*
		 * Inicialização do novo índice.
		 */
		int novoIndice = 0;

		/*
		 * Aplicação da técnica de endereçamento linear para a busca de uma célula livre
		 * a partir do índice inicial.
		 */
		for (int i = 0; i < hash.getTamanho(); ++i) {

			/*
			 * 
			 */
			novoIndice = (indiceInicial + i) % hash.getTamanho();

			/*
			 * 
			 */
			if (hash.getEstado()[novoIndice] == null) {

				return novoIndice;
			}

			/*
			 * 
			 */
			if (hash.getEstado()[novoIndice].equals("R")) {

				return novoIndice;
			}

		}

		/*
		 * Indicação de resolução de colisão mal sucedida.
		 */
		return -1;
	}

	/**
	 * 
	 */
	@Override
	public int obterIndice(int indiceInicial, Hash<G> tabela, G conteudo) {

		/*
		 * Coerção da tabela para um hash aberto.
		 */
		HashAberto<G> hash = (HashAberto<G>) tabela;
		
		/*
		 * Inicialização do índice.
		 */
		int novoIndice = 0;

		/*
		 * Aplicação da técnica de endereçamento linear para a busca de um conteúdo a
		 * partir do índice inicial.
		 */
		for (int i = 0; i < hash.getTamanho(); ++i) {

			/*
			 * 
			 */
			novoIndice = (indiceInicial + i) % hash.getTamanho();

			/*
			 * 
			 */
			if (hash.getEstado()[novoIndice] == null) {

				return -1;
			}

			/*
			 * 
			 */
			if (hash.getEstado()[novoIndice].equals("R")) {

				continue;
			}

			/*
			 * 
			 */
			if (hash.getTabela()[novoIndice].equals(conteudo)) {

				return novoIndice;
			}
		}

		/*
		 * Indicação de resolução de colisão mal sucedida.
		 */
		return -1;
	}
}
