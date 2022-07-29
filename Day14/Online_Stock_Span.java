package Day14;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Deque;

public class Online_Stock_Span {
   Deque<Point> stq = new ArrayDeque<>();
   public int next(int price) {
      int res = 1;
      //  Stack will have only those prices in which price is higher than current price.
      while (!stq.isEmpty() && stq.peek().x <= price)
         res += stq.pop().y;
      stq.push(new Point(price, res));

      return res;
   }
}