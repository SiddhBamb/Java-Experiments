import java.util.*;
import java.io.*;

public class TruthTable
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter logical sentences to be used, followed by a dot (.):");
        ArrayList<String> sentences = new ArrayList<String>();
        ArrayList<String> premises = new ArrayList<String>();
        while(true)
        {
            String s = scan.next();
            if(s.equals("."))
                break;
            sentences.add(s.toUpperCase());
        }
        System.out.println("Logical Operators:\nor = v, |, +\nand = ^, &, *\nnot = !, ~\nif = >\niff = =\nparentheses = (, )");
        System.out.println("Enter premises (with no spaces within a premise), followed by a dot (.):");
        while(true)
        {
            String p = scan.next();
            if(p.equals("."))
                break;
            premises.add(p.toUpperCase());
        }
        System.out.println(sentences);
        System.out.println(premises);
        System.out.println("Enter the conclusion (with no spaces within it):");
        String conclusion = scan.next();

        
    }

    public static evaluateExpression(String exp, HashMap<String, Boolean> vals)
    {
        for(String s : vals.keySet())
        {
            exp.replace(s, (((vals.get(s)) ? "T" : "F")));
        }
        char[] tokens = expression.toCharArray();
 
        Stack<Character> values = new Stack<Character>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {   
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= 'A' && tokens[i] <= 'Z')
                values.push(tokens[i++]);
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
            else if (tokens[i] == 'v' || tokens[i] == '|' || tokens[i] == '^' || tokens[i] == '&' || tokens[i] == '+' || tokens[i] == '*' ||  tokens[i] == '>' || tokens[i] == '=')
            {
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.push(tokens[i]);
            }
        }
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '!' || op1 == '~') && (op2 == 'v' || op2 == '^' || op2 == '|' || op2 == '&' || op2 == '+' || op2 == '*' || op2 == '=' || op2 == '>'))
            return false;
        if((op1 == '^' || op1 == '&' || op1 == '*') && !(op2 == '!' || op2 == '~'))
            return false;
        if((op1 == 'v' || op1 == '|' || op1 == '+') && (op2 == '>' || op2 == '='))
            return false;
        else
            return true;
    }

    public static int applyOp(char op,
                           boolean a, boolean b)
    {
        if(op == '!' || op == '~')
        {
            return 
        }
        if(op == '^' || op == '&' || op == '*')
            return a && b;
        else if(op == 'v' || op == '|' || op == '+')
            return a || b;
        else if(op == '>')
        {
            if(a == true && b == true)
                return true;
            else if (a == true && b == false)
                return false;
            else if (a == false && b == true)
                return true;
            else if (a == false && b == false)
                return true;
        }
        else if(op == '=')
        {
            if(a == true && b == true)
                return true;
            else if (a == true && b == false)
                return false;
            else if (a == false && b == true)
                return false;
            else if (a == false && b == false)
                return true;
        }
        return true;
    }
} 