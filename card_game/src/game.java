public class game {
    //This class is the main driver of the game of blackjack.
    public static void main(String[] args) throws Exception {
        // -------------------------------------------
        // DECBUG CODE
        // -------------------------------------------
        // Card testT = new Card();
        // Deck testY = new Deck();
        // System.out.println(testT.test1);
        // System.out.println(testY.test1);
        // System.out.println(testY.card1.test1);
        // Card card1 = Card.genCard(5,"spades");
        // System.out.println(card1.value);
        // System.out.println(card1.suit);
        // -------------------------------------------
        Card[] deck = new Card[52];
        deck = Card.genDeck();
        System.out.println("-------------------------------------");
        Participant player = new Participant();
        deck = player.hit(deck);
        deck = player.hit(deck);
        System.out.println("Player hand is: ");
        for(int i = 0; i < player.hand.size(); i++){
            System.out.println(player.hand.get(i).value + " of " + player.hand.get(i).suit);
        }
        System.out.println("Player hand value is: " + player.handValue);
        System.out.println("-------------------------------------");
        Participant house = new Participant();
        deck = house.hit(deck);
        deck = house.hit(deck);
        System.out.println("Dealer hand is: ");
        for(int i = 0; i < player.hand.size(); i++){
            System.out.println(house.hand.get(i).value + " of " + house.hand.get(i).suit);
        }
        System.out.println("Dealer hand value is: " + house.handValue);
        System.out.println("-------------------------------------");
        System.out.println("printing deck after hits");
        System.out.println("-------------------------------------");
        for(int i =0; i<deck.length-1;i++){
            System.out.println(deck[i].value + " of " + deck[i].suit);        
        }

    }
}
