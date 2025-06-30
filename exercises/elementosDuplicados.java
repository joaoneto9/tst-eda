import java.util.*;

class elementosDuplicados {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");

		System.out.println(elementoDuplicado(line));
	}

	public static boolean elementoDuplicado(String[] line) {
		Set<String> set = new HashSet<>();
                for (int i = 0; i < line.length; i++) {
                        if (!set.add(line[i]))
                                return true;
                }

                return false;
	
	}

}
