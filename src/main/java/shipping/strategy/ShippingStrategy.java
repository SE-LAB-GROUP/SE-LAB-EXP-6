package shipping.strategy;

/**
 * Interface representing a shipping strategy.
 */
public interface ShippingStrategy {

    /**
     * @return The name of the shipping method as a String.
     */
    String getShippingMethodName();

    /**
     * Calculates the shipping cost based on the package weight.
     *
     * @param packageWeight The weight of the package in kilograms.
     * @return The shipping cost as a Double value.
     */
    Double calculateShippingCost(Double packageWeight);
}
