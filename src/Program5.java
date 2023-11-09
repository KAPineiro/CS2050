//Kyle Pineiro
//Assignment 5
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;
public class Program5
{
    public static String infixToPostfix(String s)
    {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean isDecimal = false;
        int openParenCount = 0;
        int closeParenCount = 0;

        for (char c : s.toCharArray())
        {
            if (Character.isDigit(c) || (c == '.' && !isDecimal))
            {
                    postfix.append(c);
                    if (c == '.')
                    {
                        isDecimal = true;
                    }
                }
            else if (c == '(')
                {
                    stack.push(c);
                    openParenCount++;
                }
            else if (c == ')')
                {
                    closeParenCount++;
                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        postfix.append(" ").append(stack.pop());
                    }
                    if (!stack.isEmpty() && stack.peek() == '(')
                    {
                        stack.pop();
                    }
                }
            else if (isOperator(c))
                {
                    while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    {
                        postfix.append(" ").append(stack.pop());
                    }
                    stack.push(c);
                    postfix.append(" ");
                    isDecimal = false;
                } else if (c == '@') {
                    return "Invalid character: @";
                }
            }

        while (!stack.isEmpty())
        {
                postfix.append(" ").append(stack.pop());
        }

            if (openParenCount != closeParenCount)
            {
                return "unmatched parens";
            }

            return postfix.toString().trim();
        }
        public static boolean isOperator(char c)
        {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        public static int precedence(char op)
        {
            if (op == '+' || op == '-')
            {
                return 1;
            }
            else if (op == '*' || op == '/')
            {
                return 2;
            }
            return 0;
        }

        public static void main(String[] args)
        {try
        {
            BufferedReader br = new BufferedReader(new FileReader("Program5.txt"));
            br.readLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter("Program5.out"));

            String line;
            while ((line = br.readLine()) != null)
            {
                    String infix = line.trim();
                    Stack<Character> stack = new Stack<>();
                    String postfix = infixToPostfix(infix);

                    StringBuilder spacedInfix = new StringBuilder();
                for (char c : infix.toCharArray())
                {
                    spacedInfix.append(c).append(" ");
                }

                StringBuilder spacedPostfix = new StringBuilder();
                for (char c : postfix.toCharArray())
                {
                    spacedPostfix.append(c).append(" ");
                }

                bw.write(spacedInfix.toString() + "-> " + spacedPostfix.toString());
                bw.newLine();
            }

                br.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


