import java.util.*;

class PartionaLomuto {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int[] entrada = new int[line.length];
		
		for (int i = 0; i < entrada.length; i++) {
			entrada[i] = Integer.parseInt(line[i]);
		}

		partiona(entrada);
		System.out.println(Arrays.toString(entrada));
	}

	public static void partiona(int[] array) {
		int iPivot = array.length - 1;
		int j = iPivot - 1;

		for (int i = iPivot - 1; i >= 0; i--) {
			if (array[iPivot] <= array[i]) {
				swap(array, i, j);
				j--;
			}
		}	

		swap(array, iPivot, j + 1);	
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux; 
		System.out.println(Arrays.toString(array));
	} 





}
