package ejercicios;

public record ParNumeros(Integer a, Integer b) {
	public static ParNumeros of(Integer a, Integer b) {
        return new ParNumeros(a, b);
	}
	
	public ParNumeros next() {
		if(a>=2 && b>=2) {
			if(a>b) {
				return ParNumeros.of(a%b,b-1);
			}else {
				return ParNumeros.of(a-2, b/2);
			}
		}else {
			return null; 
		}
	}

}
