package model.violations;

import java.util.Arrays;

public class GraphInfo {
	private long id;
	private double lat;
	private double lon;
	private long[] adj;
	private double[] infractions;
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getLat() {
		return lat;
	}


	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLon() {
		return lon;
	}


	public void setLon(double lon) {
		this.lon = lon;
	}


	public long[] getAdj() {
		return adj;
	}


	public void setAdj(long[] adj) {
		this.adj = adj;
	}


	public double[] getInfractions() {
		return infractions;
	}


	public void setInfractions(double[] infractions) {
		this.infractions = infractions;
	}


	public GraphInfo(long id, double lat, double lon, long[] adj, double[] infractions) {
		super();
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.adj = adj;
		this.infractions = infractions;
	}


	@Override
	public String toString() {
		return "GraphInfo [id=" + id + ", lat=" + lat + ", lon=" + lon + ", adj=" + Arrays.toString(adj)
				+ ", infractions=" + Arrays.toString(infractions) + "]";
	}
	
	
}
	
	