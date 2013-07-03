package Arquivo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.TreeMap;

import model.Endereco;
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
	
	public static void gravaObjetos(Object vet[], String arquivo){
		FileOutputStream arq = null;
		ObjectOutputStream out = null;
		try{
			//Arquivo onde sera gravado, trocar para TRUE quando quiser colocar no final do arquivo e nao sobrescrever tudo
			arq = new FileOutputStream(arquivo, false);
			
			//Escreve os dados
			for(int i = 0; i < vet.length; i++){
				//Instancia um novo gravador de fluxo de dados pra cada objeto
				out = new ObjectOutputStream(arq);
				out.writeObject(vet[i]);
			}
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
	public static void gravaObjetos(Pessoa pessoas[],Endereco enderecos[],String arquivoP, String arquivoE){
		FileOutputStream arqP = null, arqE = null;;
		ObjectOutputStream outP = null, outE = null;
		try{
			//Arquivo onde sera gravado, trocar para TRUE quando quiser colocar no final do arquivo e nao sobrescrever tudo
			arqP = new FileOutputStream(arquivoP, false);
			arqE = new FileOutputStream(arquivoE, false);
			
			//Escreve os dados
			for(int i = 0; i < pessoas.length; i++){
				//Instancia um novo gravador de fluxo de dados pra cada objeto
				outP = new ObjectOutputStream(arqP);
				outP.writeObject(pessoas[i]);
			}	
			for(int i = 0; i < enderecos.length; i++){
				outE = new ObjectOutputStream(arqE);
				outE.writeObject(enderecos[i]);
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try{
				arqP.close();
				arqE.close();
				outP.close();
				outE.close();
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
					if(obj instanceof Endereco)
						lista.put(((Endereco)obj).getId(), obj);
				} catch (EOFException e) {
					break;
				}
			}
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Tempo total para o carregamento da arvore: " + totalTime + " ms");
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
	
	public static TreeMap<String, Object> leArquivo(String arquivoP, String arquivoE){
		FileInputStream arqP = null, arqE = null;
		ObjectInputStream inP = null, inE = null;;
		TreeMap<String, Object> listaP = null;
		HashMap<String, Object> listaE = null;
		Object objP = null, objE = null;
		try {
			//Arquivo onde estao os dados serializados
			arqP = new FileInputStream(arquivoP);
			arqE = new FileInputStream(arquivoE);
	 
			//Recupera os dados
			listaP = new TreeMap<String, Object>();
			listaE = new HashMap<String, Object>();
			objP = new Object();
			objE = new Object();
			
			long startTime = System.currentTimeMillis();
			while(true){
				try{
					//E necessario criar um novo leitor de fluxo pra cada objeto
					inE = new ObjectInputStream(arqE);
					objE = inE.readObject();					
					if(objE instanceof Endereco)
						listaE.put(((Endereco)objE).getId(), objE);
				} catch (EOFException e) {
					break;
				}
			}			
			while(true){
				try{
					//E necessario criar um novo leitor de fluxo pra cada objeto
					inP = new ObjectInputStream(arqP);
					objP = inP.readObject();
					if(objP instanceof Pessoa){
						Pessoa p  = ((Pessoa)objP); 
						p.setEndereco((Endereco)listaE.get(p.getIdEndereco()));
						listaP.put(p.getId(),p);
					}
				} catch (EOFException e) {
					break;
				}
			}				
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("Tempo total para o carregamento da arvore: " + totalTime + " ms");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				arqP.close();
				arqE.close();
				inP.close();
				inE.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	 
		return listaP;
	}
}
