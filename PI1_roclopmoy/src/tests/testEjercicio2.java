package tests;

import java.util.Arrays;
import java.util.List;

import ejercicios.Ejercicio2;
import us.lsi.common.Files2;

public class testEjercicio2 {

	public static void main(String[] args) {
		List<String> lineas = Files2.linesFromFile("ficheros/PI1Ej2DatosEntrada.txt");  
		Integer test = 1;
		for (String l : lineas) {  
			System.out.println("Test "+test+ ":");
			List<String> ls = Arrays.asList(l.split(","));  
																
			Integer a = Integer.valueOf(ls.get(0));  
			Integer b = Integer.valueOf(ls.get(1));  
			
			System.out.println("RecursivaNF: " + Ejercicio2.ej2RecursivaNF(a, b));
			System.out.println("RecursivaF: " + Ejercicio2.ej2RecursivaF(a, b));
			System.out.println("Iterativo: " + Ejercicio2.ej2Iterativo(a, b));
			System.out.println("Funcional: " + Ejercicio2.ej2Funcional(a, b));
			
			
			System.out.println();
			test++;  

		}

	}

}
