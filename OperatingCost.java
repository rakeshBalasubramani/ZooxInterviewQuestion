package zoox;

/**
 * @author rakeshbalasubramani The Operating cost for each flight class.
 */
public class OperatingCost {
	double fixedRate;
	double perMileRate;
	static private OperatingCost economy = new OperatingCost(0, .10);
	static private OperatingCost premium = new OperatingCost(10, .25);
	static private OperatingCost business = new OperatingCost(50, .50);

	public static OperatingCost getOperatingCost(TicketClass klass) {
		switch (klass) {
		case Economy:
			return economy;
		case Premium:
			return premium;
		case Business:
			return business;
		default:
			return null;
		}
	}

	private OperatingCost(double fixedRate, double perMileRate) {
		super();
		this.fixedRate = fixedRate;
		this.perMileRate = perMileRate;
	}

}
