/**
 * The secondary methods for AirplaneKernel, add the method bodies to finish the
 * abstract class assignment.
 */
public abstract class AirplaneSecondary implements Airplane {

    @Override
    public final String displayDefinedMetrics() {
        String output = "";
        for (Mode mode : Mode.values()) {
            if (this.isDefined(mode)) {
                output += this.getMetric(mode);
            }
        }
        return output;
    }

    @Override
    public final String toString() {
        return "Airplane [" + "Altitude=" + Mode.ALTITUDE + "," + "Direction="
                + Mode.DIRECTION + "]";
    }

    @Override
    public final boolean equals(Object obj) {

        AirplaneSecondary other = (AirplaneSecondary) obj;
        for (Mode mode : Mode.values()) {
            if (this.isDefined(mode)
                    && this.getMetric(mode) != other.getMetric(mode)) {
                return false; // Mismatch in defined values
            }
        }
        return true; //Default value
    }

    @Override
    public final int hashCode() {
        int result = 2;
        for (Mode mode : Mode.values()) {
            if (this.isDefined(mode)) {
                result = 63 * result; //2^6-1
            }
        }
        return result;
    }
}
