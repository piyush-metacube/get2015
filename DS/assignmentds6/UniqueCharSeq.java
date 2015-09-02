package assignmentds6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Assignment 2
 * Write a method that takes a string and returns the number of 
 * unique characters in the string. It is expected that a string
 * with the same character sequence may be passed several times 
 * to the method. Since the counting operation can be time consuming,
 * the methods should cache the results, so that when the methods is
 * given a string previously encountered, it will simply retrieve the 
 * stored result. Use collection and maps where appropriate.
 */
public class UniqueCharSeq {
    // cache which stores result
    private Map<String, Integer> stringMap = new HashMap<String, Integer>();

    // returns the number of unique characters in the string
    public int getUniqueCharacters(String string) {
	if (stringMap.containsKey(string)) {// check in cache if the result has populated earlier
	    return stringMap.get(string);
	} else {
	    Set<Character> characterSet = new HashSet<Character>();// hashset store nonduplicate values
	    for (char character : string.toCharArray()) {
		if (character == ' ') // ignoring whitespaces
		    continue;
		characterSet.add(character);
	    }
	    stringMap.put(string, characterSet.size());// adding result to cache
	    return characterSet.size();
	}
    }
}
