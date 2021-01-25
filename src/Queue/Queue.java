package Queue;

/**
 * Queue - FIFO
 */
public class Queue {

    private Node frontNode, rearNode;

    // queue node structure
    private class Node {
        private Integer data;
        private Node nextNode;

        Node(Integer data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // enqueue an element
    private void enqueue(Integer data) {
        if (rearNode == null) {
            frontNode = rearNode = new Node(data);
        } else {
            Node tempNode = new Node(data);
            rearNode.nextNode = tempNode;
            rearNode = tempNode;
        }
    }

    // dequeue an element
    private Integer dequeue() {
        if (frontNode == null) {
            return null;
        } else {
            Node tempNode = frontNode;
            frontNode = frontNode.nextNode;

            if (frontNode == null) {
                rearNode = null;
            }

            return tempNode.data;
        }
    }

    // print all elements
    private void print() {
        if (frontNode == null) {
            System.out.println("queue is empty");
        } else {
            Node tempNode = frontNode;
            while (tempNode != null) {
                System.out.println("queue value = " + tempNode.data);
                tempNode = tempNode.nextNode;
            }
        }
    }

    // find min element
    private Integer getMin() {
        if (frontNode == null) {
            return null;
        } else {
            Integer minValue = Integer.MAX_VALUE;
            Node tempNode = frontNode;
            while (tempNode != null) {
                if (tempNode.data < minValue) {
                    minValue = tempNode.data;
                }
                tempNode = tempNode.nextNode;
            }
            return minValue;
        }
    }

    public static void main(String[] args) {
        System.out.println("queue implementation using linked list");
        Queue queue = new Queue();

        // enqueue 3 elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // find min element
        System.out.println("queue min = " + queue.getMin());

        // print all elements
        queue.print();

        // dequeue 4 elements
        System.out.println("queue dequeue = " + queue.dequeue());
        System.out.println("queue dequeue = " + queue.dequeue());
        System.out.println("queue dequeue = " + queue.dequeue());
        System.out.println("queue dequeue = " + queue.dequeue());

        // print all elements
        queue.print();
    }
}
