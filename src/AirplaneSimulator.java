import components.Airplane.Airplane1;
import components.Airplane.AirplaneKernel.Mode;

/**
 * Simulates the operation of an airplane through various phases such as
 * takeoff, cruising, and landing.
 */
public class AirplaneSimulator {
    /**
     * Airplane.
     */
    private final Airplane1 airplane;

    /**
     * Constructs a new AirplaneSimulator instance and initializes the airplane.
     */
    public AirplaneSimulator() {
        this.airplane = new Airplane1();
    }

    /**
     * Starts the simulation by simulating the takeoff, cruising, and landing
     * phases. Outputs the airplane's metrics at each step.
     */
    public void startSimulation() {
        System.out.println("Starting Airplane Simulation...\n");

        // Simulate the phases of the flight
        this.simulatePhase("Takeoff", 3, 2000, 100, -50);
        // Simulate takeoff
        this.simulatePhase("Cruising", 3, 0, 0, -200);
        // Simulate cruising
        this.simulatePhase("Landing", 3, -2000, -100, 0);
        // Simulate landing

        System.out.println("\nSimulation Complete!");
    }

    /**
     * Simulates a specific phase of the flight by updating altitude, speed, and
     * fuel quantity over a given duration.
     *
     * @param phaseName
     *            The name of the phase (e.g., "Takeoff", "Cruising",
     *            "Landing").
     * @param duration
     *            The number of iterations (representing time) for the phase.
     * @param altitudeChange
     *            The change in altitude for each iteration.
     * @param speedChange
     *            The change in speed for each iteration.
     * @param fuelChange
     *            The change in fuel quantity for each iteration.
     */
    private void simulatePhase(String phaseName, int duration,
            double altitudeChange, double speedChange, double fuelChange) {
        System.out.println("Phase: " + phaseName);

        // Update metrics for each iteration in the phase
        for (int i = 0; i < duration; i++) {
            this.updateMetricWithoutTernary(Mode.ALTITUDE, altitudeChange);
            this.updateMetricWithoutTernary(Mode.SPEED, speedChange);
            this.updateMetricWithoutTernary(Mode.FUEL_QUANTITY, fuelChange);

            // Display the current metrics after updating
            this.displayMetrics();
            this.sleep(1000);
            // Simulate a time delay of 1 second
        }
    }

    /**
     * Updates the specified metric (altitude, speed, or fuel) by the given
     * change. If the metric is defined, it adds the change to the current
     * value, otherwise sets it.
     *
     * @param mode
     *            The mode of the metric to update (e.g., ALTITUDE, SPEED,
     *            FUEL_QUANTITY).
     * @param change
     *            The value to change the metric by.
     */
    private void updateMetricWithoutTernary(Mode mode, double change) {
        if (this.airplane.isDefined(mode)) {
            // If the metric is defined, update it by adding the change
            double currentValue = this.airplane.getMetric(mode);
            this.airplane.setMetric(mode, currentValue + change);
        } else {
            // If the metric is not defined, set it to the change value
            this.airplane.setMetric(mode, change);
        }
    }

    /**
     * Displays the current values of the airplane's altitude, speed, and fuel
     * quantity. If a metric is not defined, it prints "Not Defined".
     */
    private void displayMetrics() {
        // Display Altitude
        System.out.print("Altitude: ");
        if (this.airplane.isDefined(Mode.ALTITUDE)) {
            System.out.println(this.airplane.getMetric(Mode.ALTITUDE));
        } else {
            System.out.println("Not Defined");
        }

        // Display Speed
        System.out.print("Speed: ");
        if (this.airplane.isDefined(Mode.SPEED)) {
            System.out.println(this.airplane.getMetric(Mode.SPEED));
        } else {
            System.out.println("Not Defined");
        }

        // Display Fuel Quantity
        System.out.print("Fuel Quantity: ");
        if (this.airplane.isDefined(Mode.FUEL_QUANTITY)) {
            System.out.println(this.airplane.getMetric(Mode.FUEL_QUANTITY));
        } else {
            System.out.println("Not Defined");
        }
        System.out.println();
    }

    /**
     * Pauses the simulation for the specified number of milliseconds.
     *
     * @param milliseconds
     *            The number of milliseconds to pause.
     */
    private void sleep(int milliseconds) {
        try {
            // Pause for the specified time
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // If interrupted, restore the interrupt status
            Thread.currentThread().interrupt();
        }
    }

    /**
     * The main method that initializes and starts the airplane simulation.
     *
     * @param args
     *            Command-line arguments (not used in this case).
     */
    public static void main(String[] args) {
        AirplaneSimulator simulator = new AirplaneSimulator();
        simulator.startSimulation();
    }
}
