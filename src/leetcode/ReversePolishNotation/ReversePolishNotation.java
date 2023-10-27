package leetcode.ReversePolishNotation;//Evaluate Reverse Polish Notation The problem:
//        Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//        Valid operators are +, -, *, /. Each operand may be an integer or another
//        expression.
//        Some examples:
//        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6


import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        var stack = new Stack<Integer>();

        for (var token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    var subtractor = stack.pop();
                    stack.push(stack.pop() - subtractor);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    var divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        var calculator = new ReversePolishNotation();

        var example1 = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(calculator.evalRPN(example1));  // Output: 9

        var example2 = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(calculator.evalRPN(example2));  // Output: 6
    }
}
