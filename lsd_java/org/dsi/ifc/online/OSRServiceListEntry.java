/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.online.OSRLicense;

public class OSRServiceListEntry {
    public String serviceID;
    public int serviceType;
    public int privacyGroup;
    public boolean enableDisableServiceState;
    public int backendReasons;
    public int vehicleLocalServiceState;
    public boolean licenseRequired;
    public boolean blocksDisabling;
    public boolean primaryUserRequired;
    public boolean termsAndConditionsRequired;
    public int apn;
    public int qos;
    public int authLevel;
    public OSRLicense license;

    public OSRServiceListEntry() {
        this.serviceID = null;
        this.serviceType = 0;
        this.privacyGroup = 0;
        this.enableDisableServiceState = false;
        this.backendReasons = 0;
        this.vehicleLocalServiceState = 0;
        this.licenseRequired = false;
        this.blocksDisabling = false;
        this.primaryUserRequired = false;
        this.termsAndConditionsRequired = false;
        this.apn = 0;
        this.qos = 0;
        this.authLevel = 0;
        this.license = null;
    }

    public OSRServiceListEntry(String string, int n, int n2, boolean bl, int n3, int n4, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n5, int n6, int n7, OSRLicense oSRLicense) {
        this.serviceID = string;
        this.serviceType = n;
        this.privacyGroup = n2;
        this.enableDisableServiceState = bl;
        this.backendReasons = n3;
        this.vehicleLocalServiceState = n4;
        this.licenseRequired = bl2;
        this.blocksDisabling = bl3;
        this.primaryUserRequired = bl4;
        this.termsAndConditionsRequired = bl5;
        this.apn = n5;
        this.qos = n6;
        this.authLevel = n7;
        this.license = oSRLicense;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public int getPrivacyGroup() {
        return this.privacyGroup;
    }

    public boolean isEnableDisableServiceState() {
        return this.enableDisableServiceState;
    }

    public int getBackendReasons() {
        return this.backendReasons;
    }

    public int getVehicleLocalServiceState() {
        return this.vehicleLocalServiceState;
    }

    public boolean isLicenseRequired() {
        return this.licenseRequired;
    }

    public boolean isBlocksDisabling() {
        return this.blocksDisabling;
    }

    public boolean isPrimaryUserRequired() {
        return this.primaryUserRequired;
    }

    public boolean isTermsAndConditionsRequired() {
        return this.termsAndConditionsRequired;
    }

    public int getApn() {
        return this.apn;
    }

    public int getQos() {
        return this.qos;
    }

    public int getAuthLevel() {
        return this.authLevel;
    }

    public OSRLicense getLicense() {
        return this.license;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1800);
        stringBuffer.append("OSRServiceListEntry");
        stringBuffer.append('(');
        stringBuffer.append("serviceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.serviceID);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("serviceType");
        stringBuffer.append('=');
        stringBuffer.append(this.serviceType);
        stringBuffer.append(',');
        stringBuffer.append("privacyGroup");
        stringBuffer.append('=');
        stringBuffer.append(this.privacyGroup);
        stringBuffer.append(',');
        stringBuffer.append("enableDisableServiceState");
        stringBuffer.append('=');
        stringBuffer.append(this.enableDisableServiceState);
        stringBuffer.append(',');
        stringBuffer.append("backendReasons");
        stringBuffer.append('=');
        stringBuffer.append(this.backendReasons);
        stringBuffer.append(',');
        stringBuffer.append("vehicleLocalServiceState");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleLocalServiceState);
        stringBuffer.append(',');
        stringBuffer.append("licenseRequired");
        stringBuffer.append('=');
        stringBuffer.append(this.licenseRequired);
        stringBuffer.append(',');
        stringBuffer.append("blocksDisabling");
        stringBuffer.append('=');
        stringBuffer.append(this.blocksDisabling);
        stringBuffer.append(',');
        stringBuffer.append("primaryUserRequired");
        stringBuffer.append('=');
        stringBuffer.append(this.primaryUserRequired);
        stringBuffer.append(',');
        stringBuffer.append("termsAndConditionsRequired");
        stringBuffer.append('=');
        stringBuffer.append(this.termsAndConditionsRequired);
        stringBuffer.append(',');
        stringBuffer.append("apn");
        stringBuffer.append('=');
        stringBuffer.append(this.apn);
        stringBuffer.append(',');
        stringBuffer.append("qos");
        stringBuffer.append('=');
        stringBuffer.append(this.qos);
        stringBuffer.append(',');
        stringBuffer.append("authLevel");
        stringBuffer.append('=');
        stringBuffer.append(this.authLevel);
        stringBuffer.append(',');
        stringBuffer.append("license");
        stringBuffer.append('=');
        stringBuffer.append(this.license);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

