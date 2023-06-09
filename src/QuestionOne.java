//TAHIR FURKAN SARIDIKEN
//200316004
//DATA STRUCTURES HOMEWORK
//COMPUTER ENGINEERING 
//SECOND GRADE

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


        //Creating the Node class to create our binary search tree.
        class Node {
            int key;
            Node left, right;
            
            public Node(int item) {
                key = item;
                left = right = null;
            }
        }
        //Creating BinarySearchTree class.
        class BinarySearchTree {
            //Create the root with using Node class.
            Node root;
    
            //Initiliaze the root as null.
            BinarySearchTree() {
                root = null;
            }
            
            //Creating insert function to create our binary search tree with user input.
            void insert(int key) {
                root = insertRec(root, key);
            }
            
            //Check the roots and create Nodes for the tree.
            Node insertRec(Node root, int key) {
                if (root == null) {
                    root = new Node(key);
                    return root;
                }
                //Compare the values and put the Nodes in to their places recording to that comparing.
                if (key < root.key)
                    root.left = insertRec(root.left, key);
                else if (key > root.key)
                    root.right = insertRec(root.right, key);
                
                return root;
            }
    
        
            //Creating an ArrayList to insert PreOrdered tree.
            ArrayList<Integer> preorder() {
                ArrayList<Integer> result = new ArrayList<>();
                preorderRec(root, result);
                return result;
            }
    
            //Creating this function for Preorder Traversal.
            void preorderRec(Node root, ArrayList<Integer> result) {
                //If statement check if the root is null or not.
                //The preorderRec method recursively traverses the tree in the order of root, left subtree, right subtree.
                if (root != null) {
                    result.add(root.key);
                    preorderRec(root.left, result);
                    preorderRec(root.right, result);
                }
            }
    
            //This method takes two keys key1 and key2 as input and finds the lowest common ancestor of the nodes with those keys.
            //It recursively traverses the tree by comparing the keys with the
            //root node and moves left or right accordingly until it finds the lowest common ancestor.
            Node findLowestCommonAncestor(int key1, int key2) {
                return findLowestCommonAncestor(root, key1, key2);
            }
        
            Node findLowestCommonAncestor(Node root, int key1, int key2) {
                if (root == null)
                    return null;
        
                if (root.key > key1 && root.key > key2)
                    return findLowestCommonAncestor(root.left, key1, key2);
                else if (root.key < key1 && root.key < key2)
                    return findLowestCommonAncestor(root.right, key1, key2);
                else
                    return root;
            }
    
            //This method takes key as input and delete it with the help of deleteRec function.
            void delete(int key) {
                root = deleteRec(root, key);
            }
            //It recursively traverses the tree to find the node to delete. Once the node is found, it handles three cases:
            Node deleteRec(Node root, int key) {
                //Wanted root is empty.
                if (root == null)
                    return root;
                //If the node to delete has no children, it simply removes the node.
                //If the node to delete has one child, it replaces the node with its child.
                if (key < root.key)
                    root.left = deleteRec(root.left, key);
                else if (key > root.key)
                    root.right = deleteRec(root.right, key);
                else {
                    // Node to delete found
                    if (root.left == null)
                        return root.right;
                    else if (root.right == null)
                        return root.left;
        
                    // Node to delete has two children
                    root.key = minValue(root.right);
                    root.right = deleteRec(root.right, root.key);
                }
        
                return root;
            }
        
            //We use this function to handle third case.
            int minValue(Node root) {
                int minValue = root.key;
                while (root.left != null) {
                    minValue = root.left.key;
                    root = root.left;
                }
                return minValue;
            }
    
            //This method performs a level order traversal of the tree and returns the result as an ArrayList<Integer>.
            ArrayList<Integer> levelOrder() {
                ArrayList<Integer> result = new ArrayList<>();
                if (root == null)
                    return result;
                //It uses a Queue to keep track of the nodes at each level.
                Queue<Node> queue = new LinkedList<>();
                queue.add(root);
                //The key of each visited node is added to the result list.
                while (!queue.isEmpty()) {
                    Node node = queue.poll();
                    result.add(node.key);
        
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
        
                return result;
            }
        }
                

