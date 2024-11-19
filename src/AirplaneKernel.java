
import java.util.Scanner;

import components.standard.Standard;

/**
 * Airplane Kernel extending the standard.
 */
public interface AirplaneKernel extends Standard<Airplane> {
    /**
     * Enum for airplane modes.
     */
    enum Mode {
        /**
         * Airplane mode values.
         */
        ALTITUDE(0), DIRECTION(1), SPEED(2), FUEL_QUANTITY(3),
        /**
         * Airplane mode values.
         */
        OUTSIDE_AIR_TEMPERATURE(4), WIND_SPEED(5);

        /**
         * Final mode value.
         */
        private final int modeValue;

        /**
         * Constructor for mode.
         *
         * @param modeValue
         *            The integer value representing the mode.
         */
        Mode(int modeValue) {
            this.modeValue = modeValue;
        }

        /**
         * Displays mode values and prompts the user to enter a value for a
         * selected mode.
         */
        public static void getModeValue() {
            Scanner scanner = new Scanner(System.in);

            // Display available modes
            System.out.println("Available modes:");
            for (Mode mode : Mode.values()) {
                System.out.println(mode.name() + ": " + mode.modeValue);
            }

            // Prompt the user to enter a mode name
            System.out.println("Enter a mode name from the list above:");
            String modeInput = scanner.next().toUpperCase();

            // Check if the input matches any of the mode names
            boolean validMode = false;
            for (Mode mode : Mode.values()) {
                if (mode.name().equals(modeInput)) {
                    validMode = true;
                    System.out.println("You selected mode " + mode.name()
                            + " with value: " + mode.modeValue);

                    // Prompt the user to enter a value for the selected mode
                    System.out
                            .println("Enter a value for " + mode.name() + ":");
                    double userValue = scanner.nextDouble();

                    // Display the entered value
                    System.out.println("You entered " + userValue + " for mode "
                            + mode.name());
                    break;
                }
            }

            if (!validMode) {
                System.out.println("Invalid mode name entered.");
            }

            // Close the scanner
            scanner.close();
        }
    }
}
