/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.client;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineService;
import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.util.Util;

public class OnlineApplication {
    private String _applicationID;
    private int _deviceID;
    private OnlineService[] _services;
    private OnlineUser[] _users;
    private int _applicationState;
    private boolean _applicationDeactive;
    private boolean _deactivationPossible;

    public String getApplicationID() {
        return this._applicationID;
    }

    public void setApplicationID(String string) {
        this._applicationID = string;
    }

    public int getDeviceID() {
        return this._deviceID;
    }

    public void setDeviceID(int n) {
        this._deviceID = n;
    }

    public OnlineService[] getServices() {
        return this._services;
    }

    public void setServices(OnlineService[] onlineServiceArray) {
        this._services = onlineServiceArray;
    }

    public OnlineUser[] getUsers() {
        return this._users;
    }

    public void setUsers(OnlineUser[] onlineUserArray) {
        this._users = onlineUserArray;
    }

    public int getApplicationState() {
        return this._applicationState;
    }

    public void setApplicationState(int n) {
        this._applicationState = n;
    }

    public boolean isApplicationDeactive() {
        return this._applicationDeactive;
    }

    public void applicationDeactivated(boolean bl) {
        this._applicationDeactive = bl;
    }

    public boolean isDeactivationPossible() {
        return this._deactivationPossible;
    }

    public void setDeactivationPossible(boolean bl) {
        this._deactivationPossible = bl;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("OnlineApplication");
        stringBuffer.append('(');
        stringBuffer.append("applicationID");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(!Util.isNullOrEmpty(this._applicationID) ? this._applicationID : "");
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("DeviceID");
        stringBuffer.append('=');
        stringBuffer.append(this._deviceID);
        stringBuffer.append(',');
        stringBuffer.append("State");
        stringBuffer.append('=');
        stringBuffer.append(this._applicationState);
        stringBuffer.append(',');
        stringBuffer.append("Active");
        stringBuffer.append('=');
        stringBuffer.append(this._applicationDeactive);
        stringBuffer.append(',');
        stringBuffer.append("DeactivationPossiblity");
        stringBuffer.append('=');
        stringBuffer.append(this._deactivationPossible);
        stringBuffer.append(',');
        stringBuffer.append("ServiceList");
        stringBuffer.append('[');
        if (!Util.isNullOrEmpty(this._services)) {
            stringBuffer.append(this._services.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (!Util.isNullOrEmpty(this._services)) {
            n3 = this._services.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this._services[n].toString());
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._services);
        }
        stringBuffer.append('}');
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
            n3 = this._users.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this._users[n].toString());
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this._users);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public void copyTo(OnlineApplication onlineApplication) {
        if (onlineApplication != null && this != onlineApplication) {
            this._applicationID = onlineApplication.getApplicationID();
            this._applicationState = onlineApplication.getApplicationState();
            this._applicationDeactive = onlineApplication.isApplicationDeactive();
            this._deactivationPossible = onlineApplication.isDeactivationPossible();
            this._deviceID = onlineApplication.getDeviceID();
            if (!Util.isNullOrEmpty(onlineApplication.getServices())) {
                int n = onlineApplication.getServices().length;
                this._services = new OnlineService[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    this._services[i2] = new OnlineService();
                    this._services[i2].copyTo(onlineApplication.getServices()[i2]);
                }
            }
        }
    }
}

