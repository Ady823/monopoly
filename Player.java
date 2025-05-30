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
        this.location += 1 + Math.random() * 6 + Math.random() * 6; // Simulate rolling two dice
        if (this.location > Monopoly.properties.size() - 1) {
            this.location -= Monopoly.properties.size();
            this.passGo();
        }

        System.out.println(this.name + " rolled and moved to " + Monopoly.properties.get(this.location).getName());
        System.out.println(this.name + " has $" + this.money);
        checkBankruptcy();
        payRent(Monopoly.properties.get(this.location));
    }

public void buy(Property property) {
        if (this.location == 0) {
        System.out.println("You cannot buy 'Go'.");
        return;
    }

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
            System.out.println(this.name + " has $" + this.money);
            checkBankruptcy();
}

//selling a property owned by the current player
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

    public void checkBankruptcy() {
    if (this.money <= 0) {
        System.out.println(this.name + " is bankrupt! Game over.");
        System.exit(0);
    }
}
    public void payRent(Property property) {
    if (property.getOwner() != null && property.getOwner() != this) {
        int rent = property.getRent();
        if (this.money >= rent) {
            this.money -= rent;
            property.getOwner().money += rent;
            System.out.println(this.name + " paid $" + rent + " rent to " + property.getOwner().getName());
        } else {
            // Not enough money to pay rent
            property.getOwner().money += this.money;
            System.out.println(this.name + " paid $" + this.money + " rent to " + property.getOwner().getName() + " and is now bankrupt!");
            this.money = 0;
            checkBankruptcy();
        }
    }
}
    
}
