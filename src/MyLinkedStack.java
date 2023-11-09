//Kyle Pineiro
//Assignment 4
class MyLinkedStack
{
    private Node top;
    private int size;
   final private int maxSize;

    public MyLinkedStack(int N)
    {
        this.maxSize = N;
        this.size = 0;
        this.top = null;
    }

    public void push(char data)
    {
        if (isFull())
        {
            System.out.println("Stack is full. Cannot push " + data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public char pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty. Cannot pop.");
            return '0';
        }

        char data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public char peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty. Cannot peek.");
            return '0';
        }
        return top.data;
    }

    public boolean empty()
    {
        return isEmpty();
    }

    public int size()
    {
        return size;
    }

    public boolean isFull()
    {
        return size == maxSize;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private static class Node
    {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
}

