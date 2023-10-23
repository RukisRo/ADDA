package tests;




import ejercicios.Ejercicio3;

public class testEjercicio3 {

	public static void main(String[] args) {
		Integer i =1;
		while (i<4) {
			String A ="ficheros/PI1Ej3DatosEntrada"+i+"A.txt";
			String B ="ficheros/PI1Ej3DatosEntrada"+i+"B.txt";
			i++;
			
			System.out.println("Iterativo "+(i-1)+": "+ Ejercicio3.ej3Iterativa(A, B));
			System.out.println("Recursiva Final "+(i-1)+": "+ Ejercicio3.ej3RecursivaF(A, B));
			System.out.println("Funcional "+(i-1)+": "+ Ejercicio3.ej3Funcional(A, B)+"\n");
		}
		
		

	}

}
