import java.util.*;

class InserePrimeiro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		for (int i = 1; i < line.length; i++) {
			if (Integer.parseInt(line[i - 1]) <= Integer.parseInt(line[i]))
				break;
			swap(line, i - 1, i);
		}

		System.out.println(Arrays.toString(line));
	
	}

	public static void swap(String[] array, int i, int j) {
		String aux = array[i];
		array[i] = array[j];
		array[j] = aux; 
	
	} 





}
