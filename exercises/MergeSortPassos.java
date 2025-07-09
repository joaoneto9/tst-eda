import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(Arrays.toString(array));

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int ini, int fim) {
        if (ini >= fim)
            return;

        int middle = (fim + ini) / 2;

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, ini, middle + 1)));

        mergeSort(array, ini, middle);

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, middle + 1, fim + 1)));

        mergeSort(array, middle + 1, fim);

        merge(array, ini, fim);
    }

    public static void merge(int[] array, int ini, int fim) {
        int rightHelper = fim - ini;

        int[] helper = new int[rightHelper + 1];

        // mapeou
        for (int i = 0; i < helper.length; i++) {
            helper[i] = array[ini + i];
        }
        //merge
        int i = 0;
        int middleHelper = rightHelper / 2;
        int j = middleHelper + 1;
        int k = ini;

        while (i <= middleHelper && j <= rightHelper) {
            if (helper[i] <= helper[j]) // percorrer o helper e add no array original
                array[k++] = helper[i++];
            else 
                array[k++] = helper[j++];
        }

        // se a primeira parte sobrar, adiciona...
        while (i <= middleHelper) 
            array[k++] = helper[i++];

        System.out.println(Arrays.toString(Arrays.copyOfRange(array, ini, fim + 1))); // imprime o limite do array original modificado "ordenado"
    }

}