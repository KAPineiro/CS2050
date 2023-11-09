//Kyle Pineiro
//Assignment 8
import java.io. BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Program8
{
    public static void main(String[] args)
    {
        //Calling BSTtree class
        BSTtree BST = new BSTtree();
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader("dracula.txt"));
            String line;
            while ((line = bf.readLine()) != null)
            {
                //Splits all the words after blank space
                String[] words = line.split("[^a-zA-Z']+");
                for(String word : words)
                {
                    word = word.toLowerCase(); //Has all words go to lowercase
                    if(!word.isEmpty() && !word.matches(".*\\d+.*"))
                    {
                        BST.insert(word);
                    }
                }
            }
            bf.close();
        }catch(IOException e)
        {
            System.out.println("Error reading the file!");
            e.printStackTrace();
        }
        try
        {
            BST.analyzeDracula("analysis.txt");
        }catch(IOException e)
        {
            System.out.println("Error writing the file!");
            e.printStackTrace();
        }

    }
}