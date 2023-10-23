package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntPair;

public class Ejercicio4 {
	
	// Solución Recusrsiva Sin memoria
	
	public static String ej4RecursivaSM(Integer a, Integer b) {
		String cadena = ""; 
		
		if(a<=4) {
			cadena = a.toString()+"."+b.toString();
		}else if (b<=4) {
			cadena = b.toString()+"-"+a.toString();
		}else {
			cadena = ej4RecursivaSM(a/2,b-2)+","+ej4RecursivaSM(a-2,b/2)+","+ej4RecursivaSM(a-1,b-1);
		}
		
		return cadena;
    }
	
	
	//Solución Recursiva Con memoria
	
	public static String ej4RecursivaCM(Integer a, Integer b) {
		Map <IntPair,String> acumulador = new HashMap <IntPair,String>();
		return ej4RecursivaCM_aux( a,  b, acumulador);
		
    }

	private static String ej4RecursivaCM_aux(Integer a, Integer b, Map<IntPair, String> acumulador) {
		String cadena ="";
		IntPair parejaNumeros = IntPair.of(a,b); 
		if(acumulador.containsKey(parejaNumeros)) {
			cadena = cadena + acumulador.get(parejaNumeros);
		}else {
			if(a<=4) {
				cadena = a.toString()+"."+b.toString();
			}else if (b<=4) {
				cadena = b.toString()+"-"+a.toString();
			}else {
				cadena = ej4RecursivaCM_aux(a/2,b-2,acumulador)+
						","+ej4RecursivaCM_aux(a-2,b/2,acumulador)+
						","+ej4RecursivaCM_aux(a-1,b-1,acumulador);
			}
			acumulador.put(IntPair.of(a,b), cadena);
			
		}
		
		return cadena;
	}
	
	
	//Solución Iterativa Imperativa 
	
	public static String ej4IterativaI(Integer a, Integer b) {
		String cadena = "";
		Map <IntPair,String> acumulador = new HashMap <IntPair,String>();
		
		for(Integer i =0; i<=a; i++) {
			for (Integer j=0; j<=b; j ++) {
				if(i<=4) {
					cadena = i.toString()+"."+j.toString();
					
				}else if (j<=4) {
					cadena = j.toString()+"-"+i.toString();
				}else {
					cadena = acumulador.get(IntPair.of(i/2,j-2))+","+ 
							 acumulador.get(IntPair.of(i-2,j/2))+","+ 
							 acumulador.get(IntPair.of(i-1,j-1));
				}
				acumulador.put(IntPair.of(i,j), cadena); 
			}
		}
		return acumulador.get(IntPair.of(a,b));
    }

}
