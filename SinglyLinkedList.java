/*
 *  Java Program to Implement Singly Linked List
 */

import java.util.Scanner;

/*  Class Node  */
class Node {
    protected int current;
    protected Node next;

    public Node() {
        next = null;
        current = 0;
    }

    public Node(int d, Node n) {
        current = d;
        next = n;
    }

    /*  Function to set next to next Node  */
    public void setNext(Node n) {
        next = n;
    }

    /*  Function to set current to current Node  */
    public void setCurrent(int d) {
        current = d;
    }

    /*  Function to get next to next node  */
    public Node getNext() {
        return next;
    }

    /*  Function to get current from current Node  */
    public int getCurrent() {
        return current;
    }
}

/* Class CustomLinkedList*/
class CustomLinkedList {
    protected Node start;
    protected Node end;
    public int size;

    /*  Constructor  */
    public CustomLinkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /*  Function to check if list is empty  */
    public boolean isEmpty() {
        return start == null;
    }

    /*  Function to get size of list  */
    public int getSize() {
        return size;
    }

    /*  Function to insert an element at end  */
    public void insert(int val) {
        Node nptr = new Node(val, null);
        size++;
        if (start == null) {
            start = nptr;
            end = start;
        } else {
            end.setNext(nptr);
            end = nptr;
        }
    }

    public void display() {
        System.out.print("\nCustom Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getNext() == null) {
            System.out.println(start.getCurrent());
            return;
        }
        Node ptr = start;
        System.out.print(start.getCurrent() + "->");
        ptr = start.getNext();
        while (ptr.getNext() != null) {
            System.out.print(ptr.getCurrent() + "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getCurrent() + "\n");
    }

    /*  Function to delete an element at position  */
    public void deleteSpecific(int pos) {
        if (pos == 1) {
            start = start.getNext();
            size--;
            return;
        }
        if (pos == size) {
            Node s = start;
            Node t = start;
            while (s != end) {
                t = s;
                s = s.getNext();
            }
            end = t;
            end.setNext(null);
            size--;
            return;
        }
        Node ptr = start;
        pos = pos - 1;
        for (int i = 1; i < size - 1; i++) {
            if (i == pos) {
                Node tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setNext(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size--;
    }

    /*  Function to delete an element that is lesser than target  */
    public void deleteGreater(int val) {
        Node ptr = start;
        for (int i = 1; i <= size; i++) {
            if (ptr.getCurrent() > val) {
                deleteSpecific(i);
                i--;
            }
            ptr = ptr.getNext();
        }
    }

    public void deleteEnd() {
        Node s = start;
        Node t = start;
        while (s != end) {
            t = s;
            s = s.getNext();
        }
        end = t;
        end.setNext(null);
        size--;
    }
}

/*  Class SinglyLinkedList  */
public class SinglyLinkedList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        CustomLinkedList list = new CustomLinkedList();
        System.out.println("Singly Linked List Test\n");
        char ch;
        do {
            System.out.println("\nPlease select an option to work with singly Linked List\n");
            System.out.println("1. Append an element into the linkedlist");
            System.out.println("2. Remove the tail element from a linkedlist");
            System.out.println("3. Remove all element in the linkedlist that is great than a target value");


            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    try {
                        int s = scan.nextInt();
                        if (s > 0) {
                            list.insert(s);
                        } else {
                            System.out.println("please enter positive values only");
                        }

                    } catch (Exception e) {
                        System.out.println("please enter interger values only");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Removing tail element");
                    if (list.size != 0) {
                        list.deleteEnd();
                    }
                    break;
                case 3:
                    System.out.println("Enter value to compare");
                    int value = scan.nextInt();
                    if (value > 0) {
                        list.deleteGreater(value);
                    } else {
                        System.out.println("please enter positive values only");
                    }
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}