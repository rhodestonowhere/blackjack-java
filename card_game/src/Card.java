
import java.util.Stack;

class Card{
    //This class will contain the attributes of an individual card
    //to be added to the deck.
    String suit = ""; //somewhat unecessary in a game of blackjack, but could be useful for other applications.
    int value = 0;

    public static Card genCard(int val, String suit){
        Card card = new Card();
        card.suit = suit;
        card.value = val;
        return card;
    }

    static Card[] deck = new Card[52];
    public static void populateSuitStack(Stack<String> suitStack){
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
        System.out.println("Starting genDeck Function.");
        int suitCounter = 1;
        Stack<String> suitStack = new Stack<String>();
        populateSuitStack(suitStack);
        String suit = suitStack.peek();
        System.out.println("before loop");
        for(int i = 0; i<51; i++){
            if(suitCounter > 13){
                suitCounter = 1;
                suitStack.pop();
                suit = suitStack.peek();
                System.out.println("Switching Suits.");
            }
            Card card = Card.genCard(suitCounter, suit);
            deck[i] = card;
            suitCounter++;
        }
        System.out.println("genDeck completed.");
        return deck;
    }
    
    
}