package SolucionEcuaciones;
//JOSÉ ALFREDO GARCÍA AGUILAR. MÉTODOS NUMÉRICOS. CLASE 4-5 PM
import java.text.DecimalFormat;
import java.util.Scanner;

public class ReglaDeSimpsonUnTercio {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		//Variables
		double lim_a, lim_b, intermedio, I, fx_lim_a, fx_lim_b, fx_intermedio, Et, Ea, Ea_superior, prom_cuarta_deriv;
		System.out.println("-REGLA DE SIMPSON 1/3 - MÉTODOS NUMÉRICOS-");
		System.out.println("Ecuación Original: f(x) = 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400x^5");

		//Consulta de los datos
		System.out.print("Ingrese el valor del Límite 'a': ");
		lim_a = entrada.nextDouble();
		System.out.print("Ingrese el valor del Límite 'b': ");
		lim_b = entrada.nextDouble();
		
		intermedio = (lim_a+lim_b)/2;
		
		//Se usa para darle 6 decimales a los números
		DecimalFormat df = new DecimalFormat("#.000000");
		
		//Solución
		fx_lim_a = 0.2 + (25*lim_a) - (200*Math.pow(lim_a, 2)) + (675*Math.pow(lim_a, 3)) - (900*Math.pow(lim_a, 4)) + (400*Math.pow(lim_a, 5));
		fx_intermedio = 0.2 + (25*intermedio) - (200*Math.pow(intermedio, 2)) + (675*Math.pow(intermedio, 3)) - (900*Math.pow(intermedio, 4)) + (400*Math.pow(intermedio, 5));
		fx_lim_b = 0.2 + (25*lim_b) - (200*Math.pow(lim_b, 2)) + (675*Math.pow(lim_b, 3)) - (900*Math.pow(lim_b, 4)) + (400*Math.pow(lim_b, 5));
		
		I = lim_b * ((fx_lim_a + (4*fx_intermedio) + fx_lim_b)/6);
		
		System.out.println();
		System.out.println("Por lo tanto, la ecuación se utiliza para calcular: ");
		System.out.println("I = " + df.format(lim_b) + " x ((" + df.format(fx_lim_a) + " + 4(" + df.format(fx_intermedio) + ") + " + df.format(fx_lim_b) + ") / 6) = " + df.format(I));
	
		Et = 1.640533 - I;
		
		System.out.println();
		System.out.println("Que representa un error exacto de E = 1.640533");
		System.out.println("Et = 1.640533 - " + df.format(I) + " = " + df.format(Et));
		
		Ea_superior = Math.pow(lim_b-lim_a, 5);
		
		prom_cuarta_deriv = -21600 + (48000*intermedio);
		
		Ea =  - ((Ea_superior) / 2880) * (prom_cuarta_deriv);
		
		System.out.println();
		System.out.println("El error estimado es");
		System.out.println("Ea = - ((" + lim_b + ")^5 / 2880) x (" + prom_cuarta_deriv + ") = " + df.format(Ea));
	}
}