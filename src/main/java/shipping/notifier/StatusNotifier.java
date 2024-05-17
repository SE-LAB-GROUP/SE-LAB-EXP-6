package shipping.notifier;

import shipping.model.PackageStatus;
import shipping.strategy.ExpressShippingStrategy;
import shipping.strategy.ShippingStrategy;
import shipping.strategy.StandardShippingStrategy;

import java.util.Scanner;

/**
 * Notifies the user about the status and shipping cost of a package.
 * <p>
 * Allows the user to update the shipping strategy and package status interactively.
 */
public class StatusNotifier {

    private final ShippingStrategy standardShippingStrategy = new StandardShippingStrategy();

    private final ShippingStrategy expressShippingStrategy = new ExpressShippingStrategy();

    private final Scanner scanner = new Scanner(System.in);

    private final Double packageWeight;


    private PackageStatus packageStatus;

    private ShippingStrategy shippingStrategy;


    public PackageStatus getPackageStatus() {
        return packageStatus;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }


    /**
     * Constructs a new StatusNotifier with the specified package weight.
     *
     * @param packageWeight The weight of the package.
     */
    public StatusNotifier(Double packageWeight) {
        this.packageWeight = packageWeight;
        this.packageStatus = PackageStatus.IN_TRANSIT;
        this.shippingStrategy = standardShippingStrategy;
    }

    /**
     * Runs the status notifier, allowing the user to update the shipping strategy and package status interactively.
     */
    public void run() {
        System.out.println("Running status notifier...");
        while (packageStatus != PackageStatus.DELIVERED) {
            System.out.println("--------------------------------------------------");
            updateShippingStrategy();
            updateStatus();
            System.out.printf(
                "Package is %s and shipping strategy is %s its shipping price is %f.%s",
                packageStatus,
                shippingStrategy.getShippingMethodName(),
                calculateShippingPrice(),
                System.lineSeparator()
            );
        }
    }

    public Double calculateShippingPrice() {
        return shippingStrategy.calculateShippingCost(packageWeight);
    }


    private void updateShippingStrategy() {
        while (true) {
            System.out.println("Please enter shipping strategy:");
            System.out.println("1. Standard");
            System.out.println("2. Express");
            try {
                int sendStrategyNumber = Integer.parseInt(scanner.nextLine());
                switch (sendStrategyNumber) {
                    case 1:
                        shippingStrategy = standardShippingStrategy;
                        break;
                    case 2:
                        shippingStrategy = expressShippingStrategy;
                        break;
                    default:
                        throw new IllegalArgumentException("Shipping strategy number should be 1 or 2.");
                }
                break;
            } catch (Exception e) {
                System.err.println("Shipping strategy number should be 1 or 2.");
            }
        }
    }

    private void updateStatus() {
        while (true) {
            System.out.println("Please enter package status:");
            System.out.println("1. In-Transit");
            System.out.println("2. Delivered");
            try {
                int statusNumber = Integer.parseInt(scanner.nextLine());
                switch (statusNumber) {
                    case 1:
                        packageStatus = PackageStatus.IN_TRANSIT;
                        break;
                    case 2:
                        packageStatus = PackageStatus.DELIVERED;
                        break;
                    default:
                        throw new IllegalArgumentException("Status number should be 1 or 2.");
                }
                break;
            } catch (Exception e) {
                System.err.println("Status number should be 1 or 2.");
            }
        }
    }
}
