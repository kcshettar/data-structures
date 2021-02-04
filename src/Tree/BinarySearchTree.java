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
        } else {
            return true;
        }
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

    // print all leaf nodes
    private void printLeafNodes() {
        printLeafNodes(root);
    }

    private void printLeafNodes(Node root) {
        if (root == null) {
            System.out.println("tree is empty");
        } else if (root.left == null && root.right == null) {
            System.out.println("tree leaf node = " + root.data);
        } else {
            printLeafNodes(root.left);
            printLeafNodes(root.right);
        }
    }

    // print preorder -> root -> left -> right
    private void printPreorder() {
        printPreorder(root);
    }

    private void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    // print postorder -> left -> right -> root
    private void printPostorder() {
        printPostorder(root);
    }

    private void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    // print inorder -> left -> root -> right
    private void printInorder() {
        printInorder(root);
    }

    private void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // get number of edges between root and farthest leaf node
    private Integer getEdges() {
        return getEdges(root);
    }

    private Integer getEdges(Node root) {
        if (root == null) {
            return -1;
        }

        Integer leftHeight = getEdges(root.left);
        Integer rightHeight = getEdges(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // get height of a tree
    private Integer getHeight() {
        return getHeight(root);
    }

    private Integer getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        Integer leftHeight = getHeight(root.left);
        Integer rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
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

        // print all leaf nodes
        binarySearchTree.printLeafNodes();

        // print preorder
        binarySearchTree.printPreorder();

        // print postorder
        binarySearchTree.printPostorder();

        // print inorder
        binarySearchTree.printInorder();

        // get number of edges between root and farthest leaf node
        System.out.println("number of edges between root and leaf node = " + binarySearchTree.getEdges());

        // get height of a tree
        System.out.println("height of a tree = " + binarySearchTree.getHeight());
    }
}
