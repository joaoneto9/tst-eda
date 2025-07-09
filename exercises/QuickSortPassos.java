import java.util.Arrays;
import java.util.Scanner;

class QuickSortPassos {
    

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        
        int[] array = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int ini, int fim) {
        if (ini >= fim)
            return;

        int iPivot = partionamento(array, ini, fim);
        mergeSort(array, iPivot + 1, fim);
        mergeSort(array, ini, iPivot - 1);
    }

    public static int partionamento(int[] array, int ini, int fim) {
        int iPivot = ini;

        for (int i = ini + 1; i <= fim; i++) {

            if (array[ini] >= array[i]) {
                iPivot++;
                swap(array, i, iPivot); // vai colocando todos menores e iguais ao pivot a frente dele 
            }

        }

        swap(array, iPivot, ini); // coloca o Pivot em sua posicao

        System.out.println(Arrays.toString(array)
            .replace("[", "")
            .replace("]", "")
            .replace(",", ""));

        return iPivot;
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }
}
