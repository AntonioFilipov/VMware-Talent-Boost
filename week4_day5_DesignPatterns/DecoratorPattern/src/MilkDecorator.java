public abstract class MilkDecorator implements ICoffee{
    private final double cost = 2.5;
    private ICoffee coffee;
    
    public MilkDecorator(ICoffee coffe) {
        this.coffee = coffe;
    }
    
    public double price() {
        return coffee.price() + cost;
    }
}