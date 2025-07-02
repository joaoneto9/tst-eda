import java.util.*;

class DownN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] entrada = sc.nextLine().split(" ");

        int[] array = new int[entrada.length];

        for (int i = 0; i <  array.length; i++) {
            array[i] = Integer.parseInt(entrada[i]);
        }

        int quantidade = sc.nextInt();

        String result = "";

        for (int i = 0; i < quantidade; i++) {
            int menor = array[i];
            int iMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (menor > array[j]) {
                    menor = array[j];
                    iMenor = j;
                }
                
            }

            swap(array, i, iMenor);
            result += menor + " ";
        }

        System.out.println(result.trim());

    }

    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }


}
