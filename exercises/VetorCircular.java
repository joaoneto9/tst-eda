import java.util.*;

class VetorCircular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		int n = sc.nextInt();

		String response = "";

		for (int i = 0; i < n; i++) {
			response += line[i % line.length] + " ";
		}

		System.out.println(response.trim());
	
	}


}
