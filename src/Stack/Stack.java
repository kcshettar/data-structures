package Stack;

/**
 * Stack - LIFO
 */
public class Stack {

    private Node headNode;

    // stack node structure
    private class Node {
        private Integer data;
        Node nextNode;

        Node(Integer data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // push an element
    private void push(Integer data) {
        if (headNode == null) {
            headNode = new Node(data);
        } else {
            Node tempNode = new Node(data);
            tempNode.nextNode = headNode;
            headNode = tempNode;
        }
    }

    // pop an element
    private Integer pop() {
        if (headNode == null) {
            return null;
        } else {
            Node tempNode = headNode;
            headNode = headNode.nextNode;
            return tempNode.data;
        }
    }

    // get the top element
    private Integer top() {
        if (headNode == null) {
            return null;
        } else {
            return headNode.data;
        }
    }

    // print all elements
    private void print() {
        if (headNode == null) {
            System.out.println("stack is empty");
        } else {
            Node tempNode = headNode;
            while (tempNode != null) {
                System.out.println("stack value = " + tempNode.data);
                tempNode = tempNode.nextNode;
            }
        }
    }

    // find min element
    private Integer getMin() {
        if (headNode == null) {
            return null;
        } else {
            Integer minValue = Integer.MAX_VALUE;
            Node tempNode = headNode;
            while (tempNode != null) {
                if (tempNode.data < minValue) {
                    minValue = tempNode.data;
                }
                tempNode = tempNode.nextNode;
            }
            return minValue;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("stack implementation using linked list");
        Stack stack = new Stack();

        // add 3 elements
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // find min element
        System.out.println("stack min = " + stack.getMin());

        // print top element
        System.out.println("stack top = " + stack.top());

        // print all elements
        stack.print();

        // pop 4 elements
        System.out.println("stack pop = " + stack.pop());
        System.out.println("stack pop = " + stack.pop());
        System.out.println("stack pop = " + stack.pop());
        System.out.println("stack pop = " + stack.pop());

        // print all elements
        stack.print();
    }
}