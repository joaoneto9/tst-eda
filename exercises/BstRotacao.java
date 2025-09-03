import java.util.Scanner;

class BstRotacao {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) { 
            bst tree = new bst();

            assert tree.isEmpty();

            int n = Integer.parseInt(sc.nextLine());

            tree.add(n);

            assert !tree.isEmpty();

            int n2 = Integer.parseInt(sc.nextLine());

            tree.add(n2);

            assert tree.size() == 2;
            assert tree.getNode(n2).parent.value == n;

            if (n2 > n) 
                assert tree.getNode(n2).isRight();
            else 
                assert tree.getNode(n2).isLeft();

            System.out.println("pasou nos testes");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

class bst {

    private NodeBST root;
    private int size;

    public boolean isEmpty() {
        return this.root == null;
    }

    public void add(int n) {
        if (isEmpty())
            this.root = new NodeBST(n); 
        else 
            add(n, root);

        size++;
    }

    public void add(int n, NodeBST node) {
        if (n > node.value) {
            if (node.rigth == null) {
                node.rigth = new NodeBST(n);
                node.rigth.parent = node;
            } 

            add(n, node.rigth);
            return;
        }

        if (node.left == null) {
            node.left = new NodeBST(n);
            node.left.parent = node;
            return;
        } 
        add(n, node.left);
    }

    public int size() {
        return size;
    }

    public NodeBST getNode(int n) {
        return getNode(n, this.root);
    }

    private NodeBST getNode(int n, NodeBST nodeBST) {
        if (nodeBST == null)
            return null;

        if (nodeBST.value == n)
            return nodeBST;
        
        if (n > nodeBST.value) {
            return getNode(n, nodeBST.rigth);
        }

        return getNode(n, nodeBST.left);

    } 
}

class NodeBST {
    
    NodeBST rigth;
    NodeBST left;
    NodeBST parent;
    int value;

    public NodeBST(int value) {
        this.value = value;
    }

    public boolean isLeft() {
        return this.parent.value > this.value;
    }

    public boolean isRight() {
        return this.parent.value < this.value;
    }


}






