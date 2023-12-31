public class Watches extends Gadgets {
    private boolean waterproof;
    private String typeWatch;
    private String shapeWatch;
    private int hour=10;
    private int minutes=44;
    public Watches(String brand, String color, float price, boolean waterproof, String typeWatch, String shapeWatch) {
        super(brand, color, price);
        this.waterproof = waterproof;
        this.shapeWatch = shapeWatch;
        this.typeWatch = typeWatch;
    }public Watches(){
        this("Apple", "black", 399, true, "mechanic", "squad");
    }
    public String getTypeWatch() {
        return typeWatch;
    }
    public String getShapeWatch() {
        return shapeWatch;
    }
    public boolean getWaterproof() {
        return waterproof;
    }
    public void setShapeWatch(String shapeWatch) {
        this.shapeWatch = shapeWatch;
    }
    public void setTypeWatch(String typeWatch) {
        this.typeWatch = typeWatch;
    }
    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }
    public int getHour() {
        return hour;
    }

    public int getMinutes() {
        return minutes;
    }
    public void changeHour(int hour){
        this.hour = hour;
    }
    public void changeMinutes(int minutes){
        this.minutes = minutes;
    }
    @Override
    public String describe() {
        return "Часы";
    }
    @Override
    public void displayInfo(){
        System.out.printf("Мы создали часы со следущими параметрами: %s, %s, %s", this.waterproof, this.typeWatch, this.shapeWatch );
    }
}