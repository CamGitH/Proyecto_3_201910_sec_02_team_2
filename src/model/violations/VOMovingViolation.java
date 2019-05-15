package model.violations;

import java.util.Comparator;

public class VOMovingViolation implements Comparable<VOMovingViolation>{
	

	private String objectID;
	private String location;
	private String ticketIssueDate;
	private String totalPaid;
	private String accidentIndicator;
	private String violationDescription;
	private String streetSegId;
	private String addressID;
	private String xCoord;
	private String yCoord;
	private String violationCode;
	private String latitude;
	private String longitud;
	

	public VOMovingViolation(String pObjectID, String pLocation, String pTicketIssueDate, String pTotalPaid,
			String pAccidentIndicator, String pViolatinDescription, String pStreetSegId, String pAddressID
			, String pXCoord, String pYCoord, String pViolationCode, String pLatitude, String pLongitude) {
	
		objectID = pObjectID;
		location = pLocation;
		ticketIssueDate = pTicketIssueDate;
		totalPaid = pTotalPaid;
		accidentIndicator = pAccidentIndicator;
		violationDescription = pViolatinDescription;
		streetSegId = pStreetSegId;
		addressID = pAddressID;
		xCoord = pXCoord;
		yCoord = pYCoord;
		violationCode = pViolationCode;
		latitude = pLatitude;
		longitud = pLongitude;
		
	}


	public String getObjectID() {
		return objectID;
	}



	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getTicketIssueDate() {
		return ticketIssueDate;
	}



	public void setTicketIssueDate(String ticketIssueDate) {
		this.ticketIssueDate = ticketIssueDate;
	}



	public String getTotalPaid() {
		return totalPaid;
	}



	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}



	public String getAccidentIndicator() {
		return accidentIndicator;
	}



	public void setAccidentIndicator(String accidentIndicator) {
		this.accidentIndicator = accidentIndicator;
	}



	public String getViolationDescription() {
		return violationDescription;
	}



	public void setViolationDescription(String violationDescription) {
		this.violationDescription = violationDescription;
	}



	public String getStreetSegId() {
		return streetSegId;
	}



	public void setStreetSegId(String streetSegId) {
		this.streetSegId = streetSegId;
	}



	public String getAddressID() {
		return addressID;
	}



	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}



	public String getxCoord() {
		return xCoord;
	}



	public void setxCoord(String xCoord) {
		this.xCoord = xCoord;
	}



	public String getyCoord() {
		return yCoord;
	}



	public void setyCoord(String yCoord) {
		this.yCoord = yCoord;
	}



	public String getViolationCode() {
		return violationCode;
	}



	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getLongitud() {
		return longitud;
	}



	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}



	@Override
	public int compareTo(VOMovingViolation arg0) {
		return this.getViolationCode().compareToIgnoreCase(arg0.getViolationCode());
	}
}
