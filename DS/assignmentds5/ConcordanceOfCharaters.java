package assignmentds5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Assignment 1
 * Write a program which create a concordance of characters occurring
 * in a string (i.e which characters occur where in a string).
 * Read the string from the command line.
 * Example:  java Concordance Hello World
 * {d=[9], o=[4, 6], r=[7], W=[5], H=[0], l=[2, 3, 8], e=[1]}
 */

public class ConcordanceOfCharaters {
    // it will find location of charaters in the given string
    public Map<Character, Set<Integer>> checkString(String[] argStrings) {
	Map<Character, Set<Integer>> concordanceMap = new HashMap<Character, Set<Integer>>();
	String input = convertToString(argStrings);

	for (int i = 0; i < input.length(); i++) {
	    char charAtPos = input.charAt(i);
	    if (charAtPos == ' ') {// ignore spaces
		continue;
	    }
	    Set<Integer> set = concordanceMap.get(charAtPos);
	    if (set == null) {// intial case when no set is available for character
		set = new HashSet<Integer>();
	    }
	    set.add(i);
	    concordanceMap.put(charAtPos, set);
	}
	return concordanceMap;
    }

    // will convert array into String
    private String convertToString(String[] inputStrings) {
	String str = "";
	for (String string : inputStrings) {
	    str += string;
	}
	return str;
    }

    public static void main(String[] args) {
	if (args.length < 1)
	    return;
	ConcordanceOfCharaters concordanceOfCharaters = new ConcordanceOfCharaters();
	System.out.println(concordanceOfCharaters.checkString(args));
    }
}
