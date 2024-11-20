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

}
