import java.util.*;

class TresMaisUm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int primeiro = sc.nextInt();
		int segundo = sc.nextInt();

		int maior = 0;

		if (primeiro > segundo) 
			maior = looping(primeiro, segundo);
		else 
			maior = looping(segundo, primeiro);

		System.out.println(maior);

		sc.close();
	}

	public static int looping(int maior, int menor) {
		 int moreTimes = algorithmRecursivo(menor, 1);

                 for (int i = menor + 1; i <= maior; i++) {
                          int times = algorithmRecursivo(i, 1);
                          if (times > moreTimes)
                              moreTimes = times;
                 }

		 return moreTimes;
	}


	//quero saber a quantidade de vezes que o algoritmo vai rodar
	public static int algorithmRecursivo(int numero, int times) {
		if (numero == 1)
			return times;

		if (numero % 2 == 0)
			return algorithmRecursivo(numero / 2, times + 1);

		return algorithmRecursivo(numero * 3 + 1, times + 1);

	} 
}
