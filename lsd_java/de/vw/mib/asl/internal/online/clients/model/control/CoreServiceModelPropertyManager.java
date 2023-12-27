/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.control;

import de.vw.mib.asl.internal.online.coreInterfaces.core.client.OnlineUser;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;

public final class CoreServiceModelPropertyManager {
    private String _precheckServiceID;
    private String _precheckServiceName;
    private String _precheckAppID;
    private OnlineUser _precheckUser;
    private int _precheckResult = -1;
    private int _registrationState;
    private boolean _wizardStartUp;
    private int[] _devices;

    public void resetPrecheckRequest() {
        this._precheckServiceID = "";
        this._precheckServiceName = "";
        this._precheckAppID = "";
        this._precheckUser = null;
        this._precheckResult = -1;
    }

    public String setPrecheckServiceID(String string) {
        this._precheckServiceID = string;
        return this._precheckServiceID;
    }

    public String getPrecheckServiceID() {
        return this._precheckServiceID;
    }

    public String setPrecheckServiceName(String string) {
        this._precheckServiceName = string;
        return this._precheckServiceName;
    }

    public String getPrecheckServiceName() {
        return this._precheckServiceName;
    }

    public String setPrecheckApplicationID(String string) {
        this._precheckAppID = string;
        return this._precheckAppID;
    }

    public String getPrecheckApplicationID() {
        return this._precheckAppID;
    }

    public OnlineUser setPrecheckUser(OnlineUser onlineUser) {
        this._precheckUser = onlineUser;
        return this._precheckUser;
    }

    public OnlineUser getPrecheckUser() {
        return this._precheckUser;
    }

    public void setPrecheckResult(int n) {
        this._precheckResult = n;
    }

    public int getPrecheckResult() {
        return this._precheckResult;
    }

    public int getRegistrationState() {
        return this._registrationState;
    }

    public void setRegistrationState(int n) {
        this._registrationState = n;
    }

    public boolean isWizardStartUp() {
        return this._wizardStartUp;
    }

    public void setWizardStartUp(boolean bl) {
        this._wizardStartUp = bl;
    }

    public void setAvailableDevices(int n) {
        if (Util.isNullOrEmpty(this._devices)) {
            this._devices = new int[1];
            this._devices[0] = n;
        } else {
            int n2 = this._devices.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._devices[i2] != n) continue;
                return;
            }
            this._devices = Arrays.copyOf(this._devices, this._devices.length + 1);
            this._devices[this._devices.length - 1] = n;
        }
    }

    public boolean isDeviceAvailable(int n) {
        if (!Util.isNullOrEmpty(this._devices)) {
            int n2 = this._devices.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this._devices[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    public int[] getDevicesAvailable() {
        return this._devices;
    }
}

