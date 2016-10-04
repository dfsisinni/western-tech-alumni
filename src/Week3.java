import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.*;

/**
 * Created by dane on 9/28/16.
 */
public class Week3 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public static class UndirectedGraphNode {

        int label;
        List <UndirectedGraphNode> neighbors;

        public UndirectedGraphNode (int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public static void main (String [] args) {

    }



    //TREE Problem - Validate Binary Search Tree

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean maxHIT = false;
            boolean minHIT = false;
            if (root.val == Integer.MAX_VALUE) {
                if (root.right == null) {
                    maxHIT = true;
                } else {
                    return false;
                }
            } else if (root.val == Integer.MIN_VALUE) {
                if (root.left == null) {
                    minHIT = true;
                } else {
                    return false;
                }
            }

            return inOrder(root.left, Integer.MIN_VALUE, root.val, maxHIT, minHIT) && inOrder(root.right, root.val, Integer.MAX_VALUE, maxHIT, minHIT);
        }
    }

    public static boolean inOrder (TreeNode node, int min, int max, boolean maxHIT, boolean minHIT) {
        if (node == null) {
            return true;
        } else if (node.val > min && node.val < max){
            return inOrder(node.left, min, node.val, maxHIT, minHIT) && inOrder(node.right, node.val, max, maxHIT, minHIT);
        } else if (min == max) {
            return false;
        } else if (max == Integer.MAX_VALUE && max == node.val && node.right == null && !maxHIT) {
            return inOrder(node.left, min, node.val, maxHIT, minHIT);
        } else if (min == Integer.MIN_VALUE && min == node.val && node.left == null && !minHIT) {
            return inOrder(node.right, node.val, max, maxHIT, minHIT);
        }
        return false;
    }



    //TREE Problem - Sum Root to Leaf
    public static int sumNumbers (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = traverse(root.left, root.val) + traverse(root.right, root.val);
        if (result == 0) {
            return root.val;
        } else {
            return result;
        }
    }

    public static int traverse (TreeNode node, int prevSum) {
        if (node == null) {
            return 0;
        } else {
            String val = String.valueOf(prevSum) + String.valueOf(node.val);
            int num = Integer.parseInt(val);

            int result = traverse(node.left, num) + traverse(node.right, num);
            if (result == 0) {
                return num;
            } else {
                return result;
            }
        }
    }

    //GRAPH Problem - Clone Graph
    public UndirectedGraphNode cloneGraph (UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Stack <UndirectedGraphNode> stack = new Stack <UndirectedGraphNode>();
        HashMap <Integer, UndirectedGraphNode> map = new HashMap <Integer, UndirectedGraphNode> ();

        stack.add(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);

        while (!stack.isEmpty()) {
            UndirectedGraphNode current = stack.pop();

            List <UndirectedGraphNode> list = current.neighbors;

            for (int i = 0; i < list.size(); i++) {
                if (map.containsKey(list.get(i).label)) {
                    map.get(current.label).neighbors.add(map.get(list.get(i).label));
                } else {
                    stack.add(list.get(i));
                    UndirectedGraphNode addNode = new UndirectedGraphNode(list.get(i).label);
                    map.get(current.label).neighbors.add(addNode);
                    map.put(list.get(i).label, addNode);
                }


            }
        }

        return newNode;
    }
}
