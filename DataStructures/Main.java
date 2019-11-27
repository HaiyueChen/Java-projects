
/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Data structures");
        BST bst = new BST();

        // bst.insertIt(3);
        // bst.insertIt(2);
        // bst.insertIt(4);

        bst.insertRec(3);
        bst.insertRec(2);
        bst.insertRec(4);

        // BSTNode root = bst.getRoot();
        // System.out.println(root.getValue());
        // System.out.println(root.getLeft().getValue());
        // System.out.println(root.getRight().getValue());

        System.out.println(bst.findIRec(3));
        System.out.println(bst.findIRec(6));




    }
}