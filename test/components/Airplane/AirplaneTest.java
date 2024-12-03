package components.Airplane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import components.Airplane.AirplaneKernel.Mode;

/**
 * Test class for {@link AirplaneSecondary}.
 */
public class AirplaneTest {

    /**
     * Altitude mode.
     */
    private static final int ALTITUDE_MODE = 35000;
    /**
     * Direction mode.
     */
    private static final int DIRECTION_MODE = 90;

    /**
     * Creates a generic instance of AirplaneSecondary for testing purposes.
     * 
     * @return Airplane Secondary
     */
    private AirplaneSecondary createTestAirplane() {
        return new AirplaneSecondary() {
            private final Map<Mode, Double> metrics = new HashMap<>();

            @Override
            public boolean isDefined(Mode mode) {
                // Simulates which modes are defined for this instance
                return this.metrics.containsKey(mode);
            }

            @Override
            public double getMetric(Mode mode) {
                // Return metric from the internal Map
                return this.metrics.getOrDefault(mode, 0.0);
            }

            @Override
            public void setMetric(Mode mode, double value) {
                this.metrics.put(mode, value);
            }

            @Override
            public void clear() {
                this.metrics.clear();
            }

            @Override
            public void setAltitude(double altitude) {
                // Set the altitude in the metrics map
                this.setMetric(Mode.ALTITUDE, altitude);
            }

            @Override
            public double getAltitude() {
                // Get the altitude from the metrics map
                return this.getMetric(Mode.ALTITUDE);
            }

            @Override
            public void setSpeed(double speed) {
                // Set the speed in the metrics map
                this.setMetric(Mode.SPEED, speed);
            }

            @Override
            public double getSpeed() {
                // Get the speed from the metrics map
                return this.getMetric(Mode.SPEED);
            }

            @Override
            public void setDirection(int direction) {
                // Set the direction as a double in the metrics map
                this.setMetric(Mode.DIRECTION, (double) direction);
            }

            @Override
            public int getDirection() {
                // Retrieve the direction and cast it back to an int
                return (int) this.getMetric(Mode.DIRECTION);
            }

            @Override
            public double getFuelQuantity() {
                // Get the fuel quantity from the metrics map
                return this.getMetric(Mode.FUEL_QUANTITY);
            }

            @Override
            public Airplane newInstance() {
                // Create a new instance of the current Airplane
                return AirplaneTest.this.createTestAirplane();
            }

            @Override
            public void transferFrom(Airplane airplane) {
                // Transfer all metrics from another airplane
                if (airplane instanceof AirplaneSecondary) {
                    AirplaneSecondary other = (AirplaneSecondary) airplane;
                    for (Mode mode : Mode.values()) {
                        if (other.isDefined(mode)) {
                            this.setMetric(mode, other.getMetric(mode));
                        }
                    }
                }
            }
        };
    }

    /**
     * Tests the {@link AirplaneSecondary#toString()} method.
     */
    @Test
    public void testToString() {
        AirplaneSecondary airplane = this.createTestAirplane();
        airplane.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane.setMetric(Mode.DIRECTION, DIRECTION_MODE);
        String expected = "Airplane [Altitude=" + ALTITUDE_MODE + ",Direction="
                + DIRECTION_MODE + "]";
        assertEquals("toString() should return a formatted string.", expected,
                airplane.toString());
    }

    /**
     * Tests the {@link AirplaneSecondary#equals(Object)} method for same
     * object.
     */
    @Test
    public void testEqualsSameObject() {
        AirplaneSecondary airplane = this.createTestAirplane();
        assertTrue("Equals should return true for the same object.",
                airplane.equals(airplane));
    }

    /**
     * Tests the {@link AirplaneSecondary#equals(Object)} method for objects
     * with same state.
     */
    @Test
    public void testEqualsSameState() {
        AirplaneSecondary airplane1 = this.createTestAirplane();
        airplane1.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane1.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        AirplaneSecondary airplane2 = this.createTestAirplane();
        airplane2.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane2.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        assertTrue("Equals should return true for objects with the same state.",
                airplane1.equals(airplane2));
    }

    /**
     * Tests the {@link AirplaneSecondary#equals(Object)} method for objects
     * with different states.
     */
    @Test
    public void testEqualsDifferentState() {
        AirplaneSecondary airplane1 = this.createTestAirplane();
        airplane1.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane1.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        AirplaneSecondary airplane2 = this.createTestAirplane();
        airplane2.setMetric(Mode.ALTITUDE, 30000.0); // Different value
        airplane2.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        assertFalse(
                "Equals should return false for objects with different states.",
                airplane1.equals(airplane2));
    }

    /**
     * Tests the {@link AirplaneSecondary#equals(Object)} method for null
     * comparison.
     */
    @Test
    public void testEqualsNull() {
        AirplaneSecondary airplane = this.createTestAirplane();
        assertFalse("Equals should return false when comparing to null.",
                airplane.equals(null));
    }

    /**
     * Tests the {@link AirplaneSecondary#equals(Object)} method for different
     * class comparison.
     */
    @Test
    public void testEqualsDifferentClass() {
        AirplaneSecondary airplane = this.createTestAirplane();
        Object nonAirplaneObject = new Object();
        assertFalse(
                "Equals should return false for objects of different classes.",
                airplane.equals(nonAirplaneObject));
    }

    /**
     * Tests the {@link AirplaneSecondary#hashCode()} method for consistency.
     */
    @Test
    public void testHashCodeConsistency() {
        AirplaneSecondary airplane = this.createTestAirplane();
        airplane.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        int hashCode1 = airplane.hashCode();
        int hashCode2 = airplane.hashCode();
        assertEquals("hashCode should be consistent across multiple calls.",
                hashCode1, hashCode2);
    }

    /**
     * Tests the {@link AirplaneSecondary#hashCode()} method for objects with
     * same state.
     */
    @Test
    public void testHashCodeSameState() {
        AirplaneSecondary airplane1 = this.createTestAirplane();
        airplane1.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane1.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        AirplaneSecondary airplane2 = this.createTestAirplane();
        airplane2.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane2.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        assertEquals("hashCode should return the same value for equal objects.",
                airplane1.hashCode(), airplane2.hashCode());
    }

    /**
     * Tests the {@link AirplaneSecondary#hashCode()} method for objects with
     * different states.
     */
    @Test
    public void testHashCodeDifferentState() {
        AirplaneSecondary airplane1 = this.createTestAirplane();
        airplane1.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane1.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        AirplaneSecondary airplane2 = this.createTestAirplane();
        airplane2.setMetric(Mode.ALTITUDE, 30000.0); // Different value
        airplane2.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        assertEquals(
                "hashCode should return"
                        + "different values for objects with different states.",
                airplane1.hashCode(), airplane2.hashCode());
    }

    /**
     * Tests clearing all metrics from an AirplaneSecondary object.
     */
    @Test
    public void testClearMetrics() {
        AirplaneSecondary airplane = this.createTestAirplane();
        airplane.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane.setMetric(Mode.DIRECTION, DIRECTION_MODE);
        airplane.clear();
        assertFalse("All metrics should be cleared.",
                airplane.isDefined(Mode.DIRECTION));
    }

    /**
     * Tests the transfer of metrics between two Airplane objects.
     */
    @Test
    public void testTransferFrom() {
        AirplaneSecondary airplane1 = this.createTestAirplane();
        airplane1.setMetric(Mode.ALTITUDE, ALTITUDE_MODE);
        airplane1.setMetric(Mode.DIRECTION, DIRECTION_MODE);

        AirplaneSecondary airplane2 = this.createTestAirplane();
        airplane2.transferFrom(airplane1);

        assertEquals("Airplane2 should have the same metrics as Airplane1",
                airplane1.getMetric(Mode.ALTITUDE),
                airplane2.getMetric(Mode.ALTITUDE), 0.001);
        assertEquals("Airplane2 should have the same metrics as Airplane1",
                airplane1.getMetric(Mode.DIRECTION),
                airplane2.getMetric(Mode.DIRECTION), 0.001);
    }
}
