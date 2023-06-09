//TAHIR FURKAN SARIDIKEN
//200316004
//DATA STRUCTURES HOMEWORK
//COMPUTER ENGINEERING 
//SECOND GRADE

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        //Creating the tree for operations using BinarySearchTree function from QuestionOne.java file.
        BinarySearchTree tree = new BinarySearchTree();

        //Inserting roots of the tree.
        tree.insert(70);
        tree.insert(45);
        tree.insert(87);
        tree.insert(32);
        tree.insert(56);
        tree.insert(77);
        tree.insert(92);
        tree.insert(21);
        tree.insert(40);
        tree.insert(46);
        tree.insert(68);
        tree.insert(73);
        tree.insert(80);
        tree.insert(89);
        tree.insert(99);
        tree.insert(13);
        tree.insert(27);
        tree.insert(79);
        tree.insert(82);

        //Calling the preorder function and hold it in ArrayList named preorderArray.
        ArrayList<Integer> preorderArray = tree.preorder();

        //We convert the preorderArray ArrayList to an Array and convert it to String to print it.
        System.out.println("Preorder Output: " + Arrays.toString(preorderArray.toArray()) + "\n");
        
        //Initiliaze the keys for the Lowest Common Ancestor operation.
        int key1 = 27;
        int key2 = 46;
        int key3 = 77;
        int key4 = 13;
        //Use keys for inputs and call the findLowestCommonAncestor function. 
        //Lowest common ancestors are nodes. With this we can easily print it out in the next lines.
        Node lowestCommonAncestor = tree.findLowestCommonAncestor(key1, key2);
        Node lowestCommonAncestor2 = tree.findLowestCommonAncestor(key3, key4);
        //If the function finds the lowest common ancestor it will be printed with this.
        if (lowestCommonAncestor != null) {
            System.out.println("Lowest Common Ancestor of " + key1 + " and " + key2 + ": " + lowestCommonAncestor.key + "\n");
        } else { // If not not found error will be printed.
            System.out.println("Lowest Common Ancestor not found.");
        }

        if (lowestCommonAncestor != null) {
            System.out.println("Lowest Common Ancestor of " + key3 + " and " + key4 + ": " + lowestCommonAncestor2.key + "\n");
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
        //Initialize to key to delete
        int keyToDelete = 32;
        //Call the delete function to delete specific node.
        tree.delete(keyToDelete);
        //Printing the key which deleted.
        System.out.println("Node with key " + keyToDelete + " deleted.\n");

        //Printing the preorder traversal after deleting the node.
        ArrayList<Integer> preorderArray2 = tree.preorder();
        System.out.println("New Preorder Output: " + Arrays.toString(preorderArray2.toArray()) + "\n");

        //We create an ArrayList named levelOrderArray to hold levelOrdered tree.
        //And we call the levelOrder function for this.
        ArrayList<Integer> levelOrderArray = tree.levelOrder();
        //Printing the Level Order Traversal Output with same steps as we did in PreOrder Traversal Output.
        System.out.println("Level Order Traversal Output: " + Arrays.toString(levelOrderArray.toArray()));
    }
}
