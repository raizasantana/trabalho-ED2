package Arquivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class TrataArquivo {
	
	public static void gravaObjeto(Object obj, String arquivo){
		//FileOutputStream arq = null;
		ObjectOutputStream out = null;
		RandomAccessFile arq = null;
		try{
			//Arquivo onde sera gravado
			arq = new RandomAccessFile(arquivo, "rw");
			
			//Objeto que vai escrever os dados
			//out = new ObjectOutputStream(arq);
			
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
}
