package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

	public static void main(String[] args) {
		try {
			int tamRegistro = 39;
			byte[] texto = new byte[tamRegistro];
			RandomAccessFile raf = new RandomAccessFile("personas.txt", "rw");
			

			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			
			raf.seek(0);
			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			System.out.println((char)raf.read());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
