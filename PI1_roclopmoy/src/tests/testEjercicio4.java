package tests;

import java.util.Arrays;
import java.util.List;

import ejercicios.Ejercicio4;
import us.lsi.common.Files2;

public class testEjercicio4 {

	public static void main(String[] args) {
		List<String> lineas = Files2.linesFromFile("ficheros/PI1Ej4DatosEntrada.txt");  
		Integer test = 1;
		for (String l : lineas) {  
			System.out.println("Test "+test+ ":");
			List<String> ls = Arrays.asList(l.split(","));  
																
			Integer a = Integer.valueOf(ls.get(0));  
			Integer b = Integer.valueOf(ls.get(1));  
			
			System.out.println("Recursivo sin memoria: " + Ejercicio4.ej4RecursivaSM(a, b));
			System.out.println("Recursivo con memoria: " + Ejercicio4.ej4RecursivaCM(a, b));
			System.out.println("Iterativo Imperativo: " + Ejercicio4.ej4IterativaI(a, b));
			System.out.println();
			test++;  

		}

	}

}
