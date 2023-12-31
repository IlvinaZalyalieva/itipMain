import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class Rabotyagi {
    public static void main(String[] args) {
        List<Integer> products = new ArrayList<>();
        products.add(60);
        products.add(65);
        products.add(40);
        products.add(40);
        products.add(50);
        Product product = new Product(products);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executor);
        for (int i = 0; i < 3; i++) {
            completionService.submit(new Move(product));
        }
        int res = 0;
        for (int i = 0; i < 3; i++) {
            try {
                Future<Integer> result = completionService.take();
                res += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("result " + res);
        executor.shutdown();
    }
}
class Product {
    private List<Integer> products;
    public Product(List<Integer> products) {
        this.products = products;}
    public List<Integer> getProducts() {
        return products;}
}
class Move implements Callable<Integer> {
    private static final int MAX_W = 150;
    private Product product;
    public Move(Product product) {
        this.product = product;}
    @Override
    public Integer call() {
        List<Integer> products = product.getProducts();
        int weight = 0;
        int productsMove = 0;
        for (int product : products) {
            if (weight + product <= MAX_W) {
                weight += product;
                productsMove++;
            } else {
                break;
            }}
        return productsMove;}
}
