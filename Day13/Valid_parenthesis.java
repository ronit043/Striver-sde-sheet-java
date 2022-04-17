package Day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Valid_parenthesis {
    public boolean isValid(String s) {
        Deque<Character> stq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') stq.push(ch);
            else {
                if(ch == ')') {
                    if(!stq.isEmpty() && stq.peek() == '(') stq.pop();
                    else return false;
                }
                if (ch == '}') {
                    if (!stq.isEmpty() && stq.peek() == '{') stq.pop();
                    else return false;
                }
                if (ch == ']') {
                    if(!stq.isEmpty() && stq.peek() == '[') stq.pop();
                    else return false;
                }
            }
        }

        return stq.isEmpty();
    }
}