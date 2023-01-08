package SolucionEcuaciones;
//JOSÉ ALFREDO GARCÍA AGUILAR. MÉTODOS NUMÉRICOS. CLASE 4-5 PM
import java.util.Scanner;

public class InterpolacionLineal {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("INTERPOLACIÓN LINEAL - MÉTODOS NUMÉRICOS");
		System.out.println();
		System.out.print("Primer número a interpolar (Valor de X1): ");
		float x1 = entrada.nextFloat();
		System.out.print("Segunda número a interpolar (Valor de X0): ");
		float x0 = entrada.nextFloat();
		System.out.print("Primer intervalo menor: ");
		float prim_int_men = entrada.nextFloat();
		System.out.print("Segundo invervalo menor: ");
		float seg_int_men = entrada.nextFloat();
		System.out.print("¿De qué número quieres calcular el Logaritmo Natural?: ");
		float num = entrada.nextFloat();
		
		float ln_x1 = (float) Math.log(x1);
		float ln_x0 = (float) Math.log(x0);
		float f1_parte1 = ln_x0 + ((ln_x1-ln_x0)/(x1-x0)) * (num-x0);
		
		System.out.println();
		System.out.println("Usamos la ecuación y una interpolación lineal para ln(" + num + ") desde x0=" + x0 + " hasta x1=" + x1 + " para obtener: ");
		System.out.println("f(" + num + ") = " + ln_x1 + " + ((" + ln_x0 + " - " + ln_x1 + ") / (" + x0 + " - " + x1 + ")) * (" + num + " - " + x1 + ") = " + f1_parte1);
		
		float ln_seg_int_men = (float) Math.log(seg_int_men); 	
		float f1_parte2 = (ln_seg_int_men + ((ln_seg_int_men-ln_x1)/(seg_int_men-prim_int_men)) * (num-x0));
		
		System.out.println();
		System.out.println("Con el intervalo menor desde x0=" + prim_int_men + " hasta x1=" + seg_int_men + " se obtiene: ");
		System.out.println("f(" + num + ") = " + ln_x1 + " + ((" + ln_seg_int_men + " - " + ln_x1 + ") / (" + seg_int_men + " - " + prim_int_men + ")) * (" + num + " - " + x1 + ") = " + f1_parte2);
	}
}