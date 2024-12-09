package components.Airplane;

import components.standard.Standard;

/**
 * Airplane Kernel extending the standard.
 */
public interface AirplaneKernel extends Standard<Airplane> {
    /**
     * Mode.
     */
    enum Mode {
        /**
         * Airplane mode values.
         */
        ALTITUDE(0), DIRECTION(1), SPEED(2), FUEL_QUANTITY(3),
        /**
         * Air Temperature.
         */
        OUTSIDE_AIR_TEMPERATURE(4), WIND_SPEED(5);

        /**
         * final value.
         */
        private final int modeValue;

        /**
         * Example Field.
         *
         * @param modeValue
         */
        Mode(int modeValue) {
            this.modeValue = modeValue;
        }

        /**
         * Main Method in action.
         *
         * @return Mode Value
         */
        public int getModeValue() {
            System.out.println(" ");
            return this.modeValue;
        }
    }

    /**
     * Get Metric using the mode value used.
     *
     * @param mode
     * @return metric
     */
    double getMetric(Mode mode);

    /**
     * Set Metric the mode and value.
     *
     * @param mode
     * @param value
     */
    void setMetric(Mode mode, double value);

    /**
     * Is defined for the mode.
     *
     * @param mode
     * @return defined value
     */
    boolean isDefined(Mode mode);

}
