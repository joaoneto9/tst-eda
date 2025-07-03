import java.util.*;

class PosicaoElemento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String element = sc.nextLine();

		String[] line = sc.nextLine().split(" ");

		String response = "";
		for (int i = 0; i < line.length; i++) {
			if (element.equals(line[i]))
				response += i + " ";
		}

		if (response.isEmpty())
			response += "-1";

		System.out.println(response.trim());
		
	}


}
