/**
 * Airplane Secondary.
 */
public abstract class AirplaneSecondary implements Airplane {

    @Override
    public final String toString() {
        return "Airplane [" + "Altitude=" + this.getMetric(Mode.ALTITUDE) + ","
                + "Direction=" + this.getMetric(Mode.DIRECTION) + "]";
    }

    @Override
    public final boolean equals(Object obj) {
        // Step 1: Check if the reference is the same
        if (this == obj) {
            return true;
        }
        // Step 2: Check for null and class compatibility
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // Step 3: Cast the object to the current class type
        AirplaneSecondary other = (AirplaneSecondary) obj;

        // Step 4: Compare all metrics (each Mode field)
        for (Mode mode : Mode.values()) {
            // Check if one metric is defined and the other is not
            if (this.isDefined(mode) != other.isDefined(mode)) {
                return false;
            }

            // If both are defined, compare their values
            if (this.isDefined(mode) && Double.compare(this.getMetric(mode),
                    other.getMetric(mode)) != 0) {
                return false;
            }
        }

        // Step 5: If all metrics match, return true
        return true;
    }

    @Override
    public final int hashCode() {
        int result = 2;
        final int num = 63;
        for (Mode mode : Mode.values()) {
            if (this.isDefined(mode)) {
                result = num * result; //2^6-1
            }
        }
        return result;
    }
}
