import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.LinkedList;

// Java program to find lowest common ancestor using parent pointer
// A tree node
class Node
{
    int key;
    Node left, right, parent;

    Node(int key)
    {
        this.key = key;
        left = right = parent = null;
    }
}

class BinaryTree
{
    Node root, n1, n2, lca;

    /* A utility function to insert a new node with
       given key in Binary Search Tree */
    Node insert(Node node, int key)
    {
        /* If the tree is empty, return a new node */
        if (node == null)
            return new Node(key);

        /* Otherwise, recur down the tree */
        if (key < node.key)
        {
            node.left = insert(node.left, key);
            node.left.parent = node;
        }
        else if (key > node.key)
        {
            node.right = insert(node.right, key);
            node.right.parent = node;
        }

        /* return the (unchanged) node pointer */
        return node;
    }

    // To find LCA of nodes n1 and n2 in Binary Tree
    Node LCA(Node n1, Node n2)
    {
        // Creata a map to store ancestors of n1
        HashSet<Node> ancestors = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(n1);
        // Insert n1 and all its ancestors in map
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            ancestors.add(node);
            if (node.parent != null) queue.offer(node.parent);
        }

        System.out.println(ancestors.size());
        // Check if n2 or any of its ancestors is in
        // map.
        queue.clear();
        queue.add(n2);
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            if (ancestors.contains(node))
                return n2;
            if (node.parent != null) queue.offer(node.parent);
        }

        return null;
    }

    // Driver method to test above functions
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.left;
        tree.lca = tree.LCA(tree.n1, tree.n2);

        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
    }
}
