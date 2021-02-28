public class OffByN implements CharacterComparator{
    private int parameter;
    public OffByN(int N){
        parameter = N;
    }
    public boolean equalChars(char x, char y){
        int a = x;
        int b = y;
        if(Math.abs(a - b) != parameter){
            return false;
        }
        return true;
    }
}
