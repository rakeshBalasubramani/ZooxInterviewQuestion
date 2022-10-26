package zoox;

/**
 * @author rakeshbalasubramani 
 * AirLine class contains the basic functionality of
 *         each airline.
 */
public class AirLine {
	public AirLine(double perMileRate, String name) {
		super();
		this.perMileRate = perMileRate;
		this.name = name;
	}

	double perMileRate;
	String name;

	public static AirLine getAirLineInstance(String name) {
		switch (name) {
		case "United":
			return United.getInstance();
		case "Delta":
			return Delta.getInstance();
		case "SouthWest":
			return SouthWest.getInstance();
		case "LuigiAir":
			return LuigiAir.getInstance();
		default:
			return null;
		}
	}

	public double getCost(double miles, TicketClass klass) {
		double cost = 0;
		OperatingCost oc = OperatingCost.getOperatingCost(klass);
		cost += oc.fixedRate;
		cost += oc.perMileRate * miles;
		cost += this.perMileRate * miles;
		return cost;
	}

	@Override
	public String toString() {
		return name;
	}
}

class United extends AirLine {
	private static United united = null;
	private static double premiumCharge = 0.10;

	private United() {
		super(.50, "United");
	}

	public static AirLine getInstance() {
		if (united == null)
			united = new United();
		return united;
	}

	@Override
	public double getCost(double miles, TicketClass klass) {
		double cost = super.getCost(miles, klass);
		if (TicketClass.Premium.equals(klass))
			cost += miles * premiumCharge;
		return cost;
	}
}

class Delta extends AirLine {
	private static Delta delta = null;

	private Delta() {
		super(.50, "Delta");
	}

	public static AirLine getInstance() {
		if (delta == null)
			delta = new Delta();
		return delta;
	}
}

class SouthWest extends AirLine {
	private static SouthWest southWest = null;

	private SouthWest() {
		super(.50, "SouthWest");
	}

	public static AirLine getInstance() {
		if (southWest == null)
			southWest = new SouthWest();
		return southWest;
	}

	@Override
	public double getCost(double miles, TicketClass klass) {
		double cost = 0;
		cost = miles * perMileRate;
		return cost;
	}
}

class LuigiAir extends AirLine {
	private static LuigiAir luigiAir = null;
	private double defaultMax = 100;

	private LuigiAir() {
		super(.50, "LuigiAir");
	}

	public static AirLine getInstance() {
		if (luigiAir == null)
			luigiAir = new LuigiAir();
		return luigiAir;
	}

	@Override
	public double getCost(double miles, TicketClass klass) {
		double cost = super.getCost(miles, klass);
		cost *= 2;
		return Math.max(cost, defaultMax);
	}
}
