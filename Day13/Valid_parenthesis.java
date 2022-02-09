package Day13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Valid_parenthesis {
    public boolean isValid(String s) {
        Deque<Character> adq = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') adq.push(ch);
            else if(adq.isEmpty()) return false;
            else if(ch == ')' && adq.pop() != '(') return false;
            else if(ch == ']' && adq.pop() != '[') return false;
            else if(ch == '}' && adq.pop() != '{') return false;
        }
        return adq.isEmpty();
    }
}