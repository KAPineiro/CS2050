//Kyle Pineiro
//Assignment 8
import java.io.FileWriter;
import java.io.IOException;
public class BSTtree
{
    private Node root;

        //Creating constructor for the BST, having the root set to null
        public BSTtree()
        {
            root = null;
        }
        //Inserting a new word into the BST
        public void insert(String word)
        {
            root = newInsert(root, word.toLowerCase());
        }
        private Node newInsert(Node current, String word)
        {
            //Only adding words to BST if not already add(Used for duplicates)
            if(current == null)
            {
                return new Node(word);
            }
            int comparison = word.compareTo(current.word);
            //If word is alphabetically before root got to left
            if(comparison < 0)
            {
                current.left = newInsert(current.left, word);
            }
            //If word is alphabetically after root go to right
            if(comparison > 0)
            {
                current.right = newInsert(current.right, word);
            }
            return current;
        }
        //counting the amount of nodes in tree
        public int countNodes(Node node)
        {
            if (node == null)
            {
                return 0;
            }
            return 1 + countNodes(node.left) + countNodes((node.right));
        }
        //Finding the max height for both left and right subtrees then adding 1 for the root
        //to find the maximum height of the tree
        public int getHeight(Node node)
        {
            if(node == null)
            {
                return -1;
            }
            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
       //This is the method that writes the information in the file
        public void analyzeDracula(String analysis) throws IOException
       {
           int nodeCount = countNodes(root);
           int height = getHeight(root);
           long getMaxNodes = (long) Math.pow(2, height ) -1 ;

           try(FileWriter fw = new FileWriter("analysis.txt"))
           {
               fw.write("Kyle Pineiro \n");
               fw.write("The number of nodes is " + nodeCount + "\n");
               fw.write("The height of the BST is " + height + "\n");
               fw.write("The max nodes in the BST is " + getMaxNodes + "\n");
           }
       }
    //This class is used to create the nodes in the BST tree
    static class Node
    {
        String word;
        Node left;
        Node right;

        public Node(String word)
        {
            this.word = word;
            this.left = null;
            this.right = null;
        }
    }
    }



