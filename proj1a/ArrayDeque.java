public class ArrayDeque<T> {
    private T[] item;
    private int nextFirst;
    private int nextLast;
    private int size;
    private double usageRatio = size / (item.length + 1);

    public int size() {
        return size;
    }

    public ArrayDeque() {
        item = (T[]) new Object[8];
        size = 0;
    }

    public ArrayDeque(int first, int last) {
        item = (T[]) new Object[8];
        size = 0;
        nextFirst = first;
        nextLast = last;
    }

    public void addFirst(T addItem) {
        if (size == item.length) {
            resize();
        }
        item[nextFirst] = addItem;
        if (nextFirst != 0) {
            nextFirst--;
        } else {
            nextFirst = item.length - 1;
        }
        size++;
    }

    public void addLast(T addItem) {
        if (size == item.length) {
            resize();
        }
        item[nextLast] = addItem;
        if (nextLast != item.length - 1) {
            nextLast++;
        } else {
            nextLast = 0;
        }
        size++;
    }

    public void removeFirst() {
        item[nextFirst] = null;
        if (nextFirst == 0) {
            nextFirst = item.length - 1;
        } else {
            nextFirst++;
        }
        size--;
    }

    public void removeLast() {
        item[nextLast] = null;
        if (nextLast == item.length - 1) {
            nextLast = 0;
        } else {
            nextLast--;
        }
        size--;
    }

    public void resize() {
        if (nextLast - nextFirst == size - 1) {
            resizeHelper1();
            return;
        } else if (nextFirst > nextLast) {
            resizeHelper2();
            return;
        }
    }

    private void resizeHelper1() {
        T[] newItem = (T[]) new Object[size * 2];
        System.arraycopy(item, 0, newItem, 0, size);
        item = newItem;
    }

    private void resizeHelper2() {
        T[] newItem = (T[]) new Object[size * 2];
        System.arraycopy(item, nextFirst, newItem, nextFirst + size, size - nextFirst);
        System.arraycopy(item, 0, newItem, 0, nextLast + 1);
        item = newItem;
        nextFirst = nextLast + size;
    }

    public T get(int index) {
        if (nextFirst + index + 1 > item.length) {
            return item[nextFirst + index - item.length];
        }
        return item[nextFirst + index + 1];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        String str = "";
        if (nextFirst < nextLast) {
            for (int i = nextFirst; i < nextLast; i++) {
                str = str + item[i] + " ";
            }
            System.out.println(str);
        } else {
            for (int i = nextFirst; i < item.length; i++) {
                str = str + item[i] + " ";
            }
            for (int i = 0; i <= nextLast; i++) {
                str = str + item[i] + " ";
            }
            System.out.println(str);
        }
    }


}