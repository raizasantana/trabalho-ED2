package principal;

import java.util.ArrayList;
import java.util.TreeMap;

import Arquivo.TrataArquivo;
import model.Endereco;
import model.Pessoa;


public class Principal {
	public static void main(String[] args) {
		//Ao descomentar esse codigo, o programa ira recriar todo o arquivo 'Pessoas.ser' com os objetos gravados
		/*
		int qtdP = 50000, qtdE = 100000;
		
		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);
		
		for(int i = 0; i < qtdP; i++){
			vetP[i].setEndereco(vetE[(int)(Math.random() * (qtdE - 1))]);
		}
		
		TrataArquivo.gravaObjetos(vetP, "Arquivos/Pessoas.ser");
		*/
		
		//Esse trecho de codigo so carrega as pessoas numa arvore e a imprime
		TreeMap<String, Object> listaPessoas = TrataArquivo.leArquivo("Arquivos/Pessoas.ser");
		System.out.println(listaPessoas);
	}
}
