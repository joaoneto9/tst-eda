import java.util.*;

class CountingSortSteps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int[] entrada = new int[line.length];
		
		for (int i = 0; i < entrada.length; i++) {
			entrada[i] = Integer.parseInt(line[i]);
		}

		int maior = sc.nextInt();
		int menor = sc.nextInt();

		int[] countingArray = counting(entrada, maior, menor);
		System.out.println(Arrays.toString(sorting(entrada, countingArray, menor)));

	}

	public static int[] counting(int[] array, int maior, int menor) {
		int[] countingArray = new int[maior - menor + 1];
		
		for (int i = 0; i < array.length; i++) {
			countingArray[array[i] - menor] += 1;
			System.out.println(Arrays.toString(countingArray));
		}

		for (int i = 1; i < countingArray.length; i++) {
			countingArray[i] += countingArray[i - 1];
		}

		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(countingArray));

		return countingArray;
	}

	public static int[] sorting(int[] arrayPadrao, int[] counting, int menor) {
		int[] sortedArray = new int[arrayPadrao.length];
		
		for (int i = arrayPadrao.length - 1; i >= 0; i--) {
			int iCounting = arrayPadrao[i] - menor; // indice do seu valor no array de counting
			sortedArray[counting[iCounting] - 1] = arrayPadrao[i];
			counting[iCounting] -= 1;
		}	

		System.out.println(Arrays.toString(counting));
		return sortedArray;
	}





}
