/** This interface defines a method for determining equality of characters. */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int num1 = x;
        int num2 = y;
        if(Math.abs(x - y) != 1){
            return false;
        }
        return true;
    }
}
