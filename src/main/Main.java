package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import serializables.Persona;

public class Main {

	private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		if (new File("listaPersonas.ser").exists()) {
			System.out.println("Archivo de guardado detectado. Cargando el array...");
			desSerializar();
		} else {
			System.out.println("Archivo de guardado no encontrado. Generando array...");
			listaPersonas.add(new Persona("Maria", "Garcia", "673847264"));
			listaPersonas.add(new Persona("Luis", "Fernandez", "6738109088"));
			listaPersonas.add(new Persona("Eusebio", "Luna", "623127809"));
			
			System.out.println("Introduce un nuevo nombre: ");
			String nombre = sc.nextLine();
			
			System.out.println("Introduce su apellido: ");
			String apellido = sc.nextLine();
			
			System.out.println("Introduce su telefono: ");
			String telefono = sc.nextLine();
			
			listaPersonas.add(new Persona(nombre, apellido, telefono));
			
			serializar();
		}
		
		
		
		
		
		
		

	}
	
	public static void serializar() {
		String path = "listaPersonas.ser";
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(listaPersonas);
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void desSerializar() {
		String path = "listaPersonas.ser";
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			listaPersonas = (ArrayList<Persona>) ois.readObject();
			
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
