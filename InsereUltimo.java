import java.util.*;

class InsereUltimo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		for (int i = line.length - 1; i > 0; i--) {
			if (Integer.parseInt(line[i]) >= Integer.parseInt(line[i - 1]))
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
