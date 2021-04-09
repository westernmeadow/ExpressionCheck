//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Contains methods to convert and evaluate expressions.
//
public class Expression
{
    /**
     * Converts a given infix expression to a postfix expression using a stack.
     * @param infixExpression   the expression to be converted into postfix
     * @return                  the converted postfix expression
     * @throws RuntimeException if the infix expression is not well formed
     */
    public static String[] convertToPostfix(String[] infixExpression)
    {
        if (!checkBalance(infixExpression))
            throw new RuntimeException("Infix expression is not well formed.");
        StackInterface<String> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();
        String nextToken = "";
        String topOperator = "";
        
        for (int index = 0; index < infixExpression.length; index++)
        {
            nextToken = infixExpression[index];
            
            switch (nextToken)
            {
                case "^":
                    operatorStack.push(nextToken);
                    break;
                case "+": case "-": case "*": case "/":
                    while (!operatorStack.isEmpty() && 
                           isLowerPrecedence(nextToken.charAt(0),
                                             operatorStack.peek().charAt(0)))
                           postfix.append(operatorStack.pop()).append(" ");
                    operatorStack.push(nextToken);
                    break;
                case "(":
                    operatorStack.push(nextToken);
                    break;
                case ")":
                    topOperator = operatorStack.pop();
                    while (!topOperator.equals("("))
                    {
                        postfix.append(topOperator).append(" ");
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    postfix.append(nextToken).append(" ");
                    break;
            }
        }
        
        while (!operatorStack.isEmpty())
            postfix.append(operatorStack.pop()).append(" ");
        
        return postfix.toString().split(" ");
    }
    /**
     * Evaluates a given postfix expression using a stack.
     * @param postfixExpression the postfix expression to be evaluated
     * @param nameBag           a bag of Names (the variables in the expression)
     * @return                  the value of the postfix expression
     * @throws RuntimeException if the postfix expression is not well formed
     *                          or a name is not found in nameBag
     */
    public static int evaluatePostfix(String[] postfixExpression, BagInterface<Name> nameBag)
    {
        Name[] variableNames = convertToNameArray(nameBag);
        StackInterface<Integer> valueStack = new LinkedStack<>();
        String nextToken = "";
        Integer operandOne;
        Integer operandTwo;
        
        for (int index = 0; index < postfixExpression.length; index++)
        {
            nextToken = postfixExpression[index];
            
            switch (nextToken)
            {   
                case "+": case "-": case "*": case "/": case "^":
                    try
                    {
                        operandTwo = valueStack.pop();
                        operandOne = valueStack.pop();
                    }
                    catch (RuntimeException e)
                    {
                        throw new RuntimeException("Postfix expression is not well formed.");
                    }
                    valueStack.push(calculate(operandOne, operandTwo, nextToken));
                    break;
                default:
                    try
                    {
                        valueStack.push(Integer.parseInt(nextToken));
                    }
                    catch (NumberFormatException e)
                    {
                        int nameIndex = lookup(nextToken, variableNames);
                        if (nameIndex == -1)
                            throw new RuntimeException("Name not found.");
                        valueStack.push(variableNames[nameIndex].getValue());
                    }
                    break;
            }
        }
       
        return valueStack.pop();
    }
    
    private static boolean checkBalance(String[] expression)
    {
        StackInterface<Character> openDelimiterStack = new LinkedStack<>();
        int characterCount = expression.length;
        boolean isBalanced = true;
        int index = 0;
        char nextToken = ' ';
        
        while (isBalanced && (index < characterCount))
        {
            nextToken = expression[index].charAt(0);
            switch (nextToken)
            {
                case '(': case'[': case '{':
                    openDelimiterStack.push(nextToken);
                    break;             
                case ')': case']': case '}':
                    if(openDelimiterStack.isEmpty())
                        isBalanced = false;
                    else
                    {
                        char openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextToken);
                    }
                    break;
                default:
                    break;
            }
            index++;
        }
        
        if(!openDelimiterStack.isEmpty())
            isBalanced = false;
            
        return isBalanced;
    }
    
    private static boolean isPaired(char open, char close)
    {
        return (open == '('&& close == ')') ||
               (open == '['&& close == ']') ||
               (open == '{'&& close == '}');
    }
    
    private static boolean isLowerPrecedence(char next, char top)
    {
        if ((next == '+' || next == '-') && top != '(')
            return true;
        else if ((next == '*' || next == '/') && 
                (top == '*' || top == '/' || top == '^'))
            return true;
        else
            return false;
    }
    
    private static int calculate(int left, int right, String operator)
    {
        if (operator.equals("+"))
            return left + right;
        else if (operator.equals("-"))
            return left - right;
        else if (operator.equals("*"))
            return left * right;
        else if (operator.equals("/"))
            return left / right;
        else
            return (int)Math.pow(left, right);
    }
    
    private static Name[] convertToNameArray(BagInterface<Name> namebag)
    {
        Object[] temp = namebag.toArray();
        Name[] variableNames = new Name[temp.length];
        
        for (int index = 0; index < temp.length; index++)
            variableNames[index] = (Name)temp[index];
            
        return variableNames;
    }
    
    private static int lookup(String name, Name[] variableNames)
    {
        boolean isFound = false;
        int index = 0;
        
        while (!isFound && (index < variableNames.length))
            isFound = (variableNames[index++].getName().equals(name));
        index--;
            
        if (!isFound)
            index = -1;
        
        return index;
    }
}
