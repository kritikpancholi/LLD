package Design.Cache.algoritham;

import  Design.Cache.algoritham.DoublyLinkedListNode;

import java.util.Objects;

public class DoublyLinkedList<Key, Value> {

    private final DoublyLinkedListNode<Key, Value> dummyHead;
    private final DoublyLinkedListNode<Key, Value> dummyTail;

    public DoublyLinkedList(){
        this.dummyHead = new DoublyLinkedListNode<>(null,null);
        this.dummyTail = new DoublyLinkedListNode<>(null,null);
        this.dummyHead.next = dummyTail;
        this.dummyTail.prev = dummyHead;
    }
    public boolean isEmpty() {
        return dummyHead.next == dummyTail;
    }

    public void insertNodeAtEnd(final DoublyLinkedListNode<Key, Value> node) {
        final DoublyLinkedListNode<Key, Value> tailPrev = dummyTail.prev;
        dummyTail.prev = node;
        node.next = dummyTail;
        tailPrev.next = node;
        node.prev = tailPrev;
    }

    public DoublyLinkedListNode<Key, Value> insertElementAtEnd(final Key key, Value value) {
        if (Objects.isNull(key))
            throw new RuntimeException();
        final DoublyLinkedListNode<Key, Value> node = new DoublyLinkedListNode<>(key,value);
        insertNodeAtEnd(node);
        return node;
    }

    public void detachNode(final DoublyLinkedListNode<Key, Value> node) {
        if (Objects.nonNull(node)) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public DoublyLinkedListNode<Key, Value> getFirstNode() {
        if (isEmpty())
            return null;
        return dummyHead.next;
    }

    public DoublyLinkedListNode<Key, Value> getLastNode() {
        if (isEmpty())
            return null;
        return dummyTail.prev;
    }
}

