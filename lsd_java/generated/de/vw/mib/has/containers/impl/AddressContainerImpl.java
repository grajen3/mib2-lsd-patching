/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class AddressContainerImpl
extends AbstractContainer
implements AddressContainer {
    private static final byte ELEMENT_LATITUDE;
    private static final byte ELEMENT_LONGITUDE;
    private static final byte ELEMENT_FORMATTED_STRING;
    private static final byte ELEMENT_STREET;
    private static final byte ELEMENT_CITY;
    private static final byte ELEMENT_COUNTRY;
    private static final byte ELEMENT_HOUSENUMBER;
    private static final byte ELEMENT_ZIP;
    private static final byte ELEMENT_STATE;
    private static final byte ELEMENT_ALTITUDE;
    private double attrLatitude;
    private double attrLongitude;
    private String attrFormattedString;
    private String attrStreet;
    private String attrCity;
    private String attrCountry;
    private String attrHousenumber;
    private String attrZip;
    private String attrState;
    private double attrAltitude;

    @Override
    public int getContainerId() {
        return 1;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double getLatitude() {
        return this.attrLatitude;
    }

    @Override
    public double getLongitude() {
        return this.attrLongitude;
    }

    @Override
    public String getFormattedString() {
        return this.attrFormattedString;
    }

    @Override
    public String getStreet() {
        return this.attrStreet;
    }

    @Override
    public String getCity() {
        return this.attrCity;
    }

    @Override
    public String getCountry() {
        return this.attrCountry;
    }

    @Override
    public String getHousenumber() {
        return this.attrHousenumber;
    }

    @Override
    public String getZip() {
        return this.attrZip;
    }

    @Override
    public String getState() {
        return this.attrState;
    }

    @Override
    public double getAltitude() {
        return this.attrAltitude;
    }

    @Override
    public boolean isLatitudeSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isLongitudeSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isFormattedStringSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isStreetSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isCitySet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public boolean isCountrySet() {
        return this._isElementSet((byte)5);
    }

    @Override
    public boolean isHousenumberSet() {
        return this._isElementSet((byte)6);
    }

    @Override
    public boolean isZipSet() {
        return this._isElementSet((byte)7);
    }

    @Override
    public boolean isStateSet() {
        return this._isElementSet((byte)8);
    }

    @Override
    public boolean isAltitudeSet() {
        return this._isElementSet((byte)9);
    }

    @Override
    public void setLatitude(double d2) {
        this.attrLatitude = d2;
        this._setElement((byte)0, true);
    }

    @Override
    public void setLongitude(double d2) {
        this.attrLongitude = d2;
        this._setElement((byte)1, true);
    }

    @Override
    public void setFormattedString(String string) {
        this.attrFormattedString = string;
        this._setElement((byte)2, null != string);
    }

    @Override
    public void setStreet(String string) {
        this.attrStreet = string;
        this._setElement((byte)3, null != string);
    }

    @Override
    public void setCity(String string) {
        this.attrCity = string;
        this._setElement((byte)4, null != string);
    }

    @Override
    public void setCountry(String string) {
        this.attrCountry = string;
        this._setElement((byte)5, null != string);
    }

    @Override
    public void setHousenumber(String string) {
        this.attrHousenumber = string;
        this._setElement((byte)6, null != string);
    }

    @Override
    public void setZip(String string) {
        this.attrZip = string;
        this._setElement((byte)7, null != string);
    }

    @Override
    public void setState(String string) {
        this.attrState = string;
        this._setElement((byte)8, null != string);
    }

    @Override
    public void setAltitude(double d2) {
        this.attrAltitude = d2;
        this._setElement((byte)9, true);
    }

    @Override
    public void unsetLatitude() {
        this.attrLatitude = 0.0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetLongitude() {
        this.attrLongitude = 0.0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetFormattedString() {
        this.attrFormattedString = null;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetStreet() {
        this.attrStreet = null;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetCity() {
        this.attrCity = null;
        this._setElement((byte)4, false);
    }

    @Override
    public void unsetCountry() {
        this.attrCountry = null;
        this._setElement((byte)5, false);
    }

    @Override
    public void unsetHousenumber() {
        this.attrHousenumber = null;
        this._setElement((byte)6, false);
    }

    @Override
    public void unsetZip() {
        this.attrZip = null;
        this._setElement((byte)7, false);
    }

    @Override
    public void unsetState() {
        this.attrState = null;
        this._setElement((byte)8, false);
    }

    @Override
    public void unsetAltitude() {
        this.attrAltitude = 0.0;
        this._setElement((byte)9, false);
    }
}

