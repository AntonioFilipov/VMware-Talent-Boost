package publicInterface;

import java.util.Arrays;
import java.util.Random;

public class Hangman implements IHangman {

    private static String[] words = new String[]{"word", "football", "car"};
    
    private static final int MAX_ATTEMPTS = 4;
    private String word;
    private String playerName;
    private char[] searchedWordRepresentation;
    private int attempts = MAX_ATTEMPTS;
    
    Random rand = new Random();
    int n = rand.nextInt(words.length);
    
    public Hangman(){
        this.word = words[n];
        this.searchedWordRepresentation = new char[this.word.length()];
        Arrays.fill(this.searchedWordRepresentation, '_');
    }
    
    @Override
    public void AcceptName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.playerName = name;
    }

    @Override
    public void AcceptLetter(char letter) {
        boolean inWord = false;
        for (int i = 0; i < this.word.length(); i++) {
            if (this.word.charAt(i) == letter) {
                this.searchedWordRepresentation[i] = letter;
                inWord = true;
                break;
            }
        }

        if (checkForWin()) {
            System.out.println(this.playerName + " - win the game");
            return;
        }
        
        if (!inWord) {
            this.attempts--;
            if (checkForEndOfTheGame()) {
                System.out.println("End of the game");
                return;
            }
        }
        printOnConsole();
    }
    
    private boolean checkForEndOfTheGame(){
        boolean endGame=false;
        if (this.attempts == MAX_ATTEMPTS) {
            endGame = true;
        }
        return endGame;
    }
    
    private boolean checkForWin(){
        boolean isWin = true;
        for (int i = 0; i < searchedWordRepresentation.length; i++) {
            if (this.searchedWordRepresentation[i] == '_') {
                isWin = false;
                break;
            }
        }
        return isWin;
    }
    
    private void printOnConsole(){
        System.out.println(Arrays.toString(this.searchedWordRepresentation));
        System.out.println(this.playerName + " - " + this.attempts + " attempts left");
    }
    

}
