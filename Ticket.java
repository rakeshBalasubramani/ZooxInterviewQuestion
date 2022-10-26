package zoox;

/**
 * @author rakeshbalasubramani 
 * The ticket class contains the information about
 *         the ticket.
 */
public class Ticket {
	public Ticket(AirLine airline, double miles, TicketClass klass) {
		super();
		this.airline = airline;
		this.miles = miles;
		this.klass = klass;
		this.cost = airline.getCost(miles, klass);
	}

	@Override
	public String toString() {
		return "Cost = $" + cost + " for a distance of " + miles + " mile(s) in " + klass + " class flying in "
				+ airline + " airlines.";
	}

	double cost;
	AirLine airline;
	double miles;
	TicketClass klass;

}
