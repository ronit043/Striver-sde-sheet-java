package Day13;
import java.util.ArrayDeque;
import java.util.Deque;

/*    TC: O(n), SC: O(n); n: length of string
Make use of the stack. Traverse the string and push the character in the stack if it is an opening brace, else:
1. If the stack is empty, return false.
2. If the opening brace doesn't match the current closing brace then return false.

After complete traversal, if the stack is empty then the string is balanced else unbalanced.
 */
class Valid_parenthesis {
   public boolean isValid(String s) {
      Deque<Character> stq = new ArrayDeque<>();

      for (int i = 0; i < s.length(); i++) {
         char ch = s.charAt(i);
         if (ch == '(' || ch == '{' || ch == '[') stq.push(ch);
         else {
            if (stq.isEmpty()) return false;
            else if (ch == ']' && stq.pop() != '[') return false;
            else if (ch == ')' && stq.pop() != '(') return false;
            else if (ch == '}' && stq.pop() != '{') return false;
         }
      }

      return stq.isEmpty();
   }
}