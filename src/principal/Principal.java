package principal;

import java.util.ArrayList;

import Arquivo.TrataArquivo;
import model.Endereco;
import model.Pessoa;


public class Principal {
	public static void main(String[] args) {
		int qtdP = 5, qtdE = 10, i = 0, j = 0;
		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);
		
		//O gravar funciona e guarda um novo objeto no final;
		//TrataArquivo.gravaObjeto(vetP[0], "Arquivos/Pessoas.ser");
		//TrataArquivo.gravaObjeto(vetP[1], "Arquivos/Pessoas.ser");
		
		ArrayList<Object> listaPessoas = TrataArquivo.leArquivo("Arquivos/Pessoas.ser");
		System.out.println(listaPessoas);
	}
}
