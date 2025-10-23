# LinkedList Demo

A simple implementation of a singly linked list in Java.  
This project demonstrates how linked nodes can be connected dynamically without using arrays.

---

## Concept

Each element (Node) stores:
- `data` → the value
- `next` → a reference to the next node in the list

The list starts with `head` and ends with the last node whose `next` is `null`.


---

## Features
- Add new elements dynamically (`add(int value)`)
- Print all nodes (`print()`)
- Track list size (`getSize()`)

---

## Example Usage
```java
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(10);
        list.add(20);
        list.add(30);

        list.print();
        System.out.println("Size: " + list.getSize());
    }
}
