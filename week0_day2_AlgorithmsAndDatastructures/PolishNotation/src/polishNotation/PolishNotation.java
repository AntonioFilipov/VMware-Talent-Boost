package polishNotation;

import java.util.Stack;

public class PolishNotation {

    public static double calculate(String prefix){
        Stack<Double> stack = new  Stack<Double>();
        double result = 0;
        for (int i = prefix.length()-1; i >= 0; i--) {
            char symbol = prefix.charAt(i);
            if (Character.isDigit(prefix.charAt(i))) {
                stack.push((double) Character.getNumericValue(symbol));
            }else{
                double firstOperand = (double) stack.pop();
                double secondOperand = (double) stack.pop();
                switch (symbol) {
                    case '+':
                        result = firstOperand+secondOperand;
                        break;
                    case '-':
                        result = firstOperand-secondOperand;
                        break;
                    case '*':
                        result = firstOperand*secondOperand;
                        break;
                    case '/':
                        result = firstOperand/secondOperand;
                        break;
                    case '%':
                        result = firstOperand%secondOperand;
                        break;
                    default:
                        break;
                }
                
                stack.push(result);
            }
        }
        
        return (double) stack.pop();
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input = "*+35-72";
        double result = calculate(input);
        System.out.println("Result:" +result);
    }

}
