public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public boolean insert(int data) {

        Node newNode = new Node(data);
        if (newNode == null) {
            return false;
        }

        //list is empty, new node becomes the first node
        if (head == null) {
            head = newNode;
            return true;
        }

        //the list is not empty
        //locate the last node
        Node last = head;
        while (last.getNext() != null) {
            last = last.getNext();
        }

        //link the new node to the last node
        last.setNext(newNode);
        return true;
    }

    public void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
