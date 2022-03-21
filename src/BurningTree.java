import java.util.*;

/**
 * https://practice.geeksforgeeks.org/problems/burning-tree/1#
 */
public class BurningTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int minTime(Node root, int target) {
        // Your code goes here
        if (root == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        populateParentMap(root, parentMap);

        Node targetNode = findTargetNode(root, target);
        if (targetNode == null) return 0;

        Set<Node> visited = new HashSet<>();
        visited.add(targetNode);

        Queue<Node> q = new LinkedList<>();
        q.add(targetNode);

        int minTime = 0;
        while (!q.isEmpty()) {
            minTime++;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node currNode = q.poll();

                if (currNode.left != null && !visited.contains(currNode.left)) {
                    q.add(currNode.left);
                    visited.add(currNode.left);
                }

                if (currNode.right != null && !visited.contains(currNode.right)) {
                    q.add(currNode.right);
                    visited.add(currNode.right);
                }

                Node parentNode = parentMap.get(currNode);
                if (parentNode != null && !visited.contains(parentNode)) {
                    q.add(parentNode);
                    visited.add(parentNode);
                }
            }
        }
        return minTime - 1;
    }

    static void populateParentMap(Node root, Map<Node, Node> parentMap) {
        if (root != null) {
            if (root.left != null) {
                parentMap.put(root.left, root);
            }

            if (root.right != null) {
                parentMap.put(root.right, root);
            }

            if (root.left != null)
                populateParentMap(root.left, parentMap);

            if (root.right != null)
                populateParentMap(root.right, parentMap);
        }
    }

    static Node findTargetNode(Node root, int target) {
        if (root == null) return null;

        if (root.data == target) return root;
        Node leftNode = findTargetNode(root.left, target);
        if (leftNode != null) return leftNode;

        Node rightNode = findTargetNode(root.right, target);
        if (rightNode != null) return rightNode;

        return null;
    }
}