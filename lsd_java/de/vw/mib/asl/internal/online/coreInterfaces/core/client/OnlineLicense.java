/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.client;

import de.vw.mib.util.Util;
import java.util.Date;

public class OnlineLicense {
    private String _licenseID;
    private String _serviceID;
    private int _licenseState;
    private Date _expiryDate;
    private Date _startDate;
    private int _licenseType;

    public String getLicenseID() {
        return this._licenseID;
    }

    public void setLicenseID(String string) {
        this._licenseID = string;
    }

    public String getServiceID() {
        return this._serviceID;
    }

    public void setServiceID(String string) {
        this._serviceID = string;
    }

    public int getLicenseState() {
        return this._licenseState;
    }

    public void setLicenseState(int n) {
        this._licenseState = n;
    }

    public Date getExpiryDate() {
        return this._expiryDate;
    }

    public void setExpiryDate(Date date) {
        this._expiryDate = date;
    }

    public Date getStartDate() {
        return this._startDate;
    }

    public void setStartDate(Date date) {
        this._startDate = date;
    }

    public int getLicenseType() {
        return this._licenseType;
    }

    public void setLicenseType(int n) {
        this._licenseType = n;
    }

    public void copyTo(OnlineLicense onlineLicense) {
        if (onlineLicense != null && this != onlineLicense) {
            this._licenseID = onlineLicense.getLicenseID();
            this._licenseState = onlineLicense.getLicenseState();
            this._serviceID = onlineLicense.getServiceID();
            this._startDate = onlineLicense.getStartDate();
            this._expiryDate = onlineLicense.getExpiryDate();
            this._licenseType = onlineLicense.getLicenseType();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OnlineLicense");
        stringBuffer.append('(');
        stringBuffer.append("LicenseID");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._licenseID) ? this._licenseID : "");
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("ServiceID");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._serviceID) ? this._serviceID : "");
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("LicenseState");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseState);
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("StartDate");
        stringBuffer.append('=');
        stringBuffer.append(this._startDate);
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append("ExpiryDate");
        stringBuffer.append('=');
        stringBuffer.append(this._expiryDate);
        stringBuffer.append(',');
        stringBuffer.append('\"');
        stringBuffer.append('\"');
        stringBuffer.append("LicenseType");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseType);
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

