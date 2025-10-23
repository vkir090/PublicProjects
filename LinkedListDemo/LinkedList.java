public class LinkedList {
    private Node head;
    private int size;
    private Node previous;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(int value) { 
        if (head==null){
            head = new Node(value);
            previous = head;
        } else {
            previous.next = new Node(value);
            previous = previous.next;
        }
        ++size;
            
        
    }
    public void print() { 
        Node current = head;
        while (current != null){
            System.out.println("Knoten: " + current.data);
            current = current.next;
        }
    }
    public int getSize() { 
        return size; 
    }
}
