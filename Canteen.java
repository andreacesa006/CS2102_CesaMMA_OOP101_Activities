import java.util.Scanner;

public class Canteen{
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] items = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};

        double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};

        int totalQuantity = 0;
        double totalBefore = 0;
        double totalDisc = 0;
        
        System.out.println("=====   M E N U   =====");
        for(int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-10s - $%.2f%n", i + 1, items[i], prices[i]);
        }
        
        System.out.println();

        String orderAgain = "Y";

        while(orderAgain.equalsIgnoreCase ("Y")){
            System.out.print("Enter item number: ");
            int itemNum = scanner.nextInt();

            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();
            
            if(itemNum < 1 || itemNum > 5 || qty < 1 || qty > 10){
                System.out.println();
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                System.out.println();

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next();
                System.out.println();

            } else {
                System.out.print("Are you a student? (Y/N): ");
                String student = scanner.next();
                System.out.println();

                double price = prices[itemNum - 1];
                double subtotal = price * qty;
                double discount = 0;
                
                if(student.equalsIgnoreCase("Y") && subtotal >= 500) {
                    discount = subtotal * 0.15;

                } else if (student.equalsIgnoreCase("Y")){
                    discount = subtotal * 0.10;

                } else if (subtotal >= 500) {
                    discount = subtotal * 0.05;
                } 
                
                double orderTotal = subtotal - discount;
                System.out.printf("Subtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", orderTotal);
                System.out.println();

                totalQuantity = totalQuantity + qty;
                totalBefore = totalBefore + subtotal;
                totalDisc = totalDisc + discount;

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next();
                System.out.println();
            }

        }

        double finalAmount = totalBefore - totalDisc;

        System.out.println("===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalQuantity);
        System.out.printf("Total before discount: $%.2f%n", totalBefore);
        System.out.printf("Total discount: $%.2f%n", totalDisc);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}