import java.util.Scanner;

/**
 * Airplane Mode.
 */
public enum AirplaneMode {
    /**
     * Airplane mode values.
     */
    ALTITUDE(0), DIRECTION(1), SPEED(2), FUEL_QUANTITY(3),
    /**
     * Air Temperature.
     */
    OUTSIDE_AIR_TEMPERATURE(4), WIND_SPEED(5);

    /**
     * Final value.
     */
    private final int modeValue;

    /**
     * Constructor.
     *
     * @param modeValue
     *            The integer value associated with each mode
     */
    AirplaneMode(int modeValue) {
        this.modeValue = modeValue;
    }

    /**
     * Method that prompts the user to select a mode and enter a value for it.
     */
    public void getModeValue() {
        Scanner scanner = new Scanner(System.in);

        // Display available modes
        System.out.println("Available modes:");
        for (AirplaneMode mode : AirplaneMode.values()) {
            System.out.println(mode.name() + ": " + mode.modeValue);
        }

        // Prompt the user to enter a mode name
        System.out.println("Enter a mode name from the list above:");
        String modeInput = scanner.next().toUpperCase();

        // Check if the input matches any of the mode names
        boolean validMode = false;
        for (AirplaneMode mode : AirplaneMode.values()) {
            if (mode.name().equals(modeInput)) {
                validMode = true;
                System.out.println("You selected mode " + mode.name()
                        + " with value: " + mode.modeValue);

                // Prompt the user to enter a value for the selected mode
                System.out.println("Enter a value for " + mode.name() + ":");
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
