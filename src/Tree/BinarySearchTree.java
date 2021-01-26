package Tree;

/**
 * BinarySearchTree
 */
public class BinarySearchTree {

    private Node root;

    // tree node structure
    private class Node {
        private Integer data;
        private Node left, right;

        Node(Integer data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // insert an element
    private void insert(Integer data) {
        root = insert(root, data);
    }

    private Node insert(Node root, Integer data) {
        if (root == null) {
            root = new Node(data);
        } else {
            if (data < root.data) {
                root.left = insert(root.left, data);
            }
            if (data > root.data) {
                root.right = insert(root.right, data);
            }
        }
        return root;
    }

    // search an element
    private boolean search(Integer data) {
        Node searchNode = search(root, data);

        if (searchNode == null) {
            return false;
        }
        return true;
    }

    private Node search(Node root, Integer data) {
        if (root == null || root.data == data) {
            return root;
        } else {
            if (data < root.data) {
                return search(root.left, data);
            }
            return search(root.right, data);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // insert 7 elements
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(10);
        binarySearchTree.insert(8);
        binarySearchTree.insert(15);

        // search an element
        System.out.println("Node found? = " + binarySearchTree.search(15));
        System.out.println("Node found? = " + binarySearchTree.search(30));
    }
}