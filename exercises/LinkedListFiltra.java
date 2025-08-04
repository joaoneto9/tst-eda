import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class LinkedListFiltra {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedList linkedList = new LinkedList(array);

        linkedList.filtrar(Integer.parseInt(sc.nextLine()));

        System.out.println(linkedList);
    }

}

class LinkedList {

    private Node tail;
    private Node head;
    private int size;

    public LinkedList(int[] values) {
        for (int value : values) {
            addLast(value);
        }
    }

    @Override
    public String toString() {
        Node aux = this.tail;
        String result = "";

        while (aux != null) {
            result += aux.value + " ";
            aux = aux.next;
        }

        if (result.equals(""))
            return "vazia";

        return result.trim();
    }

    public String filtrar(int value) {
        if (isEmpty())
            return "vazia";

        filtrar(value, tail);
        return toString();
    }

    private void filtrar (int value, Node node) {
        if (node == null)
            return;

        Node aux = node;

        if (node.value == value) {
            remove(node);
        }

        filtrar(value, aux.next);
    }

    private void remove(Node node) {
        size--;

        if (this.tail.equals(node)) {
            removeFirst();
            return;
        }

        if (this.head.equals(node)) {
            removeLast();
            return;
        }

        node.next.previous = node.previous;
        node.previous.next = node.next;
    }

    private void removeLast() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }

        head = head.previous;
        head.next = null;
    }

    private void removeFirst() {
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }

        tail = tail.next;
        tail.previous = null;
    }

    public void addLast(int value) {
        Node node = new Node(value);

        if (isEmpty()) {
            this.head = node;
            this.tail = node;
        } else {
            node.previous = this.head;
            this.head = node;
            this.head.previous.next = node;
        }

        size++;
    }

    public boolean isEmpty() {
        return this.size == 0 || this.head == null;
    }
}

class Node {
    Node next;
    Node previous;
    int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
