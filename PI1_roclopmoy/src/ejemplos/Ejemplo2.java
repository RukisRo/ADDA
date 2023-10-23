package ejemplos;

import java.util.stream.Stream;


public class Ejemplo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Iterativo: "+ejemplo2Iterativo(16,12));
		System.out.println("Recursivo No Final: "+ejemplo2RecursivoNF(16,12));
		System.out.println("Recursivo Final: "+ejemplo2RecursivoF(16,12));
		System.out.println("Funcional: "+ejemplo2Funcional(16,12));

	}
	
	
	
	//Dada la siguiente definición recursiva de la función f (que toma como entrada 2
	//números enteros positivos y devuelve una cadena):
	
	//---------- Iterativo -----------
	
	private static boolean esCasoBase(Integer a, Integer b) {
		return (a<5||b<5);
	}
	
	public static String ejemplo2Iterativo(Integer a, Integer b) {
		String acumulador ="";
		while(!esCasoBase(a,b)) {
			acumulador = acumulador +String.valueOf(a+b);
			a /=2;
			b -=2;
		}
		return acumulador +"("+ String.valueOf(a*b)+")";
	}
	
	//---------- Recursivo NO Final -----------
	
	public static String ejemplo2RecursivoNF(Integer a, Integer b) {
		String res ="";
		if(!esCasoBase(a,b)) {
			
			res=String.valueOf(a+b)+ ejemplo2RecursivoNF(a/2,b-2);
		}
		else {
			res= "("+ String.valueOf(a*b)+")";
		}
		return res; 
		
	}

	//---------- Recursivo Final -----------
	
	public static String ejemplo2RecursivoF(Integer a, Integer b) {
		return ejemplo2RecursivoF_aux("",a,b);
	}



	private static String ejemplo2RecursivoF_aux(String ac, Integer a, Integer b) {
		String res ="";
		if(esCasoBase(a,b)) {
			String res_caso_base = "("+ String.valueOf(a*b)+")";
			res =ac + res_caso_base;
		} else {
			String res_recursivo = ac + String.valueOf(a+b);
			res = ejemplo2RecursivoF_aux(res_recursivo,a/2,b-2);
		}
		return res;
	}
	
	//---------- Funcional -----------
	
	public static String ejemplo2Funcional(Integer a, Integer b) {
		Tupla t =Stream
				.iterate(Tupla.first(a,b), e ->e.next())
				.filter(e -> e.a()<5 || e.b()<5)
				.findFirst().get();
		return t.ac() + "("+ String.valueOf(t.a*t.b)+")";
	}
	
	private static record Tupla(String ac, Integer a, Integer b) {
		public static Tupla of(String ba, Integer a, Integer b) {
			return new Tupla(ba, a, b);
		}
		
		public static Tupla first(Integer a, Integer b) {
			return of("", a, b);
		}
		
		public Tupla next() {
			return of(ac + String.format("%d", a + b), a/2, b-2);
		}
	}
	

}
