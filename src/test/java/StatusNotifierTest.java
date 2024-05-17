import org.junit.Test;
import shipping.model.PackageStatus;
import shipping.notifier.StatusNotifier;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StatusNotifierTest {

    @Test
    public void testStandardDeliveredShipping() {
        // Arrange
        // Simulate user input: Choose Standard shipping, then Delivered status
        String input = "1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture printed text
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customOut = new PrintStream(outputStream);
        System.setOut(customOut);

        // Act
        StatusNotifier statusNotifier = new StatusNotifier(5.0); // Package weight
        statusNotifier.run();

        // Assert
        assertEquals("Standard", statusNotifier.getShippingStrategy().getShippingMethodName());
        assertEquals(PackageStatus.DELIVERED, statusNotifier.getPackageStatus());
        assertEquals(12.5, statusNotifier.calculateShippingPrice(), 1e-6);

        String printedText = outputStream.toString();
        String lineSeparator = System.lineSeparator();
        assertEquals(
            "Running status notifier..." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is DELIVERED and shipping strategy is Standard its shipping price is 12.500000." + lineSeparator,
            printedText
        );
    }

    @Test
    public void testExpressDeliveredShipping() {
        // Arrange
        // Simulate user input: Choose Express shipping, then Delivered status
        String input = "2\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture printed text
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customOut = new PrintStream(outputStream);
        System.setOut(customOut);

        // Act
        StatusNotifier statusNotifier = new StatusNotifier(5.0); // Package weight
        statusNotifier.run();

        // Assert
        assertEquals("Express", statusNotifier.getShippingStrategy().getShippingMethodName());
        assertEquals(PackageStatus.DELIVERED, statusNotifier.getPackageStatus());
        assertEquals(17.5, statusNotifier.calculateShippingPrice(), 1e-6);

        String printedText = outputStream.toString();
        String lineSeparator = System.lineSeparator();
        assertEquals(
            "Running status notifier..." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is DELIVERED and shipping strategy is Express its shipping price is 17.500000." + lineSeparator,
            printedText
        );
    }

    @Test
    public void testInTransitStandardShipping() {
        // Arrange
        // Simulate user input: Choose Express shipping, then Transit status
        // Then choose Standard shipping, then Delivered status
        String input = "2\n1\n1\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture printed text
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customOut = new PrintStream(outputStream);
        System.setOut(customOut);

        // Act
        StatusNotifier statusNotifier = new StatusNotifier(5.0); // Package weight
        statusNotifier.run();

        // Assert
        assertEquals("Standard", statusNotifier.getShippingStrategy().getShippingMethodName());
        assertEquals(PackageStatus.DELIVERED, statusNotifier.getPackageStatus());
        assertEquals(12.5, statusNotifier.calculateShippingPrice(), 1e-6);

        String printedText = outputStream.toString();
        String lineSeparator = System.lineSeparator();
        assertEquals(
            "Running status notifier..." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is IN_TRANSIT and shipping strategy is Express its shipping price is 17.500000." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is DELIVERED and shipping strategy is Standard its shipping price is 12.500000." + lineSeparator,
            printedText
        );
    }

    @Test
    public void testInTransitExpressShipping() {
        // Arrange
        // Simulate user input: Choose Standard shipping, then Transit status
        // Then choose Express shipping, then Delivered status
        String input = "1\n1\n2\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture printed text
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream customOut = new PrintStream(outputStream);
        System.setOut(customOut);

        // Act
        StatusNotifier statusNotifier = new StatusNotifier(5.0); // Package weight
        statusNotifier.run();

        // Assert
        assertEquals("Express", statusNotifier.getShippingStrategy().getShippingMethodName());
        assertEquals(PackageStatus.DELIVERED, statusNotifier.getPackageStatus());
        assertEquals(17.5, statusNotifier.calculateShippingPrice(), 1e-6);

        String printedText = outputStream.toString();
        String lineSeparator = System.lineSeparator();
        assertEquals(
            "Running status notifier..." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is IN_TRANSIT and shipping strategy is Standard its shipping price is 12.500000." + lineSeparator +
                "--------------------------------------------------" + lineSeparator +
                "Please enter shipping strategy:" + lineSeparator +
                "1. Standard" + lineSeparator +
                "2. Express" + lineSeparator +
                "Please enter package status:" + lineSeparator +
                "1. In-Transit" + lineSeparator +
                "2. Delivered" + lineSeparator +
                "Package is DELIVERED and shipping strategy is Express its shipping price is 17.500000." + lineSeparator,
            printedText
        );
    }
}
