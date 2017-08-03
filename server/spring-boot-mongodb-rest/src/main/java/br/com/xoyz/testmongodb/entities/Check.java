/**
 * 
 */
package br.com.xoyz.testmongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * @author lelag
 *
 */
@Document(collection="check")
public class Check  {

	
	@Id private String id;

	/**
	* 
	*/
	private String euid;

	/**
	* 
	*/
	private String deviceId;

	/**
	* Mobile operation System
	*/
	private String os;

	/**
	* Operation system
	*/
	private String osVersion;

	/**
	* Smartphone model
	*/
	private String deviceModel;

	/**
	* Home coordinate
	*/
	private String home;

	/**
	* Work coordinate
	*/
	private String work;

	/**
	* ?
	*/
	private String istInstalledApps;

	/**
	* State of battery
	*/
	private int batteryState;

	/**
	* Energy percentage battery
	*/
	private int batteryPercentage;

	/**
	* Arrival's time
	*/
	private String arrival;

	/**
	* Departure's time
	*/
	private String departure;

	/**
	* Categorie
	*/
	private String categorie;

	/**
	* Venue name
	*/
	private String venueName;

	/**
	* Total time in venue
	*/
	private int venueTotalTime;

	/**
	* Precision (?)
	*/
	private int precision;

	/**
	* Venue's coordinate
	*/
	private String venueLngLat;

	/**
	* Address
	*/
	private String address;

	/**
	* City
	*/
	private String city;

	/**
	* State or province
	*/
	private String state;

	/**
	* Country
	*/
	private String country;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the euid
	 */
	public String getEuid() {
		return euid;
	}

	/**
	 * @param euid the euid to set
	 */
	public void setEuid(String euid) {
		this.euid = euid;
	}

	/**
	 * @return the deviceId
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * @param deviceId the deviceId to set
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
	}

	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	/**
	 * @return the deviceModel
	 */
	public String getDeviceModel() {
		return deviceModel;
	}

	/**
	 * @param deviceModel the deviceModel to set
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	/**
	 * @return the home
	 */
	public String getHome() {
		return home;
	}

	/**
	 * @param home the home to set
	 */
	public void setHome(String home) {
		this.home = home;
	}

	/**
	 * @return the work
	 */
	public String getWork() {
		return work;
	}

	/**
	 * @param work the work to set
	 */
	public void setWork(String work) {
		this.work = work;
	}

	/**
	 * @return the istInstalledApps
	 */
	public String getIstInstalledApps() {
		return istInstalledApps;
	}

	/**
	 * @param istInstalledApps the istInstalledApps to set
	 */
	public void setIstInstalledApps(String istInstalledApps) {
		this.istInstalledApps = istInstalledApps;
	}

	/**
	 * @return the batteryState
	 */
	public int getBatteryState() {
		return batteryState;
	}

	/**
	 * @param batteryState the batteryState to set
	 */
	public void setBatteryState(int batteryState) {
		this.batteryState = batteryState;
	}

	/**
	 * @return the batteryPercentage
	 */
	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	/**
	 * @param batteryPercentage the batteryPercentage to set
	 */
	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}

	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}

	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the venueName
	 */
	public String getVenueName() {
		return venueName;
	}

	/**
	 * @param venueName the venueName to set
	 */
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	/**
	 * @return the venueTotalTime
	 */
	public int getVenueTotalTime() {
		return venueTotalTime;
	}

	/**
	 * @param venueTotalTime the venueTotalTime to set
	 */
	public void setVenueTotalTime(int venueTotalTime) {
		this.venueTotalTime = venueTotalTime;
	}

	/**
	 * @return the precision
	 */
	public int getPrecision() {
		return precision;
	}

	/**
	 * @param precision the precision to set
	 */
	public void setPrecision(int precision) {
		this.precision = precision;
	}

	/**
	 * @return the venueLatLng
	 */
	public String getVenueLngLat() {
		return venueLngLat;
	}

	/**
	 * @param venueLatLng the venueLatLng to set
	 */
	public void setVenueLngLat(String venueLatLng) {
		this.venueLngLat = venueLatLng;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Check)) {
			return false;
		}
		Check other = (Check) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	

}
