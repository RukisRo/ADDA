package ejercicios;

public record EnteroCadena(Integer a, String s) {
	
	public static EnteroCadena of(int a, String s) {
        return new EnteroCadena(a, s);
	}

}