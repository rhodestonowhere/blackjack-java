import java.util.Scanner;
import java.lang.Thread;

public class game {
    //This class is the main driver of the game of blackjack.
    public static void main(String[] args) throws Exception {
        //create deck
        Card[] deck = new Card[52];
        System.out.println("-------------------------------------");
        deck = Card.genDeck();
        System.out.println("-------------------------------------");
        Thread.sleep(500);
        System.out.println("=====================================");
        System.out.println("Welcome to Basic Blackjack(in Java)!");
        System.out.println("=====================================");
        //initialize participants' hands
        Participant player = new Participant();
        deck = player.hit(deck);
        deck = player.hit(deck);
        Participant house = new Participant();
        deck = house.hit(deck);
        deck = house.hit(deck);
        //initialize scanner
        Scanner input = new Scanner(System.in);
        //game loop
        int gameInt = 1;
        System.out.println("The game begins...");
        while(gameInt == 1){
            System.out.println("Your hand: ");
            player.printHand();
            if(player.handValue == 21){
                System.out.println("You win!");
                gameInt = 0;
                break;
            }
            System.out.println("Enter 1 to hit or 2 to stay.");
            String userInput = input.nextLine();
            System.out.println("User inputted: " + userInput);
            if(userInput.equals("1")){ //user has chosen to hit
                System.out.println("Chosen to hit.");
                Thread.sleep(1000);
                //add card to hand
                deck = player.hit(deck);
                player.evalAce();
                if(player.evalHand()){ //in the case the player has busted
                    Thread.sleep(500);
                    System.out.println("Player hand value is: ");
                    System.out.println(player.handValue);
                    Thread.sleep(500);
                    System.out.println("You busted!");
                    gameInt = 0;
                    break;
                }
                else{
                    continue;
                }
            }
            else if(userInput.equals("2")){ //user has chosen to stay
                //check for win
                System.out.println("Chosen to stand.");
                Thread.sleep(1000);
                player.evalAce();

                if(player.handValue == 21){
                    System.out.println("Player hand value is: ");
                    System.out.println(player.handValue);
                    System.out.println("You win!");
                    gameInt = 0;
                    break;
                }

                System.out.println("Player hand value is: ");
                System.out.println(player.handValue);
                System.out.println("House now plays.");
                //house logic
                //loop persists until house handValue is greater or equal to 17
                //house cannot continue to hit cards once a card value > 17 is reached
                while(house.handValue < 17){ 
                    System.out.println("House hits.");
                    Thread.sleep(700);
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
                        System.out.println("House has won!");
                    }
                    gameInt = 0;
                }

            }
            else{
                System.out.println("Please only enter 1 or 2.");
                continue;
            }
            
        }

    }
}
