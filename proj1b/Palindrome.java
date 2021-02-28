public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> linkedListDeque = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i++){
            linkedListDeque.addLast(word.charAt(i));
        }
        return linkedListDeque;
    }
    public boolean isPalindrome(String word){
        LinkedListDeque<Character> linkedListDeque = (LinkedListDeque<Character>) wordToDeque(word);
        if(linkedListDeque.isEmpty() || linkedListDeque.size() == 1){
            return true;
        }
        while(linkedListDeque.size() != 1 && linkedListDeque.size() != 0){
            if(linkedListDeque.removeFirst() != linkedListDeque.removeLast()){
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        LinkedListDeque<Character >linkedListDeque = (LinkedListDeque<Character>) wordToDeque(word);
        if(linkedListDeque.isEmpty() || linkedListDeque.size() == 1){
            return false;
        }
        while(linkedListDeque.size() != 1 && linkedListDeque.size() != 0){
            char ch1 = linkedListDeque.removeFirst();
            char ch2 = linkedListDeque.removeLast();
            if(!cc.equalChars(ch1,ch2)){
                return false;
            }
        }
        return true;
    }
}
