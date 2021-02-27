public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> a1 = new ArrayDeque<>();
        a1.addFirst("hh");
        a1.addLast("xx");
        a1.addFirst("hehe");
        a1.addFirst("dad");
        a1.addFirst("dacd");
        a1.addFirst("dada");
        a1.addLast("cad");
        a1.addFirst("huhnj");
        a1.removeLast();
        a1.removeLast();

        a1.printDeque();
        a1.addLast("hhds");
        a1.addLast("aadac");
    }
}
