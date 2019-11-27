/**
 * BST
 */
public class BST {

    private int size = 0;
    private BSTNode root = null;

    public BSTNode getRoot(){
        return this.root;
    }

    
    public void insertRec(int value){
        if(root == null){
            root = new BSTNode(null, value);
        }
        else{
            root.add(value);
        }
        this.size ++;
    }

    public void insertIt(int value){
        if(root == null){
            root = new BSTNode(null, value);
        }
        else{
            BSTNode iter = root;
            while (iter.getLeft() != null || iter.getRight() != null) {
                if(value < iter.getValue()){
                    if(iter.getLeft() == null){ break;}
                    iter = iter.getLeft();
                }
                else{
                   if(iter.getRight() == null){ break;}
                   iter = iter.getRight();
                }
            }
            if(value < iter.getValue()){
                iter.setLeft(new BSTNode(iter, value));
            }
            else{
                iter.setRight(new BSTNode(iter, value));
            }
        }
        this.size ++;
    }

    public BSTNode findIRec(int value){
        return root != null ? root.find(value) : null;
    }

    public BSTNode findIt(int value){
        if(root == null) return null;

        BSTNode iter = root;
        while (iter != null) {
            if(iter.getValue() == value){
                return iter;
            }
            if(value < iter.getValue()){
                iter = iter.getLeft();
            }
            else{
                iter = iter.getRight();
            }
        }
        return null;
    }

    public int size(){
        return this.size;
    }



    
}

class BSTNode {
    private BSTNode parent;
    private BSTNode left = null;
    private BSTNode right = null;
    private int value;

    BSTNode(BSTNode parent, int value) {
        this.parent = parent;
        this.value = value;
    }

    public void setLeft(BSTNode left){
        this.left = left;
    }

    public void setRight(BSTNode right){
        this.right = right;
    }

    public int getValue(){
        return this.value;
    }

    public BSTNode getParent(){
        return this.parent;
    }

    public BSTNode getLeft(){
        return this.left;
    }

    public BSTNode getRight(){
        return this.right;
    }

    public void add(int value) {
        if (value < this.value) {
            if(left == null){
                left = new BSTNode(this, value);
                return;
            }
            left.add(value);
            return;
        }

        if(right == null){
            right = new BSTNode(this, value);
            return;
        }

        right.add(value);
        
    }

    public BSTNode find(int value){
        if(this.value == value){
            return this;
        }
        if(this.value < value) {
            return left != null ? left.find(value) : null;
        }
        return right != null ? right.find(value) : null;
    }

    public BSTNode remove(int value){
        return null;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.value);
    } 
}
