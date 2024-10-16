
public enum AirplaneMode {
    /**
     * Airplane mode values
     */
    ALTITUDE(0), DIRECTION(1), SPEED(2), FUEL_QUANTITY(
            3), OUTSIDE_AIR_TEMPERATURE(4), WIND_SPEED(5);

    /**
     *  final value
     */
    private final int modeValue;

    /**
     * Example Field
     * @param modeValue
     */
    AirplaneMode(int modeValue) {
        this.modeValue = modeValue;
    }

    /**
     * Main Method in action
     * @return Mode Value
     */
    public int getModeValue() {
        return this.modeValue;
    }
}