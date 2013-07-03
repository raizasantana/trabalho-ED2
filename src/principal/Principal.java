package principal;

import Arquivo.TrataArquivo;
import model.Endereco;
import model.Pessoa;


public class Principal {
	public static void main(String[] args) {
		int qtdP = 5, qtdE = 10, i = 0, j = 0;
		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);
		
		TrataArquivo.gravaObjeto(vetP[0], "Arquivos/Pessoas.ser");
		TrataArquivo.gravaObjeto(vetP[1], "Arquivos/Pessoas.ser");
	}
}
