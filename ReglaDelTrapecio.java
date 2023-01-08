package SolucionEcuaciones;
//JOSÉ ALFREDO GARCÍA AGUILAR. MÉTODOS NUMÉRICOS. CLASE 4-5 PM
import java.text.DecimalFormat;
import java.util.Scanner;

public class ReglaDelTrapecio {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		//Variables
		double lim_a, lim_b, evaluacion_1, evaluacion_2, I, error, val_prom_seg_dev, Ea;
		//Planeteamiento del Problema
		System.out.println("-REGLA DEL TRAPECIO - MÉTODOS NUMÉRICOS-");
		System.out.println("Ecuación Original: f(x) = 0.2 + 25x - 200x^2 + 675x^3 - 900x^4 + 400x^5");
		System.out.println("Primera Derivada de la Ecuación: f'(x) = 25 - 400x + 2025x^2 - 3600x^3 + 2000x^4");
		System.out.println("Segunda Derivada de la Ecuación: f''(x) = -400 + 4050x - 10800x^2 + 8000x^3");
		System.out.println();
		
		//Consulta de los datos
		System.out.print("Ingrese el valor del Límite 'a': ");
		lim_a = entrada.nextDouble();
		System.out.print("Ingrese el valor del Límite 'b': ");
		lim_b = entrada.nextDouble();
		
		//Se usa para darle 6 decimales a los números
		DecimalFormat df = new DecimalFormat("#.000000");
		
		//Se calculan los resultados, al sustituir los limites en la ecuación original
		evaluacion_1 = 0.2 + (25*lim_a) - (200*Math.pow(lim_a, 2)) + (675*Math.pow(lim_a, 3)) - (900*Math.pow(lim_a, 4)) + (400*Math.pow(lim_a, 5));
		evaluacion_2 = 0.2 + (25*lim_b) - (200*Math.pow(lim_b, 2)) + (675*Math.pow(lim_b, 3)) - (900*Math.pow(lim_b, 4)) + (400*Math.pow(lim_b, 5));
		
		System.out.println();
		System.out.println("Al evaluar la función de los límites");
		System.out.println("f(" + lim_a + ") = " + df.format(evaluacion_1));
		System.out.println("f(" + lim_b + ") = " + df.format(evaluacion_2));
		
		I = lim_b * ((evaluacion_1 + evaluacion_2)/2);
		
		System.out.println();
		System.out.println("Sustituyendo la ecuación se tiene que");
		System.out.println("I = " + lim_b + "*((" + df.format(evaluacion_1) +  " + " + df.format(evaluacion_2) + ") / 2) = " + df.format(I)); 
		
		error = 1.640533 - I; // 1.640533 es el valor exacto de la integral, calculada de forma analítica
		
		System.out.println();
		System.out.println("La cual representa un error de");
		System.out.println("E = 1.640533 - " + df.format(I) + " = " + df.format(error));
		
		//El -48 es el valor de la segunda derivada
		val_prom_seg_dev = -48 / (lim_b-lim_a);
		
		System.out.println();
		System.out.println("El valor promedio de la segunda derivada = " + df.format(val_prom_seg_dev));
		
		//El 0.0833333 sale de dividir 1/12 (es parte de la formula)
		Ea = - 0.0833333 * (val_prom_seg_dev * Math.pow(lim_b, 3));
		
		System.out.println();
		System.out.println("Que se sustituye en la ecuación y EL RESULTADO FINAL ES: ");
		System.out.println("Ea = - (1/12)(" + df.format(val_prom_seg_dev) + "(" + lim_b + ")^3 = " + df.format(Ea));
	}
}