package tests;

import java.util.Arrays;
import java.util.List;


import ejercicios.Ejercicio1;
import us.lsi.common.Files2;

public class testEjercicio1 {
	
	public static void main(String[] args) {
		List<String> lineas = Files2.linesFromFile("ficheros/PI1Ej1DatosEntrada.txt");  
		Integer test = 1;
		for (String l : lineas) {  
			System.out.println("Test "+test+ ":");
			List<String> ls = Arrays.asList(l.split(","));  
																
			Integer a = Integer.valueOf(ls.get(0));  
			Integer b = Integer.valueOf(ls.get(1));  
			
			System.out.println("Funcional: " + Ejercicio1.ejercicio1(a, b));
			System.out.println("Iterativo: " + Ejercicio1.ej1Iterativo(a, b));
			System.out.println("Recursivo Final: " + Ejercicio1.ejercicio1RecursivaF(a, b));
			System.out.println();
			test++;  

		}
	}
}
