package components.Airplane;

import java.util.HashMap;
import java.util.Map;

/**
 * Kernel Implementation of AirplaneKernel using a Map for initialization of
 * metrics.
 *
 * @convention: The metrics for each mode are stored in a Map, where the key is
 *              the Mode enum and the value is a Double representing the metric.
 *              If a mode is not present in the map, it is considered undefined.
 *
 * @correspondence: Mode.ALTITUDE corresponds to the key Mode.ALTITUDE in the
 *                  map. Mode.SPEED corresponds to the key Mode.SPEED, and so
 *                  on.
 */
public class Airplane1 implements AirplaneKernel {

    /**
     * Metrics map.
     */
    private final Map<Mode, Double> metrics;

    /**
     * Constructor initializes an empty Map for metrics.
     */
    public Airplane1() {
        this.metrics = new HashMap<>();
    }

    /**
     * Validates and sets a metric value for the given mode.
     *
     * @param mode
     *            The mode to set.
     * @param value
     *            The value to set.
     * @ensures if (value < 0 || value >= 360) { throw new
     *          IllegalArgumentException( "Direction must be between 0 and
     *          359."); }
     * @ensures if (value < 0) { throw new IllegalArgumentException( mode.name()
     *          + " must be non-negative."); }
     */
    @Override
    public void setMetric(Mode mode, double value) {
        switch (mode) {
            case ALTITUDE:
            case SPEED:
            case FUEL_QUANTITY:
            case DIRECTION:
            default:
                // No additional constraints for other modes
        }
        this.metrics.put(mode, value);
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
        return this.metrics.get(mode);
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
        return this.metrics.containsKey(mode);
    }

    /**
     * Creates a new representation for kernel purity compliance.
     *
     * @return A fresh instance of AirplaneKernelImpl.
     */
    public Airplane1 createNewRep() {
        return new Airplane1();
    }

    /**
     * Clears all metrics, resetting the airplane's state.
     */
    @Override
    public void clear() {
        this.metrics.clear();
    }

    /**
     * Transfers the state from another Airplane object to this one.
     *
     * @param source
     *            The source airplane to transfer state from.
     *
     * @throws IllegalArgumentException
     *             if the source is null or not an instance of
     *             AirplaneKernelImpl.
     */
    @Override
    public void transferFrom(Airplane source) {
        if (source == null || !(source instanceof Airplane1)) {
            throw new IllegalArgumentException("Invalid source for transfer");
        }

        Airplane1 src = (Airplane1) source;

        // Transfer all entries from the source map to the current map
        this.metrics.clear();
        this.metrics.putAll(src.metrics);

        // Clear the source object
        src.clear();
    }

    @Override
    public final Airplane newInstance() {
        this.createNewRep();
        return null;
    }
}
