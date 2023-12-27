/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;
import de.vw.mib.util.Util;
import org.dsi.ifc.global.DateTime;

public class LicenseImpl
implements License {
    private String _licenseID;
    private int _licenseState;
    private int _licenseType;
    private DateTime _licenseExpiry;
    private DateTime _licenseActivation;
    private DateTime _licenseValidityPeriod;
    private boolean _licenseValidity;

    @Override
    public void setLicenseID(String string) {
        this._licenseID = string;
    }

    @Override
    public String getLicenseID() {
        return this._licenseID;
    }

    @Override
    public void setLicenseState(int n) {
        this._licenseState = n;
    }

    @Override
    public int getLicenseState() {
        return this._licenseState;
    }

    @Override
    public void setLicenseType(int n) {
        this._licenseType = n;
    }

    @Override
    public int getLicenseType() {
        return this._licenseType;
    }

    @Override
    public void setLicenseExpiry(DateTime dateTime) {
        this._licenseExpiry = dateTime;
    }

    @Override
    public DateTime getPeriodOfValidityDate() {
        return this._licenseValidityPeriod;
    }

    @Override
    public void setPeriodOfValidityDate(DateTime dateTime) {
        this._licenseValidityPeriod = dateTime;
    }

    @Override
    public DateTime getActivationDate() {
        return this._licenseActivation;
    }

    @Override
    public void setActivationDate(DateTime dateTime) {
        this._licenseActivation = dateTime;
    }

    @Override
    public DateTime getLicenseExpiry() {
        return this._licenseExpiry;
    }

    @Override
    public void setLicenseValidity(boolean bl) {
        this._licenseValidity = bl;
    }

    @Override
    public boolean isLicenseValid() {
        return this._licenseValidity;
    }

    @Override
    public void copyTo(License license) {
        if (license != null && this != license) {
            this._licenseID = new String(license.getLicenseID());
            this._licenseState = license.getLicenseState();
            this._licenseExpiry = license.getLicenseExpiry() != null ? new DateTime(license.getLicenseExpiry().getTime()) : null;
            this._licenseActivation = license.getActivationDate() != null ? new DateTime(license.getActivationDate().getTime()) : null;
            this._licenseValidityPeriod = license.getPeriodOfValidityDate() != null ? new DateTime(license.getPeriodOfValidityDate().getTime()) : null;
            this._licenseValidity = license.isLicenseValid();
            this._licenseType = license.getLicenseType();
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("License");
        stringBuffer.append('(');
        stringBuffer.append("LicenseID");
        stringBuffer.append('=');
        stringBuffer.append(!Util.isNullOrEmpty(this._licenseID) ? this._licenseID : "");
        stringBuffer.append(',');
        stringBuffer.append("LicenseState");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseState);
        stringBuffer.append(',');
        stringBuffer.append("LicenseValid");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseValidity);
        stringBuffer.append(',');
        stringBuffer.append("LicenseType");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseType);
        stringBuffer.append(',');
        stringBuffer.append("LicenseActivation");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseActivation != null ? this._licenseActivation.toString() : "");
        stringBuffer.append(',');
        stringBuffer.append("LicenseExpiry");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseExpiry != null ? this._licenseExpiry.toString() : "");
        stringBuffer.append(',');
        stringBuffer.append("LicensePeriod");
        stringBuffer.append('=');
        stringBuffer.append(this._licenseValidityPeriod != null ? this._licenseValidityPeriod.toString() : "");
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    @Override
    public boolean equalsTo(License license) {
        if (license == null) {
            return false;
        }
        if (!this._licenseID.equalsIgnoreCase(license.getLicenseID())) {
            return false;
        }
        if (this._licenseState != license.getLicenseState()) {
            return false;
        }
        if (this._licenseExpiry.equals(license.getLicenseExpiry())) {
            return false;
        }
        if (this._licenseActivation.equals(license.getActivationDate())) {
            return false;
        }
        if (this._licenseValidityPeriod.equals(license.getPeriodOfValidityDate())) {
            return false;
        }
        if (this._licenseValidity != license.isLicenseValid()) {
            return false;
        }
        return this._licenseType == license.getLicenseType();
    }
}

