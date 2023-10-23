package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {
	
	//Solución iterativa
	
	public static List <String> ej3Iterativa(String A, String B){
		List <String> lista = new ArrayList <String>();
		Iterator <String> itA = Files2.linesFromFile(A).iterator();
		Iterator <String> itB =Files2.linesFromFile(B).iterator();
		while (itA.hasNext() || itB.hasNext()) {
			if(itA.hasNext()) {
				lista.add(itA.next());
				if(itA.hasNext()) {
					lista.add(itA.next());
				}
			}
			if(itB.hasNext()) {
				lista.add(itB.next());
				if(itB.hasNext()) {
					lista.add(itB.next());
				}
			}
		}
		return lista;
	}
	
	
	
	//Solución Recursiva Final
	
	public static List <String> ej3RecursivaF(String A, String B){
		List <String> lista = new ArrayList<String>(); 
		Iterator <String> itA = Files2.linesFromFile(A).iterator();
		Iterator <String> itB =Files2.linesFromFile(B).iterator();
		return ej3RecursivaF_aux(A,B,lista,itA,itB);
	}

	private static List<String> ej3RecursivaF_aux(String a, String b, List<String> lista, Iterator<String> itA,
			Iterator<String> itB) {
		if (itA.hasNext() || itB.hasNext()) {
			if(itA.hasNext()) {
				lista.add(itA.next());
				if(itA.hasNext()) {
					lista.add(itA.next());
				}
			}
			if(itB.hasNext()) {
				lista.add(itB.next());
				if(itB.hasNext()) {
					lista.add(itB.next());
				}
			}
			lista=ej3RecursivaF_aux( a,  b, lista,  itA, itB);
		}
		return lista;
	}
	
	
	
	//Solución Funcional
	
	public static List <String> ej3Funcional(String A, String B){
		List<String> l1 = Files2.linesFromFile(A);
		List<String> l2 = Files2.linesFromFile(B);
		
		return ej3Funcional_aux(l1,l2).collect(Collectors.toList());
		
	}
	
	private static Stream <String> ej3Funcional_aux(List<String>l1,List< String>l2){
		Stream <String> stream = Stream.empty();
		if(!l1.isEmpty() || !l2.isEmpty()) {
			Stream <String> stream1 = l1.stream().limit(2);
			Stream <String> stream2 = l2.stream().limit(2);
			
			Stream <String> streamConcatenado = Stream.concat(stream1, stream2);
			
			stream = Stream.concat(streamConcatenado, ej3Funcional_aux(
					l1
					.stream()
					.skip(2)
					.collect(Collectors.toList()),
					l2
					.stream()
					.skip(2)
					.collect(Collectors.toList()))
					);
		}
		return stream;
	}
	
	

}
