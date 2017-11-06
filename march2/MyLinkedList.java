package march2;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Максим on 02.03.2017.
 */
public class MyLinkedList<T> extends AbstractCollection<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
    }

    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(T obj) {
        if (first == null) {
            first = new Node<>(null, obj, null);
            last = first;
            size++;

            return true;
        }

        Node current = last;
        last = new Node(current, obj, null);
        current.next = last;
        size++;

        return true;
    }

    public void addAfter(T prevObj, T obj) {
        Node<T> prev = getNode(prevObj);
        prev.next = new Node<>(prev, obj, null);
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("LinkedList size: " + size);

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    public boolean has(T obj) {
        return getNode(obj)!= null;
    }

    public void removeObj(T obj) {
        Node<T> current = getNode(obj);
        final Node<T> next = current.next;
        final Node<T> prev = current.prev;

        if (current == null) throw new NoSuchElementException();

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            current.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            current.next = null;
        }

        current.item = null;
        size--;
    }

    public void merge(MyLinkedList<T> arr2) {
        this.last.next = arr2.first;
    }

    private Node<T> getNode(T obj) {
        if (obj == null) {
            for (Node<T> i = first; i != null; i = i.next) {
                if (i.item == null) {
                    return i;
                }
            }
        } else {
            for (Node<T> i = first; i != null; i = i.next) {
                if (i.item.equals(obj)) {
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new MLLIterator();
    }

    @Override
    public int size() {
        return size;
    }

    private class MLLIterator implements Iterator<T> {
        Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
