public class LinkedListDeque<Item> implements Deque<Item> {
    private int size;

    private IntList sentinal = new IntList(null,null,null);
    private class IntList{
        private Item item;
        private IntList pre;
        private IntList next;

        public IntList() {
            this.item = null;
            this.pre = null;
            this.next = null;
        }
        public IntList(Item item, IntList pre, IntList next){
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
    @Override
    public void addFirst(Item item){
        size++;
        IntList newNode = new IntList(item, sentinal, sentinal.next);
        sentinal.next.pre = newNode;
        sentinal.next = newNode;
    }
    @Override
    public void addLast(Item item){
        size++;
        IntList newNode = new IntList(item, sentinal.pre, sentinal);
        sentinal.pre.next = newNode;
        sentinal.pre = newNode;
    }

    @Override
    public Item removeFirst(){
        if(isEmpty()){
            return null;
        }
        size--;
        Item returnItem = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.pre = sentinal;
        return returnItem;
    }

    @Override
    public Item removeLast(){
        if(isEmpty()){
            return null;
        }
        size--;
        Item returnItem = sentinal.pre.item;
        sentinal.pre = sentinal.pre.pre;
        sentinal.pre.next = sentinal;
        return returnItem;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Item get(int index){
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

    public Item getRecursive(int index){
        IntList p = sentinal.next;
        return getRecursiveHelper(p, index).item;
    }
    private IntList getRecursiveHelper(IntList node, int index){
        if(node.next == null || index == 0){
            return node;
        }
        return getRecursiveHelper(node.next, index - 1);
    }

    @Override
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
