public class LinkedListDeque<T> {
    private int size;

    private IntList sentinal = new IntList(null,null,null);
    private class IntList{
        private T item;
        private IntList pre;
        private IntList next;

        public IntList() {
            this.item = null;
            this.pre = null;
            this.next = null;
        }
        public IntList(T item, IntList pre, IntList next){
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    public LinkedListDeque(){
        sentinal = new IntList();
        sentinal.next = sentinal;
        sentinal.pre = sentinal;
    }
    public void addFirst(T item){
        size++;
        IntList newNode = new IntList(item, sentinal, sentinal.next);
        sentinal.next.pre = newNode;
        sentinal.next = newNode;
    }
    public void addLast(T item){
        size++;
        IntList newNode = new IntList(item, sentinal.pre, sentinal);
        sentinal.pre.next = newNode;
        sentinal.pre = newNode;
    }


    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        size--;
        T returnItem = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.pre = sentinal;
        return returnItem;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        size--;
        T returnItem = sentinal.pre.item;
        sentinal.pre = sentinal.pre.pre;
        sentinal.pre.next = sentinal;
        return returnItem;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public T get(int index){
        IntList p = sentinal;
        if(sentinal.next == null){
            return null;
        }
        while(index >= 0){
            p = p.next;
            index--;
        }
        return p.item;
    }
    public T getRecursive(int index){
        IntList p = sentinal.next;
        return getRecursiveHelper(p, index).item;
    }
    private IntList getRecursiveHelper(IntList node, int index){
        if(node.next == null || index == 0){
            return node;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
    public void printDeque(){
        String s = "";
        IntList p = sentinal.next;
        while (p != sentinal){
            s = s + p.item + " ";
            p = p.next;
        }
        System.out.println(s);
    }
}
