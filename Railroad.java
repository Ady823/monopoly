
public class Railroad extends Property{
    public Railroad(String name, int price, int location) {
        super(name, price, location, 25, 50, 100, 200);

    }

    public int getRent() {
        int rent = 0;
        int numRailroads = 0;
        for (Property property : owner.properties) {
            if (property instanceof Railroad) {
                numRailroads++;
            }
        }
        switch (numRailroads) {
            case 1:
                rent = 25;
                break;
            case 2:
                rent = 50;
                break;
            case 3:
                rent = 100;
                break;
            case 4:
                rent = 200;
                break;
            default:
                rent = 0;
        }
        return rent;
    }
}
