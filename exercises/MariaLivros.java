import java.util.*;

class MariaLivros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(",");

		System.out.println(formatacao(line));
		for (int i = 1; i < line.length; i++) {

			int j = i;
			while (true) {
				if (j < 1)  // se j for == 0, quebrar loop.
				        break;

				if (line[j - 1].compareTo(line[j]) <= 0)
					break;

				swap(line, j - 1, j);
				j--; // ele faz o insertion pelas porcoes;
			}

			System.out.println(formatacao(line));
		
		}
		
	}

	public static void swap(String[] array, int i, int j) {
		String aux = array[i];
		array[i] = array[j];
		array[j] = aux; 
	
	} 

	public static String formatacao(String[] array) {
		return Arrays.toString(array)
                                .replace("[", "")
                                .replace("]", "");
	}


}
