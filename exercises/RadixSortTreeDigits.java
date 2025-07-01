import java.util.*;

class RadixSortTreeDigits {

	public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String[] line = sc.nextLine().split(" ");

                int[] entrada = new int[line.length];

                for (int i = 0; i < entrada.length; i++) {
                        entrada[i] = Integer.parseInt(line[i]);
                }

		int digitos = sc.nextInt();

		for (int i = 0; i < digitos / 3; i++) {
			int maior = maior(entrada, i);

			int[] countingArray = countingArray(entrada, maior, i); // pegar o maior de tres casas decimais
			
			int[] sort = sort(entrada, countingArray, i);
			System.out.println(Arrays.toString(sort));
		}
	}

	public static int[] sort(int[] entrada, int[] counting, int indice) {
		int[] sortedArray = new int[entrada.length];

		for (int i = entrada.length - 1; i >= 0; i--) {
			int numberEntrada = counting[tripleNumber(entrada[i], indice) - 1]; 

			int indiceNumber = numberEntrada - 1; // indice para adiconar alocado
			sortedArray[indiceNumber] = entrada[i]; // aloca na poosicao ordenada
			
			counting[tripleNumber(entrada[i], indice) - 1] -= 1; // adicionou, diminui um
		}

		return sortedArray;
	
	}

	public static int[] countingArray(int[] entrada, int maior, int indice) {
		int[] counting = new int[maior];

		for (int i = 0; i < entrada.length; i++) {
			counting[tripleNumber(entrada[i], indice) - 1] += 1;
		}	

		for (int i = 1; i < counting.length; i++) {
			counting[i] += counting[i-1];
		} 

		return counting;
	}

	public static int maior(int[] array, int indice) {
		int maior = tripleNumber(array[0], indice);
		
		for (int i = 1; i < array.length; i++) {
			int number = tripleNumber(array[i], indice);

			if (number > maior)
			    maior = number;
		}

		return maior;
	}


	public static int tripleNumber(int number, int expoente) {
		return (number / (int) Math.pow(10, 3*expoente)) % 1000;
	}

}
