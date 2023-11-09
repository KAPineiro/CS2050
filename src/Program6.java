//Kyle Pineiro
//Assignment 6
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
public class Program6
{
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (arr[i - 1] > arr[i])
                {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    public static void bubbleSort(String[] arr)
    {
        int n = arr.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 1; i < n; i++)
            {
                if (arr[i - 1].compareTo(arr[i]) > 0)
                {
                    String temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
    public static void selectionSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void selectionSort(String[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
        {
            int minIndex = i;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[j].compareTo(arr[minIndex]) < 0)
                {
                    minIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args)
    {
        try
        {
            int[] bubbleSortArray = new int[20000];
            int[] selectionSortArray = new int[20000];
            ArrayList<Integer> arrayListInt = new ArrayList<>();

            BufferedReader br = new BufferedReader(new FileReader("NumbersInFile.txt"));
            String line;
            int index = 0;
            while ((line = br.readLine()) != null && index < 20000)
            {
                int number = Integer.parseInt(line);
                bubbleSortArray[index] = number;
                selectionSortArray[index] = number;
                arrayListInt.add(number);
                index++;
            }
            br.close();

            long startTimeBubble = System.nanoTime();
            bubbleSort(bubbleSortArray);
            long endTimeBubble = System.nanoTime();
            long bubbleSortTime = endTimeBubble - startTimeBubble;

            long startTimeSelection = System.nanoTime();
            selectionSort(selectionSortArray);
            long endTimeSelection = System.nanoTime();
            long selectionSortTime = endTimeSelection - startTimeSelection;

            String[] bubbleSortStringArray = new String[10000];
            String[] selectionSortStringArray = new String[10000];
            ArrayList<String> arrayListString = new ArrayList<>();

            br = new BufferedReader(new FileReader("StringsInFIle"));
            index = 0;
            while ((line = br.readLine()) != null && index < 10000)
            {
                String str = line;
                bubbleSortStringArray[index] = str;
                selectionSortStringArray[index] = str;
                arrayListString.add(str);
                index++;
            }
            br.close();

            long startTimeBubbleString = System.nanoTime();
            bubbleSort(bubbleSortStringArray);
            long endTimeBubbleString = System.nanoTime();
            long bubbleSortTimeString = endTimeBubbleString - startTimeBubbleString;

            long startTimeSelectionString = System.nanoTime();
            selectionSort(selectionSortStringArray);
            long endTimeSelectionString = System.nanoTime();
            long selectionSortTimeString = endTimeSelectionString - startTimeSelectionString;

            long startTimeCollectionSort = System.nanoTime();
            Collections.sort(arrayListString);
            long endTimeCollectionSort = System.nanoTime();
            long collectionSortTime = endTimeCollectionSort - startTimeCollectionSort;

            FileWriter fw = new FileWriter("results.txt");
            fw.write("Name: Kyle Pineiro\n");
            fw.write("Number of Integers: " + arrayListInt.size() + "\n");
            fw.write("Bubble Sort (Integer): " + bubbleSortTime + " nanoseconds\n");
            fw.write("Selection Sort (Integer): " + selectionSortTime + " nanoseconds\n");
            fw.write("Number of Strings: " + arrayListString.size() + "\n");
            fw.write("Bubble Sort (String): " + bubbleSortTimeString + " nanoseconds\n");
            fw.write("Selection Sort (String): " + selectionSortTimeString + " nanoseconds\n");
            fw.write("Collection Sort (String ArrayList): " + collectionSortTime + " nanoseconds\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
