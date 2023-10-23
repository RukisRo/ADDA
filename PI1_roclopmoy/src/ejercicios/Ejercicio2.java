package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//----------- Sol. Recursiva NO final -----------

	public static List<Integer> ej2RecursivaNF(Integer a, Integer b) {
		List<Integer> lista = new ArrayList<Integer>(); 
		if (a<2 || b<2) {
			lista.add(a*b);
		} else if (a>b) {
			lista = ej2RecursivaNF(a%b,b-1);
			lista.add(a); 
				
		}else {
			lista = ej2RecursivaNF(a-2,b/2);
			lista.add(b); 
		}
		
		return lista;
    }
	
	//----------- Sol. Iterativa -----------
	
	public static List<Integer> ej2Iterativo(Integer a, Integer b) {
		List<Integer> lista = new ArrayList<Integer>(); 
		while (a>=2 && b>=2) {
			if (a>b) {
				lista.add(0,a); 
				a= a%b;
				b=b-1;
				
			}else {
				lista.add(0,b); 
				a=a-2;
				b=b/2;
				
			}
		}
		if(a<2 || b<2) {
			lista.add(0, a*b); 
		}
		return lista;
    }
	
	//----------- Sol. Recursiva Final -----------
	
	public static List<Integer> ej2RecursivaF(Integer a, Integer b) {
		List<Integer> lista = new ArrayList<Integer>(); 
		 return lista = ej2RecursivaF_aux(a, b, lista);
    }
	
	public static List<Integer> ej2RecursivaF_aux(Integer a, Integer b, List<Integer> lista) {
		if (a<2 || b<2) {
			lista.add(a*b);
		} else if (a>b) {
			lista = ej2RecursivaF_aux(a%b,b-1,lista);
			lista.add(a); 
				
		}else {
			lista = ej2RecursivaF_aux(a-2,b/2,lista);
			lista.add(b); 
		}
		
		return lista;
    }
	
	
	//----------- Sol. Funcional -----------

	public static List<Integer> ej2Funcional(Integer a, Integer b) {
		List<Integer> lista = new ArrayList<Integer>(); 
		
		ParNumeros pn_inicial = ParNumeros.of(a, b);
		
			Stream
			.iterate(pn_inicial,pn ->pn != null, ParNumeros::next)
			.forEach(pn ->{
				if(pn.a()>pn.b()) {
					lista.add(0,pn.a());
				}else {
					lista.add(0,pn.b());
				}
			});
			return lista.stream()
					.collect(Collectors.toList());
    }
	
}
