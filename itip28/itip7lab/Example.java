import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Warehouse {
    private List<Integer> products;

    public Warehouse(List<Integer> products) {
        this.products = products;
    }

    public List<Integer> getProducts() {
        return products;
    }
}

class Loader implements Runnable {
    private static final int MAX_WEIGHT = 150;
    private Warehouse warehouse;

    public Loader(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        List<Integer> products = warehouse.getProducts();
        int weight = 0;
        List<Integer> productsToMove = new ArrayList<>();

        for (int product : products) {
            if (weight + product <= MAX_WEIGHT) {
                productsToMove.add(product);
                weight += product;
            } else {
                moveProducts(productsToMove);
                productsToMove.clear();
                weight = 0;
            }
        }

        if (!productsToMove.isEmpty()) {
            moveProducts(productsToMove);
        }
    }

    private void moveProducts(List<Integer> products) {
        System.out.println(Thread.currentThread().getName() + " is moving products: " + products);
        // Simulate moving products to another warehouse
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Example {
    public static void main(String[] args) {
        List<Integer> products = new ArrayList<>();
        products.add(60);
        products.add(65);
        products.add(40);
        products.add(40);
        products.add(50);

        Warehouse warehouse = new Warehouse(products);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executor.execute(new Loader(warehouse));
        }

        executor.shutdown();
    }
}