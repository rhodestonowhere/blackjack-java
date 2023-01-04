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
        Card[] newDeck = new Card[deck.length - 1];
        for(int i = 0, k = 0; i < deck.length; i++){
            if(i == index){
                continue;
            }
            newDeck[k] = deck[i];
            k++;
        }
        return newDeck;
    }
    
    //prints the hand of the inputted participant.
    public void printHand(Participant par){
        for(int i = 0; i < par.hand.size(); i++){
            //special cases for cards with value 1, 11-13 to account for Ace and Face cards
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
                case 1:
                    System.out.println("A" + " of " + par.hand.get(i).suit);
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

    //evaluate the special case of ace
    public void evalAce(Participant par){
        for(int i = 0; i < par.hand.size(); i++){
            if(par.hand.get(i).value == 1){
                if(par.handValue + 10 <= 21){
                    par.handValue += 10;
                }
            }
        }
    }
    
    //randomly gets a card from a deck.
    public Card[] hit(Card[] deck){
        //generate random int
        int randInt = generator.nextInt(deck.length-1);
        //grab index of randomInt
        Card randCard = deck[randInt];
        hand.add(randCard);
        //special cases to account for face cards for calculating hand value
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
        //remove card from deck so it cannot be drawn again
        deck = removeCard(deck, randInt);
        return deck;
    }
}