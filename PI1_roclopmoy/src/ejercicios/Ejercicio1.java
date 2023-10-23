package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	//---------- Funcional ----------
	
	public static String ejercicio1 (Integer varA, Integer varB) {
		UnaryOperator<EnteroCadena> nx = elem -> {
		return EnteroCadena.of(elem.a()+3, elem.a()%2==0? elem.a()+"*":elem.a()+"!");
		};
		
		return Stream
		.iterate(EnteroCadena.of(varA,"A"), elem -> elem.a() < varB, nx)
		.filter(elem -> elem.a()%10 != 0) 
		.map(elem -> elem.s()) 
		.collect(Collectors.joining("-")); 
		}
	
	//---------- Iterativo ----------
	
	//public static String ej1Iterativo(Integer varA, Integer varB) {
	public static List<String> ej1Iterativo(Integer varA, Integer varB) {
		EnteroCadena ec =EnteroCadena.of(varA,"A");
		//String cadena = ""; 
		List <String> lista = new ArrayList<String>();
		while (ec.a()<varB) {
			if (ec.a()%10 != 0) {
				//cadena = cadena + ec.s().concat("-"); 
				//lista.add(ec.s().concat("-")); 
				lista.add(ec.s()); 
				ec = EnteroCadena.of(ec.a()+3, ec.a()%2==0? ec.a()+"*":ec.a()+"!");
				
			} else {
				ec = EnteroCadena.of(ec.a()+3, ec.a()%2==0? ec.a()+"*":ec.a()+"!");
				}
		}
        //StringBuilder builder = new StringBuilder(cadena);
        //builder.deleteCharAt(cadena.length() - 1);
		
		//return builder.toString();
		return lista; 
    }
        
	//---------- Recursivo Final ----------
	
	public static String ejercicio1RecursivaF (Integer varA, Integer varB) {
		return ejercicio1RecursivaF_aux(varA,varB,EnteroCadena.of(varA,"A"),""); 
		}

	private static String ejercicio1RecursivaF_aux(Integer varA, Integer varB, EnteroCadena ec, String cadena) {
		while (ec.a()<varB) { 
			if (ec.a()%10 != 0) { //Caso base
				cadena = cadena + ec.s().concat("-"); 
				ec = EnteroCadena.of(ec.a()+3, ec.a()%2==0? ec.a()+"*":ec.a()+"!");
				
			} else {
				
				return ejercicio1RecursivaF_aux(varA,varB,
						EnteroCadena.of(ec.a()+3, 
						ec.a()%2==0? ec.a()+"*":ec.a()+"!"),cadena);
				}
		}
        StringBuilder builder = new StringBuilder(cadena);
        builder.deleteCharAt(cadena.length() - 1);
		
		return builder.toString();
    }
}

