public class Smartphone extends Gadgets {
    private String os;
    private float display;
    private int numberOfCameras;
    private int photos=0;
    private int videos=0;
    public Smartphone(String brand, String color, float price, String os, float display, int numberOfCameras) {
        super(brand, color, price);
        this.os = os;
        this.display = display;
        this.numberOfCameras = numberOfCameras;
    }
    public Smartphone(){
        this("Apple", "black", 999, "ios", 11, 3);
    }
    public float getDisplay() {
        return display;
    }

    public String getOs() {
        return os;
    }

    public int getNumberOfCameras() {
        return numberOfCameras;
    }

    public void setDisplay(float display) {
        this.display = display;
    }

    public void setNumberOfCameras(int numberOfCameras) {
        this.numberOfCameras = numberOfCameras;
    }

    public void setOs(String os) {
        this.os = os;
    }
    public void memoriesPhoto(){
        this.photos += 1;
    }
    public int getPhotos() {
        return photos;
    }
    public int getVideos() {
        return videos;
    }public void memoriesVideo(){
        this.videos +=1;
    }@Override
    public String describe() {
        return "Смартфон";
    }@Override
    public void displayInfo(){
        System.out.printf("Мы создали смартфон со следущими параметрами: %s, %s, %s", this.os, this.numberOfCameras, this.display );
    }
}