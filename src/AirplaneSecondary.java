/**
 * The secondary methods for AirplaneKernel.
 */
public interface AirplaneSecondary {

    /**
     * Adjusts the airplane's altitude incrementally.
     *
     * @param increment
     *            The altitude increment value (can be positive or negative).
     */
    void adjustAltitude(double increment);

    /**
     * Adjusts the airplane's speed incrementally.
     *
     * @param increment
     *            The speed increment value (can be positive or negative).
     */
    void adjustSpeed(double increment);

    /**
     * Adjusts the airplane's direction incrementally.
     *
     * @param increment
     *            The direction increment value (in degrees, can be positive or
     *            negative).
     */
    void adjustDirection(int increment);

    /**
     * Calculates the remaining flight time based on current speed and fuel.
     *
     * @return Estimated flight time in hours.
     */
    double calculateRemainingFlightTime();
}
