import java.util.Scanner;

import shipping.notifier.StatusNotifier;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get package weight
        double packageWeight;
        while (true) {
            System.out.println("Please enter package weight:");
            try {
                packageWeight = Double.parseDouble(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Invalid package weight");
            }
        }

        StatusNotifier statusNotifier = new StatusNotifier(packageWeight);
        statusNotifier.run();
    }
}
