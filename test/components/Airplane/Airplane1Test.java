package components.Airplane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test for the Kernel.
 *
 */
public class Airplane1Test {

    /**
     * private airplane setter.
     */
    private Airplane1 airplane;

    /**
     * Adding the before clause.
     */
    @Before
    public void setUp() {
        this.airplane = new Airplane1();
    }

    /**
     * Test for get and set metric.
     */
    @Test
    public void testSetAndGetMetric() {
        final int alt = 35000;
        final int speed = 550;
        this.airplane.setMetric(AirplaneKernel.Mode.ALTITUDE, alt);
        this.airplane.setMetric(AirplaneKernel.Mode.SPEED, speed);

        assertEquals(alt, this.airplane.getMetric(AirplaneKernel.Mode.ALTITUDE),
                alt);
        assertEquals(speed, this.airplane.getMetric(AirplaneKernel.Mode.SPEED),
                speed);
    }

    /**
     * Test for get and set metric.
     */
    @Test
    public void testIsDefined() {
        final int alt = 35000;
        this.airplane.setMetric(AirplaneKernel.Mode.ALTITUDE, alt);

        assertTrue("Altitude should be defined.",
                this.airplane.isDefined(AirplaneKernel.Mode.ALTITUDE));
        assertFalse("Speed should not be defined.",
                this.airplane.isDefined(AirplaneKernel.Mode.SPEED));
    }

    /**
     * Test for get and set metric.
     */
    @Test
    public void testClear() {
        final int alt = 35000;
        this.airplane.setMetric(AirplaneKernel.Mode.ALTITUDE, alt);
        this.airplane.setMetric(AirplaneKernel.Mode.SPEED, 1);

        this.airplane.clear();

        assertFalse("Altitude should not be defined after clear.",
                this.airplane.isDefined(AirplaneKernel.Mode.ALTITUDE));
        assertFalse("Speed should not be defined after clear.",
                this.airplane.isDefined(AirplaneKernel.Mode.SPEED));
    }

}
