package Design.Cache.algoritham;

public class DoublyLinkedListNode<Key, Value> {
    Value value;
    Key key;
    DoublyLinkedListNode<Key,Value> prev;
    DoublyLinkedListNode<Key,Value> next;

    public DoublyLinkedListNode(Key key ,Value value){
        this.value = value;
        this.key = key;
        this.prev= null;
        this.next = null;
    }

    public Value getValue(){
        return value;
    }
    public Key getKey(){
        return key;
    }
}
