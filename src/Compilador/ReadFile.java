package Compilador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe que implementa o m�todo que far� a leitura do conte�do de um arquivo
 * de texto.
 * 
 * Alunos: Daniel, Danilo
 */
public class ReadFile {

	/**
	 * Realiza a leitura do conte�do de um arquivo de texto.
	 * 
	 * @param caminho
	 *            do arquivo a ser lido.
	 * @return o conte�do do arquivo aberto.
	 * @throws Exception
	 *             ser� lan�ada caso ocorra algum erro na abertura ou leitura de um
	 *             arquivo.
	 */
	public static String Read(String caminho) throws Exception {
		String conteudo = "";
		try {
			FileReader arq = new FileReader(caminho);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = "";
			try {
				linha = lerArq.readLine();
				while (linha != null) {
					conteudo += linha + "\n";
					linha = lerArq.readLine();
				}
				arq.close();
				return conteudo;
			} catch (IOException ex) {
				throw new Exception("N�o foi poss�vel ler do arquivo!");
			}
		} catch (FileNotFoundException ex) {
			throw new Exception("Arquivo n�o encontrado!");
		}
	}
}