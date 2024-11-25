public interface Airplane extends AirplaneKernel {
    /**
     * @return String
     */
    String displayDefinedMetrics();

    /**
     *
     * @return String
     */
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
    int hashCode();

}