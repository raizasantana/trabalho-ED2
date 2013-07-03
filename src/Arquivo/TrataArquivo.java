package Arquivo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
	
	public static Object leObjeto(String arquivo){
		FileInputStream arq = null;
		ObjectInputStream in = null;
		Object obj = null;
		try {
			//Arquivo onde estao os dados serializados
			arq = new FileInputStream(arquivo);
	 
			//Objeto que vai ler os dados do arquivo
			in = new ObjectInputStream(arq);
	 
			//Recupera os dados
			obj = in.readObject();
			obj = in.readObject();
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
	 
		return obj;
	}
	
	public static ArrayList<Object> leArquivo(String arquivo){
		FileInputStream arq = null;
		ObjectInputStream in = null;
		ArrayList<Object> lista = null;
		try {
			//Arquivo onde estao os dados serializados
			arq = new FileInputStream(arquivo);
	 
			//Recupera os dados
			lista = new ArrayList<Object>();
			while(true){
				try{
					//E necessario criar um novo leitor de fluxo pra cada objeto
					in = new ObjectInputStream(arq);
					lista.add(in.readObject());
				} catch (EOFException e) {
					break;
				}
			}
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
