import java.util.*;

class MelhorPivot {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] entrada = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] copy = entrada;

		int[] indices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int iDifPrimeiro = Math.abs((entrada.length / 2) - partiona(entrada, indices[0]));
		int iDifSegundo = Math.abs((entrada.length / 2) - partiona(copy, indices[1]));

		if (iDifPrimeiro > iDifSegundo)
			System.out.println(indices[1]);

		else if (iDifPrimeiro < iDifSegundo)
			System.out.println(indices[0]);

		else 
			System.out.println(indices[0]);
		
	}

	public static int partiona(int[] entrada, int indice) {
		swap(entrada, indice, entrada.length - 1);

		int j = entrada.length - 2;

		for (int i = j; i >= 0; i--) {
			if (entrada[i] >= entrada[entrada.length - 1]) {
				swap(entrada, j, i);
				j--; 
			}
		}

		swap(entrada, j + 1, entrada.length - 1); // posiciona na posicao pivot
		return j + 1; // retorna a posicao do pivot
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[j] = array[i];
		array[i] = aux;
	}
}
