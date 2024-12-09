package components.Airplane;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.Airplane.AirplaneKernel.Mode;

/**
 * Combined JUnit test file for AirplaneSecondary and AirplaneKernel.
 */
public class AirplaneTest {

        /**
         * Single shared instance of Airplane for testing.
         */
        private static final Airplane airplaneTest = new Airplane1();

        /**
         * Test for getting and setting metrics.
         */
        @Test
        public void testSetAndGetMetric() {
                airplaneTest.clear(); // Reset state before test
                final int alt = 35000;
                final int speed = 550;

                airplaneTest.setMetric(Mode.ALTITUDE, alt);
                airplaneTest.setMetric(Mode.SPEED, speed);

                assertTrue(airplaneTest.isDefined(Mode.ALTITUDE));
                assertTrue(airplaneTest.isDefined(Mode.SPEED));
                assertEquals(alt, airplaneTest.getMetric(Mode.ALTITUDE), 0.001);
                assertEquals(speed, airplaneTest.getMetric(Mode.SPEED), 0.001);
        }

        /**
         * Test for checking if a metric is defined.
         */
        @Test
        public void testIsDefined() {
                airplaneTest.clear(); // Reset state before test
                final int alt = 35000;

                airplaneTest.setMetric(Mode.ALTITUDE, alt);

                assertTrue(airplaneTest.isDefined(Mode.ALTITUDE));
                assertFalse(airplaneTest.isDefined(Mode.SPEED));
        }

        /**
         * Test for clearing all metrics.
         */
        @Test
        public void testClear() {
                airplaneTest.clear(); // Reset state before test
                final int alt = 35000;
                final int speed = 1;

                airplaneTest.setMetric(Mode.ALTITUDE, alt);
                airplaneTest.setMetric(Mode.SPEED, speed);

                airplaneTest.clear();

                assertFalse(airplaneTest.isDefined(Mode.ALTITUDE));
                assertFalse(airplaneTest.isDefined(Mode.SPEED));
        }

        /**
         * Test for the toString() method.
         */
        @Test
        public void testToString() {
                airplaneTest.clear(); // Reset state before test
                airplaneTest.setMetric(Mode.ALTITUDE, 35000);
                airplaneTest.setMetric(Mode.DIRECTION, 90);

                String expected = "Airplane [Altitude=35000.0,Direction=90.0]";
                assertEquals("toString() should return a formatted string.",
                                expected, airplaneTest.toString());
        }

        /**
         * Test for equals() method with the same object.
         */
        @Test
        public void testEqualsSameObject() {
                airplaneTest.clear(); // Reset state before test
                assertTrue(airplaneTest.equals(airplaneTest));
        }

        /**
         * Test for equals() method with objects having the same state.
         */
        @Test
        public void testEqualsSameState() {
                airplaneTest.clear(); // Reset state before test
                this.setUpAirplane(35000, 90);

                Airplane airplane2 = new Airplane1();
                airplane2.setMetric(Mode.ALTITUDE, 35000);
                airplane2.setMetric(Mode.DIRECTION, 90);

                assertTrue(airplaneTest.equals(airplane2));
        }

        /**
         * Test for equals() method with objects having different states.
         */
        @Test
        public void testEqualsDifferentState() {
                airplaneTest.clear(); // Reset state before test
                this.setUpAirplane(35000, 90);

                airplaneTest.setMetric(Mode.ALTITUDE, 30000); // Change state

                Airplane airplane2 = new Airplane1();
                airplane2.setMetric(Mode.ALTITUDE, 35000);
                airplane2.setMetric(Mode.DIRECTION, 90);

                assertFalse(airplaneTest.equals(airplane2));
        }

        /**
         * Test for consistent hashCode() method.
         */
        @Test
        public void testHashCodeConsistency() {
                airplaneTest.clear(); // Reset state before test
                airplaneTest.setMetric(Mode.ALTITUDE, 35000);
                airplaneTest.setMetric(Mode.DIRECTION, 90);

                int hashCode1 = airplaneTest.hashCode();
                int hashCode2 = airplaneTest.hashCode();

                assertEquals("hashCode should be consistent across multiple calls.",
                                hashCode1, hashCode2);
        }

        /**
         * Test for transferring metrics between two airplane objects.
         */
        @Test
        public void testTransferFrom() {
                airplaneTest.clear(); // Reset state before test
                this.setUpAirplane(35000, 90);

                Airplane airplane2 = new Airplane1();
                airplane2.setMetric(Mode.ALTITUDE, 30000);
                airplane2.setMetric(Mode.SPEED, 550);

                airplaneTest.transferFrom(airplane2);

                // After transfer, airplaneTest should have airplane2's metrics
                assertEquals("Altitude should be transferred.", 30000,
                                airplaneTest.getMetric(Mode.ALTITUDE), 0.001);
                assertEquals("Speed should be transferred.", 550,
                                airplaneTest.getMetric(Mode.SPEED), 0.001);

                // airplane2 should now be cleared
                assertFalse("Altitude should not be defined in source after transfer.",
                                airplane2.isDefined(Mode.ALTITUDE));
                assertFalse("Speed should not be defined in source after transfer.",
                                airplane2.isDefined(Mode.SPEED));
        }

        /**
         * Helper method to set up an Airplane with given metrics.
         *
         * @param altitude
         *                Altitude value.
         * @param direction
         *                Direction value.
         */
        private void setUpAirplane(double altitude, double direction) {
                airplaneTest.clear(); // Reset state before setup
                airplaneTest.setMetric(Mode.ALTITUDE, altitude);
                airplaneTest.setMetric(Mode.DIRECTION, direction);
        }
}
