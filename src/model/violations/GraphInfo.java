package model.violations;

public class GraphInfo {
	private int id;
	private int lat;
	private int lon;
	private long[] adj;
	private int[] infractions;
	
	public GraphInfo(int id, int lat, int lon, long[] adj, int[] infractions) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.adj = adj;
		this.infractions = infractions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getLon() {
		return lon;
	}
	public void setLon(int lon) {
		this.lon = lon;
	}
	public long[] getAdj() {
		return adj;
	}
	public void setAdj(long[] adj) {
		this.adj = adj;
	}
	public int[] getInfractions() {
		return infractions;
	}
	public void setInfractions(int[] infractions) {
		this.infractions = infractions;
	}
	
	
	 
}