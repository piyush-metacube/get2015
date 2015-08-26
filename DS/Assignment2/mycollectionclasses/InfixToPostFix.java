package mycollectionclasses;


//class to convert infix to postfix
public class InfixToPostFix {
    // will check whether its an operator or not
    private boolean isOperator(char c) {
	if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
	    return true;
	return false;
    }

    // will check whether character c1 is having higher precedence than c2
    private boolean checkPrecedence(char c1, char c2) {
	if ((c2 == '+' || c2 == '-') && (c1 == '+' || c1 == '-')) {
	    return true;
	} else if ((c2 == '*' || c2 == '/') && (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/')) {
	    return true;
	} else if ((c2 == '^') && (c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/')) {
	    return true;
	} else {
	    return false;
	}
    }

    // method to convert infix to postfix
    public String convertToPostfix(String infix) {
	String postfix = "";
	Stack stack = new Stack();// stack to hold symbols
	stack.push('#');// symbol to denote end of stack

	for (int i = 0; i < infix.length(); i++) {
	    // symbol to be processed
	    char inputSymbol = infix.charAt(i);
	    if (isOperator(inputSymbol)) {
		while (checkPrecedence(inputSymbol, (char) stack.peek())) {
		    postfix += stack.pop();
		}
		stack.push(inputSymbol);
	    } else if (inputSymbol == '(') {
		stack.push(inputSymbol);// push if left parenthesis
	    } else if (inputSymbol == ')') {
		while ((char) stack.peek() != '(') { // repeatedly pops if right parenthesis until left parenthesis is found
		    postfix += stack.pop();
		}
		stack.pop();
	    } else {
		postfix += inputSymbol;
	    }
	}
	// pops all elements of stack left
	while ((char) stack.peek() != '#')// peek
	{
	    postfix += stack.pop();
	}
	return postfix;
    }
}