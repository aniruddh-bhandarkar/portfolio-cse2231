import components.Airplane.Airplane1;
import components.Airplane.AirplaneKernel.Mode;

/**
 * This utility class simulates an airplane's flight phase by updating and
 * displaying the airplane's metrics such as altitude, speed, and fuel quantity
 * over a specified duration.
 */
public final class ResetAirplane {

    /**
     * Reset Airplane Intialization.
     */
    private ResetAirplane() {
        throw new UnsupportedOperationException(
                "Utility class should not be instantiated");
    }

    /**
     * The main method that initializes an airplane and simulates a flight
     * phase.
     *
     * @param args
     *            Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        // Initialize a new Airplane instance
        Airplane1 airplane = new Airplane1();

        // Simulate the "Takeoff" phase of the flight
        simulatePhase("Takeoff", airplane, 1, 2, 1, -1);

        // Output message indicating simulation completion
        System.out.println("Simulation Complete!");
    }

    /**
     * Simulates a specific phase of the flight (e.g., takeoff, cruising) by
     * updating the airplane's altitude, speed, and fuel quantity over a given
     * duration. The metrics are updated in each iteration of the phase.
     *
     * @param phaseName
     *            The name of the phase (e.g., "Takeoff").
     * @param airplane
     *            The airplane instance whose metrics will be updated.
     * @param duration
     *            The number of iterations (representing time) for the phase.
     * @param altitudeChange
     *            The change in altitude for each iteration.
     * @param speedChange
     *            The change in speed for each iteration.
     * @param fuelChange
     *            The change in fuel quantity for each iteration.
     */
    public static void simulatePhase(String phaseName, Airplane1 airplane,
            int duration, double altitudeChange, double speedChange,
            double fuelChange) {
        System.out.println("Phase: " + phaseName);

        // Update metrics for each iteration in the phase
        for (int i = 0; i < duration; i++) {
            // Update Altitude
            if (airplane.isDefined(Mode.ALTITUDE)) {
                // If altitude is defined, add the change to the current value
                airplane.setMetric(Mode.ALTITUDE,
                        airplane.getMetric(Mode.ALTITUDE) + altitudeChange);
            } else {
                // If altitude is not defined, set it to the change value
                airplane.setMetric(Mode.ALTITUDE, altitudeChange);
            }

            // Update Speed
            if (airplane.isDefined(Mode.SPEED)) {
                // If speed is defined, add the change to the current value
                airplane.setMetric(Mode.SPEED,
                        airplane.getMetric(Mode.SPEED) + speedChange);
            } else {
                // If speed is not defined, set it to the change value
                airplane.setMetric(Mode.SPEED, speedChange);
            }

            // Update Fuel Quantity
            if (airplane.isDefined(Mode.FUEL_QUANTITY)) {
                // If fuel quantity is defined, add the change to the current value
                airplane.setMetric(Mode.FUEL_QUANTITY,
                        airplane.getMetric(Mode.FUEL_QUANTITY) + fuelChange);
            } else {
                // If fuel quantity is not defined, set it to the change value
                airplane.setMetric(Mode.FUEL_QUANTITY, fuelChange);
            }

            // Display the updated metrics after each iteration
            System.out
                    .println("Altitude: " + airplane.getMetric(Mode.ALTITUDE));
            System.out.println("Speed: " + airplane.getMetric(Mode.SPEED));
            System.out.println(
                    "Fuel Quantity: " + airplane.getMetric(Mode.FUEL_QUANTITY));
            System.out.println();
        }
    }
}
