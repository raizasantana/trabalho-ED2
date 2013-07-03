package principal;

import java.util.ArrayList;
import java.util.TreeMap;

import Arquivo.TrataArquivo;
import model.Endereco;
import model.Pessoa;


public class Principal {
	public static void main(String[] args) {
		/*
		int qtdP = 50, qtdE = 100;
		
		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);
		
		for(int i = 0; i < qtdP; i++){
			vetP[i].setEndereco(vetE[(int)(Math.random() * (qtdE - 1))]);
		}
		
		TrataArquivo.gravaObjetos(vetP, "Arquivos/Pessoas.ser");
		*/
		TreeMap<String, Object> listaPessoas = TrataArquivo.leArquivo("Arquivos/Pessoas.ser");
		System.out.println(listaPessoas);
	}
}
