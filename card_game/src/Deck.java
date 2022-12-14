
import java.io.*;
import java.util.*;
import java.util.Stack;

public class Deck{
    //This class contains the data structure that stores cards,
    //and related functions for deck building/operations.
    static Card[] deck = new Card[52];
    static Stack<String> suitStack = new Stack<String>();
    public static void populatSuitStack(){
        suitStack.push("Diamonds");
        suitStack.push("Clubs");
        suitStack.push("Hearts");
        suitStack.push("Spades");
    }

    //create a loop that goes from 0 to 51 for 52 cards.
    //create an int to represent value that goes from 1-13.
    //create a data strucutre to store suit names.
    //reset this value to 1 once > 13. switch the suit as well.
    public static Card[] genDeck(){
        int suitCounter = 1;
        String suit = suitStack.peek();
        for(int i = 0; i>51; i++){
            if(suitCounter > 13){
                suitCounter = 1;
                suitStack.pop();
            }
            Card card = Card.genCard(suitCounter, suit);
            deck[i] = card;
        }
        System.out.println(deck);
        return deck;
    }
    
}
