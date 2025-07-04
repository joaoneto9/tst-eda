import java.util.*;

class DoisSomamOtimizado {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int[] entrada = new int[line.length];
		
		for (int i = 0; i < entrada.length; i++) {
			entrada[i] = Integer.parseInt(line[i]);
		}

		int soma = sc.nextInt(); // o valor da soma
		String response = "-1";

		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < entrada.length; i++) {
			if (set.contains(soma - entrada[i])) {
				response = (soma - entrada[i]) + " " + entrada[i];
				break; // quebra, encontro o par
			}

			set.add(entrada[i]);
		}

		System.out.println(response);

	}

}
