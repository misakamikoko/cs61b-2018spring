public class ArrayDeque<item> implements Deque<item> {
    private static int expandCo = 2;
    private static int contractCo = 2;
    private static double minContractSize = 16;
    private static int initialCapacity = 8;
    private int capacity; //size of the array
    private int size;
    private int nextFirst;
    private int nextLast;
    private item[] item;

    public ArrayDeque(){
        capacity = initialCapacity;
        item = (item[]) new Object[capacity];
        nextFirst = capacity - 1;
        nextLast = 0;
        size = 0;
    }

    @Override
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    private int onePlus(int index){
        if(index == capacity - 1){
            index = 0;
        }
        else{
            index++;
        }
        return index;
    }
    private int oneMinus(int index){
        if(index == 0){
            index = capacity - 1;
        }
        else{
            index--;
        }
        return index;
    }

    @Override
    public void addFirst(item addItem){
        item[nextFirst] = addItem;
        nextFirst = oneMinus(nextFirst);
        size++;
        expand();
    }

    @Override
    public void addLast(item addItem){
        item[nextLast] = addItem;
        nextLast = onePlus(nextLast);
        size++;
        expand();
    }

    @Override
    public item removeFirst(){
        if(isEmpty()){
            return null;
        }
        int currentFirst = onePlus(nextFirst);
        item itemRemove = item[currentFirst];
        item[currentFirst] = null;
        nextFirst = currentFirst;
        size--;
        contract();
        return itemRemove;
    }

    @Override
    public item removeLast(){
        if(isEmpty()){
            return null;
        }
        int currentLast = oneMinus(nextLast);
        item itemRemove = item[currentLast];
        item[currentLast] = null;
        nextLast = currentLast;
        size--;
        contract();
        return itemRemove;
    }
    private void expand(){
        if(size == capacity){
            resize(capacity * expandCo);
        }
    }
    private void contract(){
        if(capacity >= 16 && (double) size/capacity < 0.25){
            resize(capacity / contractCo);
        }
    }
    private void resize(int newCapacity){
        int currentFirst = onePlus(nextFirst);
        int currentLast = oneMinus(nextLast);
        item[] newItem = (item[]) new Object[newCapacity];
        if(currentFirst < currentLast){
            int copyLength = currentLast - currentFirst + 1;
            System.arraycopy(item, currentFirst, newItem, 0, copyLength);
            nextFirst = newCapacity - 1;
            nextLast = copyLength;
        }
        else{
            int firstLength = capacity - currentFirst;
            int newCurrentFirst = newCapacity - firstLength;
            System.arraycopy(item, currentFirst, newItem, newCurrentFirst, firstLength);
            int lastLength = nextLast;
            System.arraycopy(item, 0, newItem, 0, lastLength);
            nextFirst = oneMinus(newCurrentFirst);
        }
        capacity = newCapacity;
        item = newItem;
    }

    @Override
    public void printDeque(){
        String str = "";
        int currentFirst = onePlus(nextFirst);
        int currentNext = oneMinus(nextLast);
        do {
            str += item[currentFirst] + " ";
            currentFirst = onePlus(currentFirst);
        }while(currentFirst != nextLast);
        System.out.println(str);
    }

    @Override
    public item get(int index) {
        if (index >= size) {
            return null;
        }

        int indexFromFront = nextFirst + 1 + index;
        if (indexFromFront >= capacity) {
            indexFromFront -= capacity;
        }
        return item[indexFromFront];
    }
}