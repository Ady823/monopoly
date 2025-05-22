import java.util.ArrayList;
import java.util.Scanner;

public class Monopoly{
    public static ArrayList<Property> properties = new ArrayList<Property>();

    public static void main(String [] args) {
        properties.add(new Property("Go", 0));
        Scanner scanner = new Scanner(System.in);

        Property mediterraneanAvenue = new Property("Mediterranean Avenue", 60, 2, 1, 4, 10, 30, 90, 160, 250); 
        Property balticAvenue = new Property("Baltic Avenue", 60, 4, 4, 8, 20, 60, 180, 320, 450);
       // Property readingRailroad = new Railroad("Reading Railroad", 200); 
      /*  Property pennsylvaniaRailroad = new Railroad("Pennsylvania Railroad", 200);
        Property bnoRailroad = new Railroad("B&O Railroad", 200);
        Property shortLineRailroad = new Railroad("Short Line Railroad", 200);
        Property electricCompany = new Utility("Electric Company", 150); 
        Property waterWorks = new Utility("Water Works", 150); */
        Property vermontAvenue = new Property("Vermont Avenue", 100, 9, 6, 12, 30, 90, 270, 400, 550);
        Property connecticutAvenue = new Property("Connecticut Avenue", 120, 10, 8, 16, 40, 100, 300, 450, 600); 
        Property stCharlesPlace = new Property("St. Charles Place", 140, 12, 10, 20, 50, 150, 450, 625, 750); 
        Property statesAvenue = new Property("States Avenue", 140, 14, 10, 20, 50, 150, 450, 625, 750);
        Property virginiaAvenue = new Property("Virginia Avenue", 160, 15, 12, 24, 60, 180, 500, 700, 900);
        Property stJamesPlace = new Property("St. James Place", 180, 12, 14, 28, 70, 200, 550, 750, 950);
        Property tennesseeAvenue = new Property("Tennessee Avenue", 180, 18, 14, 28, 70, 200, 550, 750, 950);
        Property newYorkAvenue = new Property("New York Avenue", 200, 19, 16, 32, 80, 220, 600, 800, 1000);
        Property kentuckyAvenue = new Property("Kentucky Avenue", 220, 21, 18, 36, 90, 250, 700, 875, 1050);
        Property indianaAvenue = new Property("Indiana Avenue", 220, 23, 18, 36, 90, 250, 700, 875, 1050);
        Property illinoisAvenue = new Property("Illinois Avenue", 240, 24, 20, 40, 100, 300, 750, 925, 1100);
        Property atlanticAvenue = new Property("Atlantic Avenue", 260, 26, 22, 44, 110, 330, 800, 975, 1150);
        Property ventnorAvenue = new Property("Ventnor Avenue", 260, 27, 22, 44, 110, 330, 800, 975, 1150);
        Property marvinGardens = new Property("Marvin Gardens", 280, 29, 24, 48, 120, 360, 850, 1025, 1200);
        Property pacificAvenue = new Property("Pacific Avenue", 300, 31, 26, 52, 130, 390, 900, 1100, 1275);
        Property northCarolinaAvenue = new Property("North Carolina Avenue", 300, 32, 26, 52, 130, 390, 900, 1100, 1275);
        Property pennsylvaniaAvenue = new Property("Pennsylvania Avenue", 320, 34, 28, 56, 150, 450, 1000, 1200, 1400);
        Property parkPlace = new Property("Park Place", 350, 37, 35, 70, 175, 500, 1100, 1300, 1500);
        Property boardwalk = new Property("Boardwalk", 400, 39, 50, 100, 200, 600, 1400, 1700, 2000);






        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        Player currentPlayer = player1;
        while(true){
            System.out.println(currentPlayer.name + ", enter 'roll' to roll or 'buy' to buy the property at your location:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("roll")) {
             currentPlayer.roll();
            } else if (input.equalsIgnoreCase("buy")) {
             currentPlayer.buy(properties.get(currentPlayer.location));
            } else if (input.equalsIgnoreCase("sell")) {
                System.out.println("Enter the name of the property you want to sell:");
                String propertyName = scanner.nextLine();
                Property propertyToSell = null;
                for (Property property : currentPlayer.properties) {
                    if (property.getName().equalsIgnoreCase(propertyName)) {
                        propertyToSell = property;
                        break;
                    }
                }
                if (propertyToSell != null) {
                    currentPlayer.sell(propertyToSell);
                } else {
                    System.out.println("You do not own that property.");
                }
            }
             // Switch to the other player for the next turn
            if (currentPlayer == player1) {
                  currentPlayer = player2;
            } else {
                 currentPlayer = player1;
            }
        }
    }
}

