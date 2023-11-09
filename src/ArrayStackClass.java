//Kyle Pineiro
//Assignment 3
import java.util.EmptyStackException;
class ArrayStackClass
{
    final private char[] stack;
    private int top;
    final private int capacity;

    public ArrayStackClass(int N)
    {
        this.capacity = N;
        this.stack = new char[N];
        this.top = -1;
    }

    public void push(char item)
    {
        if (top == capacity - 1)
        {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = item;
    }

    public char pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    public char peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public int size()
    {
        return top + 1;
    }
}

