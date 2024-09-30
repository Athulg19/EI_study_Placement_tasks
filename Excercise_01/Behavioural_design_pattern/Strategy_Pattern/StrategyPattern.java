package Excercise_01.Behavioural_design_pattern.Strategy_Pattern;
import java.util.ArrayList;
import java.util.List;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
    private String name;
    private String cardNumber;

    public CreditCardStrategy(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit card");
    }
}

class PaypalStrategy implements PaymentStrategy {
    private String emailId;

    public PaypalStrategy(String email) {
        this.emailId = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Paypal.");
    }
}

class ShoppingCart {
    private List<Product> products = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addProduct(Product product){
        products.add(product);
    }

    public void setPaymentStrategy(PaymentStrategy strategy){
        this.paymentStrategy = strategy;
    }

    public void checkout(){
        int total = products.stream().mapToInt(Product::getPrice).sum();
        paymentStrategy.pay(total);
    }
}

class Product {
    private int price;
    private String name;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Book", 30));
        cart.addProduct(new Product("Game", 60));

    
        cart.setPaymentStrategy(new PaypalStrategy("myemail@example.com"));
        cart.checkout();

  
        cart.setPaymentStrategy(new CreditCardStrategy("Alice", "1234567890123456"));
        cart.checkout();
    }
}
