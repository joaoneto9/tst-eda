import java.util.*;

class PrimeiroNegativoRecursivo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];

        for (int i = 0; i <  array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }

        System.out.println(primeiroNegativo(array, 0));
    }

    public static String primeiroNegativo(int[] array, int i) {
	    if (i >= array.length)
		    return "-";

	    if (array[i] < 0)
		    return String.valueOf(array[i]);

	    return primeiroNegativo(array, i + 1);
    }


}
