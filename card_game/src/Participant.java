import java.util.*;

class Participant{
    //This class represents the two participants of the game: the dealer and the player.
    //This class containts all necessary structures and information for participants of the game.

     List<Card> hand = new ArrayList<Card>();
     Random generator = new Random();
     int handValue = 0;

    //remove card from list
    public Card[] removeCard(Card[] deck, int index){
        if (deck == null || index < 0 || index >= deck.length){
            return deck;
        }
        // System.out.println("start of removeCard");
        // System.out.println("removing card: " + deck[index].value + " of " + deck[index].suit);
        Card[] newDeck = new Card[deck.length - 1];
        for(int i = 0, k = 0; i < deck.length; i++){
            if(i == index){
                continue;
            }
            newDeck[k] = deck[i];
            k++;
        }
        // System.out.println("///////////////////////////////////");
        // System.out.println("printing deck in removeCard");
        // System.out.println("///////////////////////////////////");
        // for(int i =0; i<newDeck.length-1;i++){
        //     System.out.println(newDeck[i].value + " of " + newDeck[i].suit);        
        // }
        // System.out.println("///////////////////////////////////");
        return newDeck;
    }
    
    //prints the hand of the inputted participant.
    public void printHand(Participant par){
        for(int i = 0; i < par.hand.size(); i++){
            switch(par.hand.get(i).value){
                case 11:
                    System.out.println("J" + " of " + par.hand.get(i).suit);
                    break;
                case 12:
                    System.out.println("Q" + " of " + par.hand.get(i).suit);
                    break;
                case 13:
                    System.out.println("K" + " of " + par.hand.get(i).suit);
                    break;
                default:
                    System.out.println(par.hand.get(i).value + " of " + par.hand.get(i).suit);
            }
        }

    }

    //evaluates the participant's hand to playing or bust
    public boolean evalHand(Participant par){
        //if bust return true
        //else false
        if(par.handValue > 21){
            return true;
        }
        else{
            return false;
        }
    }
    
    //randomly gets a card from a deck.
    public Card[] hit(Card[] deck){
        int randInt = generator.nextInt(deck.length);
        //System.out.println(randInt);
        Card randCard = deck[randInt];
        //System.out.println(randCard.value + " " + randCard.suit);
        hand.add(randCard);
        switch(randCard.value){
            case 11:
                handValue += 10;
                break;
            case 12:
                handValue += 10;
                break;
            case 13:
                handValue += 10;
                break;
            default:
                handValue += randCard.value;
        }
        //handValue += randCard.value;
        deck = removeCard(deck, randInt);
        // System.out.println("====================================");
        // System.out.println("printing deck in hit");
        // System.out.println("====================================");
        // for(int i =0; i<deck.length-1;i++){
        //     System.out.println(deck[i].value + " of " + deck[i].suit);        
        // }
        // System.out.println("====================================");
        return deck;
        //System.out.println("Size of list: " + hand.size());
    }
}