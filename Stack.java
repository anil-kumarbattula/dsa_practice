package dsa_practice;
import java.util.*;
public class Stack {
    //To implement Stck using Linked List
    static class Stack_LL{
        Node head;
        class Node{
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                next = null;
            }
        }
        public void push(int data) {
            Node temp = new Node(data);
            if(head == null) {
                head = temp;
                return;
            }
            temp.next = head;
            head = temp;
        }
        public void pop() {
            if(head == null) {
                System.out.println("Stack is Empty");
                return ;
            }
            System.out.println(head.data + " is poped");
            head = head.next;

        }
        public void peek() {
            if(head == null) {
                System.out.println("Stack is Empty");
                return ;
            }
            System.out.println(head.data);
        }
    }
    //Implementing Stack using ArrayList
    static class Stack_AL{
        ArrayList<Integer> list = new ArrayList<>();
        public void push(int data) {
            list.add(data);
        }
        public void pop() {
            if(list.size() == 0) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.println(list.get(list.size()-1) + " is poped");
            list.remove(list.size()-1);
        }
        public void peek() {
            if(list.size() == 0) {
                System.out.println("Stack is Empty");
                return;
            }
            System.out.println(list.get(list.size()-1));
        }
    }
    public static void main(String args[]) {
        Stack_AL s = new Stack_AL();
        s.push(0);
        s.push(1);
        s.push(7);
        s.push(3);
        s.pop();
        s.peek();
        Stack_LL l = new Stack_LL();
        l.push(0);
        l.push(1);
        l.push(7);
        l.push(3);
        l.pop();
        l.peek();
    }
}
