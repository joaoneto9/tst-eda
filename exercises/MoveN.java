import java.util.*;

class MoveN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];

        for (int i = 0; i <  array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }

        int iDesordenado = indiceDesordenado(array);

	moveDesordenados(array, iDesordenado);
    }

    public static void insertion(int[] array, int i) {
	    while (i > 0 && array[i - 1] > array[i]) {
		    swap(array, i, i - 1);
		    System.out.println(Arrays.toString(array)); // printar toda troca
		    i--;
	    }
    }

    public static void moveDesordenados(int[] array, int iDesordenado) {
	    for (int i = iDesordenado; i < array.length; i++) {
		    insertion(array, i);
	    }
    
    }

    public static int indiceDesordenado(int[] array) {
	    for (int i = 0; i < array.length - 1; i++) {
		    if (array[i] > array[i + 1])
			    return i + 1;
	    }

	    return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }


}
