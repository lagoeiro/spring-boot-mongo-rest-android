package br.com.xoyz.testrestgps.entity;

import java.io.Serializable;

/**
 * Created by lelag on 31/07/2017.
 */

public class Check  implements Serializable{

    private String id;

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

    public Check(){

    }

    public Check(String id, String euid, String deviceId, String os, String osVersion, String deviceModel, String home, String work, String istInstalledApps, int batteryState, int batteryPercentage, String arrival, String departure, String categorie, String venueName, int venueTotalTime, int precision, String venueLatLng, String address, String city, String state, String country) {
        this.id = id;
        this.euid = euid;
        this.deviceId = deviceId;
        this.os = os;
        this.osVersion = osVersion;
        this.deviceModel = deviceModel;
        this.home = home;
        this.work = work;
        this.istInstalledApps = istInstalledApps;
        this.batteryState = batteryState;
        this.batteryPercentage = batteryPercentage;
        this.arrival = arrival;
        this.departure = departure;
        this.categorie = categorie;
        this.venueName = venueName;
        this.venueTotalTime = venueTotalTime;
        this.precision = precision;
        this.venueLngLat = venueLatLng;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }

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
     * @return the venueLngLat
     */
    public String getVenueLngLat() {
        return venueLngLat;
    }

    /**
     * @param venueLngLat the venueLatLng to set
     */
    public void setVenueLngLat(String venueLngLat) {
        this.venueLngLat = venueLngLat;
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

}
