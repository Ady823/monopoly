import java.util.ArrayList;
public class Player {
    int money;
    int location; 
    ArrayList<Property> properties = new ArrayList<Property>();
    String name;

    public Player() {
        this.money = 1500; 
        this.location = 0;
        this.name = "Player";
    }

    public Player(String name) {
        this.money = 1500;
        this.location = 0;
        this.name = name;
    }

    public void roll() {
        this.location += Math.random() * 6 + 1 + (Math.random() * 6 + 1);
        if (this.location > 39) {
            this.location -= 40;
            this.money += 200;
        }
        if (this.location > 39) {
            this.location -= 40;
            this.passGo();
        }
        System.out.println(this.name + " rolled and moved to " + this.location);
        System.out.println(this.name + " has $" + this.money);

        
    }

    public void buy() {
        // Validate location to ensure it's within bounds
        if (this.location >= 0 && this.location < Monopoly.properties.size()) {
            // Get the property at the player's current location
            Property property = Monopoly.properties.get(this.location);
    
            // Check if the property is available for purchase
            if (property.getOwner() == null) {
                if (this.money >= property.getPrice()) {
                    this.money -= property.getPrice();
                    this.properties.add(property);
                    property.setOwner(this);
                    System.out.println(this.name + " bought " + property.getName());
                } else {
                    System.out.println("Not enough money to buy " + property.getName());
                }
            } else {
                System.out.println(property.getName() + " is already owned by " + property.getOwner().getName());
            }
        } else {
            System.out.println("Invalid location: " + this.location);
        }
    }

    public void sell(Property property) {
        if (this.properties.contains(property)) {
            this.money += property.getPrice();
            this.properties.remove(property);
            property.setOwner(null);
        } else {
            System.out.println("You do not own " + property.getName());
        } 
    }

    public void passGo() {
        this.money += 200;
        System.out.println(this.name + " passed Go and collected $200");
    }

    public String getName() {
        return this.name;
    }

    public int getMoney() {
        return this.money;
    }

    public int getLocation() {
        return this.location;
    }

    public ArrayList<Property> getProperties() {
        return this.properties;
    }
    
}
