import java.util.*;

class CountingSortStepsDefault {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int[] entrada = new int[line.length];
		
		for (int i = 0; i < entrada.length; i++) {
			entrada[i] = Integer.parseInt(line[i]);
		}

		int maior = sc.nextInt();

		int[] countingArray = counting(entrada, maior);
		System.out.println(format(sorting(entrada, countingArray)));

	}

	public static int[] counting(int[] array, int maior) {
		int[] countingArray = new int[maior + 1];
		
		for (int i = 0; i < array.length; i++) {
			countingArray[array[i]] += 1;
			System.out.println(format(countingArray));
		}

		for (int i = 1; i < countingArray.length; i++) {
			countingArray[i] += countingArray[i - 1];
		}

		System.out.println("Cumulativa do vetor de contagem - " + format(countingArray));

		return countingArray;
	}

	public static int[] sorting(int[] arrayPadrao, int[] counting) {
		int[] sortedArray = new int[arrayPadrao.length];
		
		for (int i = arrayPadrao.length - 1; i >= 0; i--) {
			int iCounting = arrayPadrao[i]; // indice do seu valor no array de counting
							
			sortedArray[counting[iCounting] - 1] = arrayPadrao[i];
			counting[iCounting] -= 1;
		}	

		System.out.println(format(counting));
		return sortedArray;
	}


	public static String format(int[] array) {
		return Arrays.toString(array)
                                .replace("[", "")
                                .replace("]", "")
				.replace(",", "");
	}





}
