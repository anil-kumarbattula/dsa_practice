package dsa_practice;

public class Double_Linked_List {
    Node head;
    Node tail;
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    //add at First
    public void addFirst(int data) {
        Node temp = new Node(data);
        if(head == null) {
            head = temp;
            tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    //add at End
    public void addEnd(int data) {
        Node temp = new Node(data);
        if(tail == null) {
            head = temp;
            tail = temp;
            return;
        }
        tail.next = temp;
        temp.prev = tail;
        tail = temp;

    }
    //Insert at a Particular Position
    public void addPosition(int idx, int data) {
        Node temp = new Node(data);
        if(head == null) {
            head = tail = temp;
            return;
        }
        if(idx == 0) {
            temp.next = head;
            head.prev = temp;
            head = temp;
            return;
        }
        Node curr = head;
        for(int i =0; i < idx-1 && curr != null; i++) {
            curr = curr.next;
        }
        if(curr == null) {
            System.out.println("Index out of Bound");
            return;
        }
        if(curr.next == null) {
            curr.next = temp;
            temp.prev = curr;
            temp.next = null;
            tail = temp;
            return;
        }
        temp.next = curr.next;
        temp.next.prev = temp;
        curr.next = temp;
        temp.prev = curr;
    }
    //To delete node at First
    public void removeFirst() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head == tail) {
            head = tail = null;
        }
        else{
        head = head.next;
        head.prev = null;
        }

    }
    //To delete node at end
    public void removeEnd() {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(head == tail) {
            head = tail = null;
        }
        else{
        tail = tail.prev;
        tail.next = null;
        }
    }
    //To delete node at Particular Position
    public void removePosition(int idx) {
        if(head == null) {
            System.out.println("List is Empty");
            return;
        }
        if(idx == 0) {
            System.out.println(head.data + " is removed");
            head = head.next;
            head.prev = null;
            return;
        }
        Node curr = head;
        for(int i = 0; i < idx-1 && curr != null; i++ ) {
            curr = curr.next;
        }
        if(curr == null) {
            System.out.println("Index out of bound");
        }
        if(curr.next == null) {
            System.out.println(tail.data + " is removed");
            tail.prev = tail;
            tail.next = null;
        }
        else{
            System.out.println(curr.next.data + " is removed");
            curr.next.prev = null;
            curr.next.next.prev = curr;
            curr.next = curr.next.next;
        }

    }
    //To print the linked list
    public void printList() {
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        Double_Linked_List list = new Double_Linked_List();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(0);
        list.printList();
        list.removeFirst();
        list.removeEnd(); 
        list.printList();
        list.addPosition(2,7);
        list.addPosition(1,14);
        list.printList();
        list.removePosition(1);
        list.removePosition(3);
        list.printList();


    }
}

