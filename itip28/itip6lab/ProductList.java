import java.util.concurrent.ConcurrentHashMap;

public class ProductList {
    private ConcurrentHashMap<String, Integer> sales;
    public ProductList() {sales = new ConcurrentHashMap<>();}
    public void addProduct(String item, int number) {
        sales.put(item, sales.getOrDefault(item, 0) + number);
    }
    public void printProduct() {
        System.out.println(sales.keySet());
        for (String item : sales.keySet()) {
            System.out.println(item + ": " + sales.get(item));
        }
    }
    public double getProductAll() {
        double total = 0;
        for (int number : sales.values()) {
            total += number;
        }
        return total;
    }
    public String getPopular() {
        String popular = "";
        int maxn = 0;
        for (String item : sales.keySet()) {
            if (sales.get(item) > maxn) {
                maxn = sales.get(item);
                popular = item;
            }
        }
        return popular;
    }

    public static void main(String[] args) {
        ProductList list = new ProductList();
        list.addProduct("мишка", 1);
        list.addProduct("зайчик", 5);
        list.addProduct("антилопа", 11);
        list.printProduct();
        System.out.println("Всего продаж " + list.getProductAll());
        System.out.println("самая популярная позиция " + list.getPopular());
    }
}


