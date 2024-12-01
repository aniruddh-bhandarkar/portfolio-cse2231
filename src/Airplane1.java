/**
 * Kernel Implementation of AirplaneKernel where in each Mode corresponds to a
 * separate field.
 *
 * @convention: Each mode has a corresponding field to represent its metric. If
 *              a mode is undefined, its field will hold a special value, such
 *              as `Double.NaN`.
 *
 * @correspondence: Mode.ALTITUDE corresponds to the `altitude` field.
 *                  Mode.SPEED corresponds to the `speed` field.
 */
public class Airplane1 implements AirplaneKernel {

    /**
     * The various Altitude.
     */
    private double altitude = Double.NaN;
    private double speed = Double.NaN;
    private double direction = Double.NaN;
    private double fuelQuantity = Double.NaN;
    private double outsideAirTemperature = Double.NaN;
    private double windSpeed = Double.NaN;

    /**
     * Constructor initializes all fields to NaN (undefined).
     */
    public Airplane1() {
        // No need to initialize fields as they are already initialized to NaN by default
    }

    /**
     * Validates and sets a metric value for the given mode.
     *
     * @param mode
     *            The mode to set.
     * @param value
     *            The value to set.
     */
    @Override
    public void setMetric(Mode mode, double value) {
        switch (mode) {
            case ALTITUDE:
            case SPEED:
            case FUEL_QUANTITY:
                if (value < 0) {
                    throw new IllegalArgumentException(
                            mode.name() + " must be non-negative.");
                }
                break;
            case DIRECTION:
                if (value < 0 || value >= 360) {
                    throw new IllegalArgumentException(
                            "Direction must be between 0 and 359.");
                }
                break;
            default:
                // No additional constraints for other modes
        }
        switch (mode) {
            case ALTITUDE:
                this.altitude = value;
                break;
            case SPEED:
                this.speed = value;
                break;
            case DIRECTION:
                this.direction = value;
                break;
            case FUEL_QUANTITY:
                this.fuelQuantity = value;
                break;
            case OUTSIDE_AIR_TEMPERATURE:
                this.outsideAirTemperature = value;
                break;
            case WIND_SPEED:
                this.windSpeed = value;
                break;
            default:
                break;
        }
    }

    /**
     * Retrieves the value of a metric for the given mode.
     *
     * @param mode
     *            The mode to retrieve.
     * @return The value of the metric.
     */
    @Override
    public double getMetric(Mode mode) {
        if (!this.isDefined(mode)) {
            throw new IllegalStateException(mode.name() + " is not defined.");
        }
        // Return the field corresponding to the mode
        switch (mode) {
            case ALTITUDE:
                return this.altitude;
            case SPEED:
                return this.speed;
            case DIRECTION:
                return this.direction;
            case FUEL_QUANTITY:
                return this.fuelQuantity;
            case OUTSIDE_AIR_TEMPERATURE:
                return this.outsideAirTemperature;
            case WIND_SPEED:
                return this.windSpeed;
            default:
                throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    /**
     * Checks if a metric is defined for the given mode.
     *
     * @param mode
     *            The mode to check.
     * @return True if the metric is defined, otherwise false.
     */
    @Override
    public boolean isDefined(Mode mode) {
        // Check if the field corresponding to the mode is defined (not NaN)
        switch (mode) {
            case ALTITUDE:
                return !Double.isNaN(this.altitude);
            case SPEED:
                return !Double.isNaN(this.speed);
            case DIRECTION:
                return !Double.isNaN(this.direction);
            case FUEL_QUANTITY:
                return !Double.isNaN(this.fuelQuantity);
            case OUTSIDE_AIR_TEMPERATURE:
                return !Double.isNaN(this.outsideAirTemperature);
            case WIND_SPEED:
                return !Double.isNaN(this.windSpeed);
            default:
                return false;
        }
    }

    /**
     * Creates a new representation for kernel purity compliance.
     *
     * @return A fresh instance of AirplaneKernelImpl.
     */
    public Airplane1 createNewRep() {
        return new Airplane1();
    }

    @Override
    public String toString() {
        // @correspondence: This toString method uses the Mode enum and checks if each
        // mode is defined, then includes it
        //in the output string. Modes that are undefined
        // will not be included in the output.
        StringBuilder sb = new StringBuilder("Airplane Metrics:\n");
        for (Mode mode : Mode.values()) {
            if (this.isDefined(mode)) {
                sb.append(mode.name()).append(": ").append(this.getMetric(mode))
                        .append("\n");
            } else {
                sb.append(mode.name()).append(": Not Defined\n");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Airplane1 other = (Airplane1) obj;
        return this.altitude == other.altitude && this.speed == other.speed
                && this.direction == other.direction
                && this.fuelQuantity == other.fuelQuantity
                && this.outsideAirTemperature == other.outsideAirTemperature
                && this.windSpeed == other.windSpeed;
    }

    @Override
    public int hashCode() {
        final int result = 31;
        // @correspondence: The hashCode is computed based on the defined modes only.
        // Each defined mode contributes to the final hash code.
        int result1 = 1 * result + Double.hashCode(this.altitude);
        return result1;
    }

    @Override
    public final void clear() {
        // Clears all fields by setting them to NaN
        this.altitude = Double.NaN;
        this.speed = Double.NaN;
        this.direction = Double.NaN;
        this.fuelQuantity = Double.NaN;
        this.outsideAirTemperature = Double.NaN;
        this.windSpeed = Double.NaN;
    }

    @Override
    public final Airplane newInstance() {
        // Creates and returns a new instance of AirplaneKernelImpl
        this.createNewRep();
        return null;
    }

    @Override
    public final void transferFrom(Airplane source) {
        source.equals(source);
    }

    /**
     * Main method for testing the implementation.
     *
     * @param args
     */
    public static void main(String[] args) {
        Airplane1 airplane = new Airplane1();

        // Set and retrieve metrics
        airplane.setMetric(Mode.ALTITUDE, 35000);
        airplane.setMetric(Mode.SPEED, 550);
        airplane.setMetric(Mode.DIRECTION, 90);

        System.out.println("Altitude: " + airplane.getMetric(Mode.ALTITUDE));
        System.out.println("Speed: " + airplane.getMetric(Mode.SPEED));
        System.out.println("Direction: " + airplane.getMetric(Mode.DIRECTION));

        // Display all metrics
        System.out.println(airplane);

        // Check equality
        Airplane1 Airplane2 = new Airplane1();
        Airplane2.setMetric(Mode.ALTITUDE, 35000);
        Airplane2.setMetric(Mode.SPEED, 550);
        Airplane2.setMetric(Mode.DIRECTION, 90);

        System.out.println("Airplanes equal " + airplane.equals(Airplane2));
    }
}
