import java.util.Scanner;

public class game {
    //This class is the main driver of the game of blackjack.
    public static void main(String[] args) throws Exception {
        // -------------------------------------------
        // DEBUG CODE
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
        //create deck
        Card[] deck = new Card[52];
        deck = Card.genDeck();
        System.out.println("-------------------------------------");
        //initialize participants' hands
        Participant player = new Participant();
        deck = player.hit(deck);
        deck = player.hit(deck);
        System.out.println("Player hand is: ");
        // for(int i = 0; i < player.hand.size(); i++){
        //     System.out.println(player.hand.get(i).value + " of " + player.hand.get(i).suit);
        // }
        player.printHand(player);
        // System.out.println("Player hand value is: " + player.handValue);
        // System.out.println("-------------------------------------");
        Participant house = new Participant();
        deck = house.hit(deck);
        deck = house.hit(deck);
        System.out.println("Dealer hand is: ");
        // for(int i = 0; i < player.hand.size(); i++){
        //     System.out.println(house.hand.get(i).value + " of " + house.hand.get(i).suit);
        // }
        // house.printHand(house);
        // System.out.println("Dealer hand value is: " + house.handValue);
        // System.out.println("-------------------------------------");
        // System.out.println("printing deck after hits");
        // System.out.println("-------------------------------------");
        // for(int i =0; i<deck.length-1;i++){
        //     System.out.println(deck[i].value + " of " + deck[i].suit);        
        // }
        
        Scanner input = new Scanner(System.in);
        //game loop
        int gameInt = 1;
        while(gameInt == 1){
            System.out.println("Begin game loop...");
            System.out.println("Your hand: ");
            player.printHand(player);
            System.out.println("Enter 1 to hit or 2 to stay.");
            String userInput = input.nextLine();
            System.out.println("User inputted: " + userInput);
            //System.out.println("data type: " + userInput.getClass());
            if(userInput.equals("1")){ //user has chosen to hit
                System.out.println("Chosen to hit.");
                //add card to hand
                deck = player.hit(deck);
                System.out.println("Your hand after hit: ");
                player.printHand(player);
                if(player.evalHand(player)){ //in the case the player has busted
                    System.out.println("Player hand value is: ");
                    System.out.println(player.handValue);
                    System.out.println("You busted!");
                    gameInt = 0;
                    break;
                }
                else{
                    continue;
                }
            }
            else if(userInput.equals("2")){ //user has chosen to stay
                System.out.println("Chosen to stand.");
                System.out.println("House now plays.");
                //house logic
                while(house.handValue < 17){ //loop persists until house handValue is greater or equal to 17
                    System.out.println("House hits.");
                    deck = house.hit(deck);
                }
                if(house.handValue > 21){
                    System.out.println("House has busted. Player wins!");
                    gameInt = 0;
                }
                else{
                    System.out.println("House hand value is: " + house.handValue);
                    if(player.handValue > house.handValue && player.handValue < 21){
                        System.out.println("Player has won!");
                    }
                    else{
                        System.out.println("House has won gg ez");
                    }
                    gameInt = 0;
                }

            }
            else{
                System.out.println("Please only enter 1 or 2.");
                continue;
            }
            
            //gameInt = 0;
            
        }

    }
}
