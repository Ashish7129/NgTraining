package com.nagarro.model;
import java.util.Date;

public class UserInput  {
	private String depLoc;
	private String arrLoc;
	private Date flightDate;
	private String flightClass;
	private int outputPrefer;
	
	public String getArrLoc() {
		return arrLoc;
	}

	public String getDepLoc() {
		return depLoc;
	}

	public Date getValidTill() {
		return flightDate;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public int getOutputPrefer() {
		return outputPrefer;
	}
	
	public UserInput( String depLoc,String arrLoc, Date validTill, String flightClass, int outputPrefer) {
		this.arrLoc = arrLoc;
		this.depLoc = depLoc;
		this.flightDate = validTill;
		this.flightClass = flightClass;
		this.outputPrefer = outputPrefer;
	}

	@Override
	public String toString() {
		return "UserInput [arrLoc=" + arrLoc + ", depLoc=" + depLoc + ", flightDate=" + flightDate + ", flightClass="
				+ flightClass + ", outputPrefer=" + outputPrefer + "]";
	}
	


}
