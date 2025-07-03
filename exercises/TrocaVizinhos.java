import java.util.*;

class TrocaVizinhos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int times = line.length / 2;

		for (int i = 0; i < times; i++) {
			int j = 2 * i;
			swap(line, j, j + 1);
		}

		System.out.println(Arrays.toString(line));
		
	}

	public static void swap(String[] array, int i, int j) {
		String aux = array[i];
		array[i] = array[j];
		array[j] = aux; 
	
	} 


}
