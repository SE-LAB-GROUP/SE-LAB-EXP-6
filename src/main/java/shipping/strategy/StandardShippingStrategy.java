package shipping.strategy;

/**
 * Implementation of the shipping.strategy.ShippingStrategy interface for standard shipping.
 *
 * @see ShippingStrategy
 */
public class StandardShippingStrategy implements ShippingStrategy {

    @Override
    public String getShippingMethodName() {
        return "Standard";
    }

    @Override
    public Double calculateShippingCost(Double packageWeight) {
        return packageWeight * 2.5;
    }
}
