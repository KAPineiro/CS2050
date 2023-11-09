// Kyle Pineiro
//Assignment #2 -Create methods for math functions 
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Program2 {

    // TODO #1: finish the method's implementation
    public static double add(double a, double b)
    {
        return a + b;
    }

    // TODO #2: finish the method's implementation
    public static double subtract(double a, double b)
    {
        return a - b;
    }

    // TODO #3: finish the method's implementation
    public static double multiply(double a, double b)
    {
        if (a == 0|| b == 0)
        {
            return 0;
        }
        return a * b;
    }

    // TODO #4: finish the method's implementation
    public static double divide(double a, double b) {
       if (b==0)
       {throw new ArithmeticException("Cannot divide by zero.");
       }
        return a / b;
    }
    // TODO #5: finish the method's implementation - assume right triangle
    public static double sinOfAngle(double oppSide, double hyp) {
        if (hyp == 0) {
            throw new ArithmeticException("Hyp cannot be zero.");
        }
        double result = oppSide / hyp;
        BigDecimal bd = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
       double newResult = bd.doubleValue();
       return newResult;

    }
        // TODO #6: finish the method's implementation - assume right triangle
    public static double hypOfTriangle(double sideA, double sideB)
    {
        double result= Math.sqrt(sideA * sideA + sideB * sideB);
        BigDecimal bd = new BigDecimal(result).setScale(2,RoundingMode.HALF_UP);
        double newResult = bd.doubleValue();
        return newResult;
    }


    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String yN;
        System.out.println("Welcome to the online math calculator!");
        do {
            System.out.println("What would you like to use the calculator for?");
            System.out.println("1.Add");
            System.out.println("2.Subtract");
            System.out.println("3.Multiply");
            System.out.println("4.Divide");
            System.out.println("5.Sin (Right Triangle)");
            System.out.println("6.Hypotenuse (Right Triangle)");
            String answer = s.nextLine();
            while (!answer.equalsIgnoreCase("add") && !answer.equalsIgnoreCase("subtract")
                    && !answer.equalsIgnoreCase("multiply") && !answer.equalsIgnoreCase("divide")
                    && !answer.equalsIgnoreCase("sin") && !answer.equalsIgnoreCase("hypotenuse")) {
                System.out.println("Invalid input. Enter one of the given options");
                System.out.println("1.Add");
                System.out.println("2.Subtract");
                System.out.println("3.Multiply");
                System.out.println("4.Divide");
                System.out.println("5.Sin");
                System.out.println("6.Hypotenuse");
                answer = s.nextLine();
            }
            if (answer.equalsIgnoreCase("add")) {
                System.out.println("You chose add.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double addition = add(a, b);
                System.out.println("Your answer is: " + addition + ".");
            }
            if (answer.equalsIgnoreCase("subtract")) {
                System.out.println("You chose subtract.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double subtraction = subtract(a, b);
                System.out.println("Your answer is: " + subtraction + ".");
            }
            if (answer.equalsIgnoreCase("multiply")) {
                System.out.println("You chose multiply.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double multiplication = multiply(a, b);
                System.out.println("Your answer is: " + multiplication + ".");
            }
            if (answer.equalsIgnoreCase("divide")) {
                System.out.println("You chose division.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double division = divide(a, b);
                System.out.println("Your answer is: " + division + ".");
            }
            if (answer.equalsIgnoreCase("Sin")) {
                System.out.println("You chose sin.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double sin = sinOfAngle(a, b);
                System.out.println("Your answer is: " + sin + ".");
            }
            if (answer.equalsIgnoreCase("Hypotenuse")) {
                System.out.println("You chose hypotenuse.");
                System.out.println("Enter your first number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double a = s.nextDouble();
                System.out.println("Enter your second number.");
                while (!s.hasNextDouble()) {
                    System.out.println("Invalid input. Enter a valid number.");
                    s.nextLine();
                }
                double b = s.nextDouble();
                double hyp = hypOfTriangle(a, b);
                System.out.println("Your answer is: " + hyp + ".");
            }
            System.out.println("Would you like to run the calculator again?");
            Scanner s2= new Scanner(System.in);
            yN = s2.nextLine();
            while (!yN.equalsIgnoreCase("yes") && !yN.equalsIgnoreCase("no")){
                System.out.println("Invalid input. Enter 'yes' or 'no',");
                yN = s2.nextLine();
            }
        }while(yN.equalsIgnoreCase("yes"));
        if(yN.equalsIgnoreCase("no"))
        {
            System.exit(0);
        }
    }
}


