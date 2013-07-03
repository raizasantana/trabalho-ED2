package Arquivo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import model.Pessoa;

public class TrataArquivo {
	
	public static void gravaObjeto(Object obj, String arquivo){
		FileOutputStream arq = null;
		ObjectOutputStream out = null;
		try{
			//Arquivo onde sera gravado
			arq = new FileOutputStream(arquivo, true);
			
			//Objeto que vai escrever os dados
			out = new ObjectOutputStream(arq);
			
			//Escreve os dados
			out.writeObject(obj);
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try{
				arq.close();
				out.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void gravaObjetos(Pessoa pessoas[], String arquivo){
		FileOutputStream arq = null;
		ObjectOutputStream out = null;
		try{
			//Arquivo onde sera gravado, trocar para TRUE quando quiser colocar no final do arquivo e nao sobrescrever tudo
			arq = new FileOutputStream(arquivo, false);
			
			//Objeto que vai escrever os dados
			out = new ObjectOutputStream(arq);
			
			//Escreve os dados
			for(int i = 0; i < pessoas.length; i++)
				out.writeObject(pessoas[i]);
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try{
				arq.close();
				out.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static TreeMap<String, Object> leArquivo(String arquivo){
		FileInputStream arq = null;
		ObjectInputStream in = null;
		TreeMap<String, Object> lista = null;
		Object obj = null;
		try {
			//Arquivo onde estao os dados serializados
			arq = new FileInputStream(arquivo);
	 
			//Recupera os dados
			lista = new TreeMap<String, Object>();
			obj = new Object();
			
			long startTime = System.currentTimeMillis();
			while(true){
				try{
					//E necessario criar um novo leitor de fluxo pra cada objeto
					in = new ObjectInputStream(arq);
					obj = in.readObject();
					if(obj instanceof Pessoa)
						lista.put(((Pessoa)obj).getId(), obj);
				} catch (EOFException e) {
					break;
				}
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Tempo total para o carregamento da arvore: " + totalTime);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				arq.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 
		return lista;
	}
}
