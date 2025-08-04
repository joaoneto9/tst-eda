import java.util.Scanner;

class FilaArray {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            Fila fila = new Fila(Integer.parseInt(sc.nextLine()));

            String[] instruction = sc.nextLine().split(" ");

            while (!instruction[0].equals("end")) {
                if (instruction[0].equals("add")) {
                    if (!fila.add(Integer.parseInt(instruction[1])))
                        System.out.println("full");
                }

                else if (instruction[0].equals("print"))
                    System.out.println(fila.print());

                else if (instruction[0].equals("element"))
                    System.out.println(fila.getFirst());

                else if (instruction[0].equals("remove")) {
                    if (!fila.remove())
                        System.out.println("empty");
                }

                instruction = sc.nextLine().split(" ");
            }

        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
        }
    }

}

class Fila {

    private int size;
    private int head = -1;
    private int tail = -1;
    private int[] fila;

    public Fila(int capacity) {
        this.fila = new int[capacity];
    }

    public boolean isFull() {
        return size == fila.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String print() {
        if (isEmpty())
            return "empty";

        String resultado = "";
        int i = this.tail;

        while (i != this.head) {
            resultado += this.fila[i] + " ";
            i = ((1 + i) % this.fila.length);
        }

        return resultado + this.fila[this.head];
    }

    public boolean add(int value) {
        if (isFull())
            return false;

        this.head = ((1 + this.head) % this.fila.length);

        if (isEmpty()) {
            this.tail = ((1 + this.tail) % this.fila.length);
        }

        size++;
        this.fila[this.head] = value;

        return true;
    }

    public int getFirst() {
        if (isEmpty())
            return -1;

        return this.fila[this.tail];
    }

    public boolean remove() {
        if (isEmpty())
            return false;

        size--;

        if (isEmpty()) {
            this.head = -1;
            this.tail = -1;
        }

        this.tail = ((1 + this.tail) % this.fila.length);
        return true;
    }
}
