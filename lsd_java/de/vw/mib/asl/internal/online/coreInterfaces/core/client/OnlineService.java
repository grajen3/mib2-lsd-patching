/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.client;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineLicense;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public class OnlineService {
    private String _serviceID;
    private String _serviceName;
    private int _deviceID;
    private OnlineLicense _license;
    private OnlineUser[] _users;
    private int _serviceState;
    private boolean _hasValidLicense;
    private boolean _deactivationBlocked;
    private boolean _enabledState;
    private boolean _trackingService;
    private boolean _trackingActive;
    private int[] _category;
    private int[] _privacyGroups;
    private boolean _disabledActivation;
    private int _apn;

    public String getServiceID() {
        return this._serviceID;
    }

    public void setServiceID(String string) {
        this._serviceID = string;
    }

    public void setServiceName(String string) {
        this._serviceName = string;
    }

    public String getServiceName() {
        return this._serviceName;
    }

    public int getDeviceID() {
        return this._deviceID;
    }

    public void setDeviceID(int n) {
        this._deviceID = n;
    }

    public boolean isDeactivationBlocked() {
        return this._deactivationBlocked;
    }

    public void setDeactivationBlocked(boolean bl) {
        this._deactivationBlocked = bl;
    }

    public boolean isEnabledState() {
        return this._enabledState;
    }

    public void setEnabledState(boolean bl) {
        this._enabledState = bl;
    }

    public void setDisabledActivation(boolean bl) {
        this._disabledActivation = bl;
    }

    public boolean isDisabledActivation() {
        return this._disabledActivation;
    }

    public OnlineLicense getLicense() {
        return this._license;
    }

    public void setLicense(OnlineLicense onlineLicense) {
        this._license = onlineLicense;
    }

    public OnlineUser[] getUsers() {
        return this._users;
    }

    public void setUsers(OnlineUser[] onlineUserArray) {
        this._users = onlineUserArray;
    }

    public int getServiceState() {
        return this._serviceState;
    }

    public void setServiceState(int n) {
        this._serviceState = n;
    }

    public boolean isValidLicense() {
        return this._hasValidLicense;
    }

    public void setValidLicense(boolean bl) {
        this._hasValidLicense = bl;
    }

    public void setTrackingService(boolean bl) {
        this._trackingService = bl;
    }

    public boolean isTrackingService() {
        return this._trackingService;
    }

    public void setTrackingToActive(boolean bl) {
        this._trackingActive = bl;
    }

    public boolean isTrackingActive() {
        return this._trackingActive;
    }

    public int[] getCategory() {
        return this._category;
    }

    public void setCategory(int[] nArray) {
        this._category = nArray;
    }

    public int[] getPrivacyGroups() {
        return this._privacyGroups;
    }

    public void setPrivacyGroups(int[] nArray) {
        this._privacyGroups = nArray;
    }

    public int getApn() {
        return this._apn;
    }

    public void setApn(int n) {
        this._apn = n;
    }

    public void copyTo(OnlineService onlineService) {
        if (onlineService != null && this != onlineService) {
            this._serviceID = onlineService.getServiceID();
            this._serviceName = Util.isNullOrEmpty(onlineService.getServiceName()) ? "" : new String(onlineService.getServiceName());
            this._serviceState = onlineService.getServiceState();
            this._hasValidLicense = onlineService.isValidLicense();
            this._deactivationBlocked = onlineService.isDeactivationBlocked();
            this._enabledState = onlineService.isEnabledState();
            this._trackingService = onlineService.isTrackingService();
            this._trackingActive = onlineService.isTrackingActive();
            if (onlineService.getLicense() != null) {
                if (this._license == null) {
                    this._license = new OnlineLicense();
                }
                this._license.copyTo(onlineService.getLicense());
            } else {
                this._license = null;
            }
            this._users = Util.isNullOrEmpty(onlineService.getUsers()) ? null : (OnlineUser[])Arrays.copyOf(onlineService.getUsers(), onlineService.getUsers().length);
            this._privacyGroups = Util.isNullOrEmpty(onlineService.getPrivacyGroups()) ? null : Arrays.copyOf(onlineService.getPrivacyGroups(), onlineService.getPrivacyGroups().length);
            this._apn = onlineService._apn;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OnlineService");
        stringBuffer.append('(');
        stringBuffer.append("ServiceID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(!Util.isNullOrEmpty(this._serviceID) ? this._serviceID : "");
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("ServiceState");
        stringBuffer.append('=');
        stringBuffer.append(this._serviceState);
        stringBuffer.append(',');
        stringBuffer.append("ValidLicense");
        stringBuffer.append('=');
        stringBuffer.append(this._hasValidLicense);
        stringBuffer.append(',');
        stringBuffer.append("TrackingService");
        stringBuffer.append('=');
        stringBuffer.append(this._trackingService);
        stringBuffer.append(',');
        stringBuffer.append("TrackingActive");
        stringBuffer.append('=');
        stringBuffer.append(this._trackingActive);
        stringBuffer.append(',');
        if (this._license != null) {
            stringBuffer.append(this._license.toString());
        } else {
            stringBuffer.append("License = NULL");
        }
        stringBuffer.append(',');
        stringBuffer.append("UserList");
        stringBuffer.append('[');
        if (!Util.isNullOrEmpty(this._users)) {
            stringBuffer.append(this._users.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._users)) {
            int n = this._users.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this._users[i2].toString());
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._users);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

