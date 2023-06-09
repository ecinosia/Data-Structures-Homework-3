import java.util.ArrayList;

class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }
    
    void insert(int key) {
        root = insertRec(root, key);
    }
    
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        
        return root;
    }

   

    ArrayList<Integer> preorder() {
        ArrayList<Integer> result = new ArrayList<>();
        preorderRec(root, result);
        return result;
    }

    void preorderRec(Node root, ArrayList<Integer> result) {
        if (root != null) {
            result.add(root.key);
            preorderRec(root.left, result);
            preorderRec(root.right, result);
        }
    }
}



public class QuestionOne {
    
    
        
            
}
