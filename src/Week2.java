import java.util.HashMap;
import java.util.Stack;


public class Week2 {

    public static void main (String [] args) {

    }


    //STACK PROBLEM - VALID PARENTHESES
    public boolean isValid (String s) {
        HashMap<Character, Character> charMap = new HashMap <Character, Character>();
        charMap.put('[', ']');
        charMap.put('{', '}');
        charMap.put('(', ')');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);

            if (charMap.containsKey(check)) {
                stack.push(check);
            } else if (charMap.containsValue(check)) {

                if (stack.isEmpty()) {
                    return false;
                }

                for (Character opening : charMap.keySet()) {
                    if (charMap.get(opening) == check) {
                        if (stack.pop() != opening) {
                            return false;
                        }
                        break;
                    }
                }

            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    //LINKED LIST PROBLEM - PARTITION LIST
    public ListNode partition (ListNode head, int x) {
        if (head == null){
            return null;
        }

        ListNode larger = null;

        while (head != null && head.val >= x) {
            ListNode next = head.next;
            head.next = larger;
            larger = head;
            head = next;
        }

        if (head == null) {
            return larger;
        }

        ListNode largeEnd = larger;


        ListNode headRunner = head;
        while (headRunner.next != null) {
            if (headRunner.next.val >= x) {
                ListNode swap = headRunner.next;
                headRunner.next = headRunner.next.next;
                swap.next = larger;
                larger = swap;
            } else {
                headRunner = headRunner.next;
            }
        }
        headRunner.next = reverseList(larger);
        return head;

    }

    //LINKED LIST PROBLEM - REVERSE A LINKED LIST 1
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode reversed = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = reversed;
            reversed = current;
            current = next;
        }

        return reversed;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
        val  = x;
    }
}
