/**
 * Airplane.
 */
public interface Airplane {

    /**
     * Sets the altitude of the airplane.
     *
     * @param altitude
     *            The new altitude value.
     */
    void setAltitude(double altitude);

    /**
     * Gets the current altitude of the airplane.
     *
     * @return The current altitude.
     */
    double getAltitude();

    /**
     * Sets the speed of the airplane.
     *
     * @param speed
     *            The new speed value.
     */
    void setSpeed(double speed);

    /**
     * Gets the current speed of the airplane.
     *
     * @return The current speed.
     */
    double getSpeed();

    /**
     * Sets the direction of the airplane.
     *
     * @param direction
     *            The new direction in degrees.
     */
    void setDirection(int direction);

    /**
     * Gets the current direction of the airplane.
     *
     * @return The current direction.
     */
    int getDirection();

    /**
     * Gets the fuel quantity of the airplane.
     *
     * @return The current fuel quantity.
     */
    double getFuelQuantity();
}
