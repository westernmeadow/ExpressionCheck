//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Checks if Expression class works properly. 
//
public class ExpressionCheck
{
    public static void main(String[] args)
    {   
        System.out.println("Case 1:");
        System.out.println("Infix expression: a + 10 / b");
        System.out.println("Variables: a = 5, b = 10");
        String[] infix = "a + 10 / b".split(" ");
        
        BagInterface<Name> names = new ArrayBag<>(); 
        names.add(new Name("a", 5));
        names.add(new Name("b", 10));
 
        System.out.println("Converting to from infix to postfix...");
        String[] postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: a10b/+");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        int result = Expression.evaluatePostfix(postfix, names);
        System.out.println("Expected result: 6");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 2:");
        System.out.println("Infix expression: x + y + z");
        System.out.println("Variables: x = 1, y = 2, z = 3");
        infix = "x + y + z".split(" ");
        
        names = new ArrayBag<>();
        names.add(new Name("x", 1));
        names.add(new Name("y", 2));
        names.add(new Name("z", 3));
 
        System.out.println("Converting to from infix to postfix...");
        postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: xy+z+");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        result = Expression.evaluatePostfix(postfix, names);
        System.out.println("Expected result: 6");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 3:");
        System.out.println("Infix expression: ( m + n ) * ( r - s )");
        System.out.println("Variables: m = 8, n = -3, r = 12, s = 10");
        infix = "( m + n ) * ( r - s )".split(" ");
        
        names = new ArrayBag<>();
        names.add(new Name("m", 8));
        names.add(new Name("n", -3));
        names.add(new Name("r", 12));
        names.add(new Name("s", 10));
 
        System.out.println("Converting to from infix to postfix...");
        postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: mn+rs-*");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        result = Expression.evaluatePostfix(postfix, names);
        System.out.println("Expected result: 10");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 4:");
        System.out.println("Infix expression: alpha + beta ^ ( gamma - 1 )");
        System.out.println("Variables: alpha = 1, beta = 2, gamma = 3");
        infix = "alpha + beta ^ ( gamma - 1 )".split(" ");
 
        names = new ArrayBag<>();
        names.add(new Name("alpha", 1));
        names.add(new Name("beta", 2));
        names.add(new Name("gamma", 3));
        
        System.out.println("Converting to from infix to postfix...");
        postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: alphabetagamma1-^+");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        result = Expression.evaluatePostfix(postfix, names);
        System.out.println("Expected result: 5");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 5:");
        System.out.println("Infix expression: a ^ ( b - c");
        System.out.println("Variables: a = 7, b = 4, c = 2");
        infix = "a ^ ( b - c".split(" ");
 
        names = new ArrayBag<>();
        names.add(new Name("a", 7));
        names.add(new Name("b", 4));
        names.add(new Name("c", 2));
        
        System.out.println("Converting to from infix to postfix...");
        try
        {
            postfix = Expression.convertToPostfix(infix);
        }
        catch (RuntimeException e)
        {
            System.out.println("RuntimeException: " + e.getMessage());
            System.out.println();
            System.out.println("New infix expression: a ^ ( b - c )");
            System.out.println("Variables: a = 7, b = 4, c = 2");
            infix = "a ^ ( b - c )".split(" ");
            
            System.out.println("Converting to from infix to postfix...");
            postfix = Expression.convertToPostfix(infix);
        }
 
        System.out.println("Expected result: abc-^");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        result = Expression.evaluatePostfix(postfix, names);
        System.out.println("Expected result: 49");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 6:");
        System.out.println("Infix expression: a / * c");
        System.out.println("Variables: a = 12, b = 6, c = 0");
        infix = "a / * c".split(" ");
        
        names = new ArrayBag<>();
        names.add(new Name("a", 12));
        names.add(new Name("b", 6));
        names.add(new Name("c", 0));
 
        System.out.println("Converting to from infix to postfix...");
        postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: ab/c*");
        System.out.println("Actual result: " + String.join("", postfix));
                 
        System.out.println("Evaluating the postfix expression...");
        try
        {
            result = Expression.evaluatePostfix(postfix, names);
        }
        catch (RuntimeException e)
        {
            System.out.println("RuntimeException: " + e.getMessage());
            System.out.println();
            System.out.println("New infix expression: a / b * c");
            System.out.println("Variables: a = 12, b = 6, c = 0");
            infix = "a / b * c".split(" ");
            
            System.out.println("Converting to from infix to postfix...");
            postfix = Expression.convertToPostfix(infix);
            System.out.println("Expected result: ab/c*");
            System.out.println("Actual result: " + String.join("", postfix));
        
            System.out.println("Evaluating the postfix expression...");
            result = Expression.evaluatePostfix(postfix, names);
        }
        
        System.out.println("Expected result: 0");
        System.out.println("Actual result: " + result);
        System.out.println();
        
        System.out.println("Case 7:");
        System.out.println("Infix expression: a + b");
        System.out.println("Variables: a = 24 (b not provided)");
        infix = "a + b".split(" ");
        
        names = new ArrayBag<>();
        names.add(new Name("a", 24));
 
        System.out.println("Converting to from infix to postfix...");
        postfix = Expression.convertToPostfix(infix);
        System.out.println("Expected result: ab+");
        System.out.println("Actual result: " + String.join("", postfix));
        
        System.out.println("Evaluating the postfix expression...");
        try
        {
            result = Expression.evaluatePostfix(postfix, names);
        }
        catch (RuntimeException e)
        {
            System.out.println("RuntimeException: " + e.getMessage());
            System.out.println();
            System.out.println("New variables: a = 24, b = 36");
            names.add(new Name("b", 36));
            
            System.out.println("Evaluating the postfix expression...");
            result = Expression.evaluatePostfix(postfix, names);
        }
        
        System.out.println("Expected result: 60");
        System.out.println("Actual result: " + result);
    }
}