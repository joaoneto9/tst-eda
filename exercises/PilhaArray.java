import java.util.Scanner;

class PilhaArray {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            Pilha pilha = new Pilha(Integer.parseInt(sc.nextLine()));

            String[] instruction = sc.nextLine().split(" ");

            while (!instruction[0].equals("end")) {
                if (instruction[0].equals("push")) {
                    if (!pilha.push(Integer.parseInt(instruction[1])))
                        System.out.println("full");
                }

                else if (instruction[0].equals("print"))
                    System.out.println(pilha.print());

                else if (instruction[0].equals("peek"))
                    System.out.println(pilha.peek());

                else if (instruction[0].equals("pop")) {
                    int value = pilha.pop();

                    if (value == -1)
                        System.out.println("empty");
                }

                instruction = sc.nextLine().split(" ");
            }

        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
        }
    }
}

class Pilha {

    private int[] pilha;
    private int top = -1;

    public Pilha(int capacity) {
        this.pilha = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == this.pilha.length - 1;
    }

    public int peek() {
        if (isEmpty())
            return -1;

        return this.pilha[this.top];
    }

    public String print() {
        if (isEmpty())
            return "empty";

        Pilha pilhaAux = new Pilha(this.pilha.length);

        while (!isEmpty()) {
            int value = pop();

            pilhaAux.push(value);
        }

        return empilhar(pilhaAux);
    }

    private String empilhar(Pilha pilhaAux) {
        String result = "";

        while (!pilhaAux.isEmpty()) {
            int value = pilhaAux.pop();

            result += value + " ";
            push(value);
        }

        return result.trim();
    }

    public int pop() {
        if (isEmpty())
            return -1;

        return this.pilha[this.top--];
    }

    public boolean push(int value) {
        if (isFull())
            return false;

        this.pilha[++this.top] = value;
        return true;
    }


}
