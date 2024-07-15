public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public Node getHead() {
        return head;
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

    public boolean insert(int data, int position) {
        Node newNode = new Node(data);
        if (newNode == null) {
            return false;
        }

        //if position is one
        if (position == 1) {
            newNode.setNext(head);
            head = newNode;
            return true;
        }

        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev == null) {
                return false;
            }
        }

        newNode.setNext(prev.getNext());
        prev.setNext(newNode);

        return true;
    }

    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void display(Node head) {
        if(head == null) {
            System.out.println();
            return;
        }
        System.out.print(head.getData() + " ");
        display(head.getNext());
    }

    public void displayReverse(Node head) {
        if(head == null) {
            System.out.println();
            return;
        }
        displayReverse(head.getNext());
        System.out.print(head.getData() + " ");

    }

    public void reverse() {
        if(head == null) {
            return;
        }

        Node n1 = head;
        Node n2 = head.getNext();
        Node n3;

        while(n2 != null) {
            n3 = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            n2 = n3;
        }

        head.setNext(null);
        head = n1;
    }

    public boolean deleteByPosition(int position) {
        if(head == null || position <= 0) {
            return false;
        }

        if(position == 1) {
            head = head.getNext();
            return true;
        }

        //locate the node at position - 1
        Node prev = head;
        for(int i = 1; i < position - 1; i++) {
            prev = prev.getNext();
            if(prev.getNext() == null) {
                return false;
            }
        }

        Node del = prev.getNext();
        prev.setNext(del.getNext());

        return true;
    }

    public boolean deleteByVal(int data) {
        if(head == null) {
            return false;
        }

        if(head.getData() == data) {
            head = head.getNext();
            return true;
        }

        Node prev = head;
        Node del = head;

        while(del.getData() != data) {
            prev = del;
            del = del.getNext();
            if(del == null) {
                return false;
            }
        }

        prev.setNext(del.getNext());
        return true;
    }


}
