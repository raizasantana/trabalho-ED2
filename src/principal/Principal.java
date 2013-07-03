package principal;

import java.util.ArrayList;
import java.util.TreeMap;

import Arquivo.TrataArquivo;
import model.Endereco;
import model.Pessoa;


public class Principal {
	public static void main(String[] args) {
		carregaPessoas();
		carregaPessoasEnderecos();
		TreeMap<String, Object> listaPessoas = TrataArquivo.leArquivo("Arquivos/Pessoas.ser");
		TreeMap<String, Object> listaPessoasEnderecos = TrataArquivo.leArquivo("Arquivos/Pessoas2.ser", "Arquivos/Enderecos.ser");
		
		//System.out.println(listaPessoas);
	}
	
	public static void carregaPessoas(){
		int qtdP = 100000, qtdE = 50000;
		
		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);
		
		for(int i = 0; i < qtdP; i++){
			vetP[i].setIdEndereco(vetE[(int) (Math.random() * (qtdE - 1))].getId());
		}
		
		TrataArquivo.gravaObjetos(vetP, "Arquivos/Pessoas.ser");
	}
	
	public static void carregaPessoasEnderecos() {
		int qtdP = 100000, qtdE = 50000;

		Pessoa vetP[] = Pessoa.geraPessoas(qtdP);
		Endereco vetE[] = Endereco.geraEnderecos(qtdE);

		for (int i = 0; i < qtdP; i++) {
			vetP[i].setIdEndereco(vetE[(int) (Math.random() * (qtdE - 1))].getId());
		}
		TrataArquivo.gravaObjetos(vetP, vetE, "Arquivos/Pessoas2.ser","Arquivos/Enderecos.ser");
	}
}
