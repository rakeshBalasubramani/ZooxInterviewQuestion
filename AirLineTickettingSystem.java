package zoox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirLineTickettingSystem {
	static List<Ticket> tickets = new ArrayList<>();
	static public void parseTicket(String ticket) {
		if(ticket == null)
			throw new IllegalArgumentException("Input ticket is null");
		if(ticket.isBlank()||ticket.isEmpty()) 
			throw new IllegalArgumentException("Input Ticket Field is invalid");
		String[] strings = ticket.split(" "); 
		if(strings.length!=3)
			throw new IllegalArgumentException("Ticket does not contain all the fields");
		tickets.add(
				new Ticket(
						AirLine.getAirLineInstance(strings[0]),
						Double.parseDouble(strings[1]),
						TicketClass.valueOf(strings[2])
						)
				);
	}
	public static void main(String args[]) {
		List<String> tickets = Arrays.asList(
				"United 150 Premium",
				"Delta 95 Economy",
				"SouthWest 200 Business",
				"LuigiAir 110 Premium"
		);
		for(String ticket:tickets)
			AirLineTickettingSystem.parseTicket(ticket);
		AirLineTickettingSystem.getTotalCost();
	}
	private static void getTotalCost() {
		for(Ticket ticket:tickets)
			System.out.println(ticket);
		
	}
}
