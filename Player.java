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

    public void roll(int die1, int die2) {
        this.location += die1 + die2;
        if (this.location > 39) {
            this.location -= 40;
            this.money += 200;
        }
    }
    public void buy(Property property) {
        if (this.money >= property.getPrice()) {
            this.money -= property.getPrice();
            this.properties.add(property);
            property.setOwner(this);
        } else {
            System.out.println("Not enough money to buy " + property.getName());
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
