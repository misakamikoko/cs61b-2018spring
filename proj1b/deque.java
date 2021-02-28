public interface deque<item>{
    void addFirst(item item);
    void addLast(item item);
    item removeFirst();
    item removeLast();
    item get(int index);
    boolean isEmpty();
    int size();
    void printDeque();

}
