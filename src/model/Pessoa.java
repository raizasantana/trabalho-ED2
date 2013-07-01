package model;

import java.util.HashMap;
import java.util.UUID;

public class  Pessoa {
	
	private String id;
	private String nome;
	private int idade;

	private Endereco endereco;
	
	public static Pessoa geraPessoaIdAleatorio(){
		Pessoa p = new Pessoa();
		p.setId(getIdAleatorio());
		p.setIdade(20);
		p.setNome("Usuario X");
		
		return p;		
	}
	
	public static Pessoa[] geraPessoas(int qtd){
		Pessoa vetPessoas[] = new Pessoa[qtd];
		int i = 0;
		while( i < qtd){
			vetPessoas[i] = geraPessoaIdAleatorio();
			i++;
		}
		return vetPessoas;
	}
	//Gerando id aleatorio
	public static String getIdAleatorio(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}   
	
	//Associando uma pessoa a um endereco
	public static HashMap<String, String> associaEndereco(Pessoa p[], Endereco e[]){
		HashMap<String, String> pessoaEndereco = new HashMap<String, String>();
		for (Pessoa pessoa : p) {
			int indiceE = (int) (Math.random() * e.length);
			pessoaEndereco.put(pessoa.getId(),e[indiceE].getId());
			pessoa.setEndereco(e[indiceE]);
		}
		return pessoaEndereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	

}
