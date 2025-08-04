import java.util.Scanner;

class FilaLinkedList {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            FilaLinked filaLinked = new FilaLinked();

            String[] instruction = sc.nextLine().split(" ");

            while (!instruction[0].equals("end")) {
                if (instruction[0].equals("add")) {
                   filaLinked.add(Integer.parseInt(instruction[1]));
                }
                else if (instruction[0].equals("print"))
                    System.out.println(filaLinked.print());
                else if (instruction[0].equals("element"))
                     System.out.println(filaLinked.element());
                else if (instruction[0].equals("remove")) {
                    if(!filaLinked.remove())
                        System.out.println("empty");
                } else if (instruction[0].equals("search")) {
                    System.out.println(filaLinked.search(Integer.parseInt(instruction[1])));
                }


                instruction = sc.nextLine().split(" ");
            }

        } catch (Exception e) {
            System.err.println("erro: " + e.getMessage());
        }
    }
}

class FilaLinked {

    private Node head;
    private Node tail;
    private int size;

    public boolean remove() {
        if (isEmpty())
            return false;

        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.previous = null; // remove o primeiro
        }

        size--;
        return true;
    }

    public void add(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            this.tail = node;
            this.head = node;
        } else {
            this.tail.next = node;
            node.previous = this.tail;
            this.tail = node;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String print() {
       return print(this.head).trim();
    }

    private String print(Node node) {
        if (node == null)
            return "empty";

        if (node.next == null)
            return String.valueOf(this.tail.value);

        return node.value + " " + print(node.next);
    }

    public int element() {
        return this.head.value;
    }

    public int search(int value) {
        return search(value, this.head);
    }

    private int search(int value, Node node) {
        if (node == null)
            return - (size + 1);

        if (node.value == value)
            return 0;

        return 1 + search(value, node.next);
    }
}

