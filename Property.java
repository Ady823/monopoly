import java.util.ArrayList;
public class Property {
    String name;
    int price;
    int location;
    int houses = 0;
    int hotels = 0;

    ArrayList<Integer> rents = new ArrayList<Integer>();
    Player owner;
    boolean isMortgaged;
    public Property() {
    }

    public Property(String name, int price) {
        this.name = name;
        this.price = price;
        Monopoly.properties.add(this);
    }

    public Property(String name, int price, int location, int rent1, int rent2, int rent3, int rent4, int rent5, int rent6, int rent7) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.rents.add(rent1);
        this.rents.add(rent2);
        this.rents.add(rent3);
        this.rents.add(rent4);
        this.rents.add(rent5);
        this.rents.add(rent6);
        this.rents.add(rent7);
        Monopoly.properties.add(this);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return this.owner;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getRent() {
        if (this.owner == null) {
            return 0;
        }
        int propertyCount = this.owner.properties.size();
        if (propertyCount > 0 && propertyCount <= this.rents.size()) {
            return this.rents.get(propertyCount - 1); 
        }
        return 0; 
    }

    public void mortgage() {
        this.isMortgaged = true;
        this.owner.money += this.price / 2;
    }

    public void unmortgage() {
        this.isMortgaged = false;
        this.owner.money -= this.price / 2;
    }

    public boolean isMortgaged() {
        return this.isMortgaged;
    } 

    public boolean addHouse() {
    if (this.houses < 4) { // Monopoly: max 4 houses before hotel
        this.houses++;
        System.out.println("A house was added to " + this.name + ". Total houses: " + this.houses);
        return true;
    } else {
        System.out.println(this.name + " already has 4 houses. Buy a hotel instead!");
        return false;
    }
}
}


