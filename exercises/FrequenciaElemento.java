import java.util.*;

class FrequenciaElemento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String elem = sc.nextLine();

		String[] line = sc.nextLine().split(" ");

		int times = 0;
		for (int i = 0; i < line.length; i++) {
			if (elem.equals(line[i]))
				times++;
		}

		System.out.println(times);
	
	}



}
