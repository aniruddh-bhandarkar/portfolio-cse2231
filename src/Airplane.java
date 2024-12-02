/**
 * Airplane Used for standard.
 */
public interface Airplane extends AirplaneKernel {
    /**
     * @return String
     */
    String displayDefinedMetrics();

    /**
     *
     * @return String
     */
    @Override
    String toString();

    /**
     *
     * @return value
     */
    boolean equals();

    /**
     *
     * @return integer
     */
    @Override
    int hashCode();

}
