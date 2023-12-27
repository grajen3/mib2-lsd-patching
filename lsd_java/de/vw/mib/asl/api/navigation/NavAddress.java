/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.ASLNavigationAPI;
import de.vw.mib.asl.api.navigation.ASLNavigationFactory;

public class NavAddress {
    private String name = "";
    private String state = "";
    private String stateAbbreviation = "";
    private String zip = "";
    private String url = "";
    private String phoneNumber = "";
    private String houseNumber = "";
    private String country = "";
    private String countryCode = "";
    private String city = "";
    private String crossing = "";
    private String street = "";
    private int longitude = 0;
    private int latitude = 0;
    private double latitudeDecimal = 0.0;
    private double longitudeDecimal = 0.0;
    private final ASLNavigationAPI navApi = ASLNavigationFactory.getNavigationApi();
    public static final int GEO_INDEX_DEGREES;
    public static final int GEO_INDEX_MINUTES;
    public static final int GEO_INDEX_SECONDS;

    public int getLatitude() {
        return this.latitude;
    }

    public double getLatitudeDecimal() {
        return this.latitudeDecimal;
    }

    public double[] getLatitudeDegMinSec() {
        return this.navApi.dsiToDegMinSec(this.latitude);
    }

    public int getLongitude() {
        return this.longitude;
    }

    public double getLongitudeDecimal() {
        return this.longitudeDecimal;
    }

    public double[] getLongitudeDegMinSec() {
        return this.navApi.dsiToDegMinSec(this.longitude);
    }

    public String getStreet() {
        return this.street;
    }

    public String getCrossing() {
        return this.crossing;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getHousenumber() {
        return this.houseNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getUrl() {
        return this.url;
    }

    public String getZip() {
        return this.zip;
    }

    public String getState() {
        return this.state;
    }

    public String getStateAbbreviation() {
        return this.stateAbbreviation;
    }

    public String getName() {
        return this.name;
    }

    public boolean isValid() {
        return this.getLatitude() != 0 || this.getLongitude() != 0 || this.getLatitudeDecimal() != 0.0 || this.getLongitudeDecimal() != 0.0;
    }

    public void setLatitude(int n) {
        this.latitude = n;
        this.latitudeDecimal = this.navApi.dsiToDecimal(n);
    }

    public void setLatitude(double d2) {
        this.latitudeDecimal = d2;
        this.latitude = this.navApi.decimalToDsi(d2);
    }

    public void setLongitude(int n) {
        this.longitude = n;
        this.longitudeDecimal = this.navApi.dsiToDecimal(n);
    }

    public void setLongitude(double d2) {
        this.longitudeDecimal = d2;
        this.longitude = this.navApi.decimalToDsi(d2);
    }

    public void setStreet(String string) {
        this.street = string == null ? "" : string;
    }

    public void setCrossing(String string) {
        this.crossing = string == null ? "" : string;
    }

    public void setCity(String string) {
        this.city = string == null ? "" : string;
    }

    public void setCountry(String string) {
        this.country = string == null ? "" : string;
    }

    public void setCountryCode(String string) {
        this.countryCode = string == null ? "" : string;
    }

    public void setHousenumber(String string) {
        this.houseNumber = string == null ? "" : string;
    }

    public void setZip(String string) {
        this.zip = string == null ? "" : string;
    }

    public void setState(String string) {
        this.state = string == null ? "" : string;
    }

    public void setStateAbbreviation(String string) {
        this.stateAbbreviation = string == null ? "" : string;
    }

    public void setName(String string) {
        this.name = string == null ? "" : string;
    }

    public void setPhoneNumber(String string) {
        this.phoneNumber = string == null ? "" : string;
    }

    public void setUrl(String string) {
        this.url = string == null ? "" : string;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("NavAddress");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.getName());
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("state");
        stringBuffer.append('=');
        stringBuffer.append(this.getState());
        stringBuffer.append(',');
        stringBuffer.append("stateAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append(this.getStateAbbreviation());
        stringBuffer.append(',');
        stringBuffer.append("zip");
        stringBuffer.append('=');
        stringBuffer.append(this.getZip());
        stringBuffer.append(',');
        stringBuffer.append("phoneNumber");
        stringBuffer.append('=');
        stringBuffer.append(this.getPhoneNumber());
        stringBuffer.append(',');
        stringBuffer.append("Housenumber");
        stringBuffer.append('=');
        stringBuffer.append(this.getHousenumber());
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append(this.getCountry());
        stringBuffer.append(',');
        stringBuffer.append("countryCode");
        stringBuffer.append('=');
        stringBuffer.append(this.getCountryCode());
        stringBuffer.append(',');
        stringBuffer.append("city");
        stringBuffer.append('=');
        stringBuffer.append(this.getCity());
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append(this.getStreet());
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.getLatitudeDecimal());
        stringBuffer.append(',');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.getLongitudeDecimal());
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

