import org.junit.Test;
import shipping.strategy.ExpressShippingStrategy;
import shipping.strategy.StandardShippingStrategy;

import static org.junit.Assert.assertEquals;

public class ShippingStrategyTest {

    @Test
    public void standardStrategyTest() {
        StandardShippingStrategy standardShippingStrategy = new StandardShippingStrategy();
        assertEquals("Standard", standardShippingStrategy.getShippingMethodName());
        assertEquals(125.0, standardShippingStrategy.calculateShippingCost(50.0), 1e-6);
    }

    @Test
    public void expressStrategyTest() {
        ExpressShippingStrategy expressShippingStrategy = new ExpressShippingStrategy();
        assertEquals("Express", expressShippingStrategy.getShippingMethodName());
        assertEquals(175.0, expressShippingStrategy.calculateShippingCost(50.0), 1e-6);
    }
}
