package shipping.strategy;

/**
 * Implementation of the shipping.strategy.ShippingStrategy interface for express shipping.
 *
 * @see ShippingStrategy
 */
public class ExpressShippingStrategy implements ShippingStrategy {

    @Override
    public String getShippingMethodName() {
        return "Express";
    }

    @Override
    public Double calculateShippingCost(Double packageWeight) {
        return packageWeight * 3.5;
    }
}
