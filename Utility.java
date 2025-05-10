public class Utility extends Property{
    
    public Utility(String name, int price, int location) {
        super(name, price, location);
        
    }

    //TODO: implement getRent method 
    public int getRent() {
        int rent = 0;
        if (owner != null) {
            int numUtilities = 0;
            for (Property property : owner.getProperties()) {
                if (property instanceof Utility) {
                    numUtilities++;
                }
            }
            if (numUtilities == 1) {
                rent = 4 * owner.getLocation();
            } else if (numUtilities == 2) {
                rent = 10 * owner.getLocation();
            }
        }
        return rent;
    }
}
