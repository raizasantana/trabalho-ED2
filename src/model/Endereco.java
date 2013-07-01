package model;

import java.util.UUID;

public class Endereco {

	private String id;
	private String estado;
	private String cidade;
	private String rua;
	private int numero;
	
	
	//Gerando id aleatorio
	public static String getIdAleatorio(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	
	public static Endereco geraEnderecoIdAleatorio(){
		Endereco e = new Endereco();
		e.setId(getIdAleatorio());
		e.setCidade("Cidade X");
		e.setEstado("Estado X");
		e.setRua("Rua X");
		e.setNumero(300);
		return e;
	}
	
	public static Endereco[] geraEnderecos(int qtd){
		Endereco vetEnderecos[] = new Endereco[qtd];
		int i = 0;
		while (i < qtd){
			vetEnderecos[i] = geraEnderecoIdAleatorio();
			i++;
		}
		
		return vetEnderecos;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
