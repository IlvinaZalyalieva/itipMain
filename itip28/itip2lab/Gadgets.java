public abstract class Gadgets {
    protected String brand;
    protected String color;
    protected float price;
    private boolean isWorking;
    public Gadgets(String brand, String color, float price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
    public Gadgets() {
        this("Apple", "white", 999);
    }

    public float getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
    public boolean getWorking() {
        return isWorking;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setWorking(boolean working) {
        isWorking = working;
    }
    public void on() {
        this.isWorking = true;
    }
    public void off() {
        this.isWorking = false;
    }
    public abstract String describe();
    public abstract void displayInfo();
}


