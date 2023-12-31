public class Laptop extends Gadgets {
    private double screenSize;
    private String model;
    private String typeOfProcessor;
    private static int totalCount = 0;
    private boolean position;

    public Laptop(String brand, String color, float price, double screenSize, String model, String typeOfProcessor) {
        super(brand, color, price);
        this.screenSize = screenSize;
        this.model = model;
        this.typeOfProcessor = typeOfProcessor;
        totalCount = totalCount + 1;
    }
    public Laptop(){
        this("Apple", "black", 1199, 15.6, "air", "m2");
    }
    public double getScreenSize() {
        return screenSize;
    }public String getModel() {
        return model;
    }public String getTypeOfProcessor() {
        return typeOfProcessor;
    }public void setModel(String model) {
        this.model = model;
    }public void setModel(String firstModel, String secondModel) {
        this.model = firstModel + " " + secondModel;
    }public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }public void setTypeOfProcessor(String typeOfProcessor) {
        this.typeOfProcessor = typeOfProcessor;
    }public void open(){
        this.position = true;
    }public void close(){
        this.position = false;
    }
    @Override
    public String describe() {
        return "Ноутбук";
    }
    @Override
    public void displayInfo(){
        System.out.printf("Мы создали ноутбук со следущими параметрами: %s, %s, %s", this.model, this.position, this.screenSize );
    }
    public static int getTotalCount() {
        return totalCount;
    }
}