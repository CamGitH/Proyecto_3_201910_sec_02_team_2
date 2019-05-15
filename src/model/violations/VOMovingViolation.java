package model.violations;

/**
 * Representation of a Trip object
 */
public class VOMovingViolation {
	

	// ---------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------

	private String OBJECTID;

	private String LOCATION;
	
	private String TICKETISSUEDATE;
	
	private String TOTALPAID;
	
	private String ACCIDENTINDICATOR;
	
	private String VIOLATIONCODE;

	private String VIOLATIONDESC;

	private String STREETSEGID;

	private String ADDRESS_ID;
	
	private String XCOORD;

	private String YCOORD;
	
	private String FINEAMT;
	
	private String PENALTY1;
	
	private String PENALTY2;

	// -------------------------------------------------------
	// Constructor
	// -------------------------------------------------------
	
	public VOMovingViolation(String pId, String pLocation, String pDate, String pTotalPaid, String indicador,
			String descripcion, String violationCode, String fineamt, String penalty1, String penalty2, 
			String addressId, String streetSegId)
	{
		this.OBJECTID = pId;
		this.LOCATION = pLocation;
		this.TICKETISSUEDATE= pDate;
		this.TOTALPAID = pTotalPaid;
		this.ACCIDENTINDICATOR = indicador;
		this.VIOLATIONDESC = descripcion;
		this.VIOLATIONCODE = violationCode;
		this.FINEAMT = fineamt;
		this.PENALTY1 = penalty1; 
		this.PENALTY2 = penalty2;
		this.STREETSEGID = streetSegId;
		this.ADDRESS_ID = addressId;
	}

	// -------------------------------------------------------
	// Metodos
	// -------------------------------------------------------

	
	@Override
	public String toString() {
		return "VOMovingViolations [objectId()=" + objectId() + ",\n getLocation()=" + getLocation()
				+ ",\n getTicketIssueDate()=" + getTicketIssueDate() + ",\n getTotalPaid()=" + getTotalPaid()
				+ ",\n getAccidentIndicator()=" + getAccidentIndicator() + ",\n getViolationDescription()="
				+ getViolationDescription() + ",\n getStreetSegId()=" + getStreetSegId() + ",\n getAddressId()="
				+ getAddressId() + "]\n\n";
	}


	/**
	 * @return id - Identificador único de la infracción
	 */
	public String objectId() {
		return this.OBJECTID;
	}	
	
	public String getViolationCode(){
		return this.VIOLATIONCODE;
	}
	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {
		return this.LOCATION;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		return this.TICKETISSUEDATE;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public String getTotalPaid() {
		return this.TOTALPAID;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		return this.ACCIDENTINDICATOR;
	}
		
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {
		return this.VIOLATIONDESC;
	}
	
	public String getStreetSegId() {
		return this.STREETSEGID;
	}
	
	public String getAddressId() {
		return this.ADDRESS_ID;
	}
	
	public String getXCoord() {
		return this.XCOORD;
	}
	
	public String getYCoord() {
		return this.YCOORD;
	}
	
	public String getFineAMT() {
		return this.FINEAMT;
	}
	
	public String getPenalty1() {
		return this.PENALTY1;
	}
	
	public String getPenalty2() {
		return this.PENALTY2;
	}
	
	public String TOSTRING(){
		System.out.println(VIOLATIONCODE);
		System.out.println(PENALTY1);
		System.out.println(STREETSEGID);
		return "";
	}

}
