import java.util.ArrayList;
import java.util.Scanner;

public class Sale {

    Scanner in = new Scanner(System.in);
    private double haircutPrice = 200;
    private int date;
    private double totalPrice;
    ProductList products = new ProductList();
    DateList dateList = new DateList();


    public Sale() {

    }

    public Product addProduct() {
        Product product;

        System.out.println(products);
        System.out.println("Which item do you want to add?");
        int productChoice = in.nextInt();
        in.nextLine();

        product = products.getProductList().get(productChoice -1);
        return product;
    }

    public boolean addCredit(){
        System.out.println("Do you want to add Credit(yes/no): ");
        if (in.nextLine().equals("yes")){
            return true;
        } else {
            return false;
        }
    }

    public String checkSale(String inputDate) {
        setDate(inputDate);
        Date date1;
        date1 = DateList.dates.get(date);
        String output = date1.timesWithProducts();
        return output;
    }

    public void addSale(String inputDate, int time) {
        ArrayList<String> productNames = new ArrayList<>();
        Product product = new Product();
        double productPrice = 0;
        String productName;
        String addSale;
        boolean keepRunning = true;

        totalPrice = haircutPrice;
        setDate(inputDate);

        do {
            totalPrice = totalPrice + productPrice;
            System.out.println("Current Price: "  + ConsoleColors.YELLOW_BRIGHT + totalPrice
                    + ConsoleColors.RESET);
            System.out.println("Do you want to add a product? yes/no");
            addSale = in.nextLine();

            if (addSale.equals("yes")) {
                product = addProduct();
                productPrice = product.getPrice();
                productName = product.getProduct();
                productNames.add(productName);
            } else {
                keepRunning = false;
            }
        } while (keepRunning);
        boolean addCredit = addCredit();
        product.setHasCredit(addCredit);
        Date date1 = DateList.dates.get(date);
        String customerName = date1.timeSlot.getCustomerName();
        date1.appointments.set(time - 10, new TimeSlot(totalPrice, productNames, customerName, product.hasCredit()));
    }

    public void setDate(String input){
        date = dateList.checkDate(input);
    }

}
