public class hhh {
    public static void main(String[] args) {
        int[] a = new int[]{8};
        int[] b = new int[1];
        System.arraycopy(a, 0, b, 0, 1);
        System.out.println(b[0]);
    }
}
