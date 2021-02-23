public class LinkedListDeque<T> {
    private int size;

    private IntList sentinal = new IntList(null,null,null);
    private class IntList{
        private T item;
        private IntList next;
        private IntList pre;

        public IntList() {
            this.item = null;
            this.next = null;
            this.pre = null;
        }
        public IntList(T item, IntList next, IntList pre){
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
    public LinkedListDeque(){
        sentinal = new IntList();
        sentinal.next = sentinal;
        sentinal.pre = sentinal;
    }
    public void addFirst(T item){
        size++;

        IntList frontNOde = new IntList(item, null,null);
        IntList rest = sentinal.next;
        sentinal.next = frontNOde;
        frontNOde.pre = sentinal;
        frontNOde.next = rest;
        if(rest == null){
            sentinal.pre = frontNOde;
            frontNOde.next = sentinal;
            return;
        }
        rest.pre = frontNOde;
    }
    public void addLast(T item){
        size++;
        IntList endNode = new IntList(item, null, null);
        if(size == 1){
            addFirst(item);
            return;
        }
        endNode.pre = sentinal.pre;
        sentinal.pre.next = endNode;
        sentinal.pre = endNode;
        endNode.next = sentinal;
    }


    public T removeFirst(){
        if(sentinal.next == null){
            return null;
        }
        T returnItem = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.pre = sentinal;
        return returnItem;
    }
    public T removeLast(){
        if(sentinal.pre == null){
            return null;
        }
        T returnItem = sentinal.pre.item;
        sentinal.pre = sentinal.pre.pre;
        sentinal.pre.next = sentinal;
        return returnItem;
    }
    public boolean isEmpty(){
        if(sentinal.next != sentinal){
            return false;
        }
        return true;
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
