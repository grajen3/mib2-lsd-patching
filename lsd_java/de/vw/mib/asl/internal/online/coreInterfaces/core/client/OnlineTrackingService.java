/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.client;

public class OnlineTrackingService {
    private String _serviceID;
    private boolean _serviceActiveInCurrentLifeCycle;
    private boolean _trackingActive;

    public String getServiceID() {
        return this._serviceID;
    }

    public void setServiceID(String string) {
        this._serviceID = string;
    }

    public boolean isServiceActivatedInCurrentLifeCycle() {
        return this._serviceActiveInCurrentLifeCycle;
    }

    public void setServiceToActivationInCurrentLifeCycle(boolean bl) {
        this._serviceActiveInCurrentLifeCycle = bl;
    }

    public boolean isTrackingActivated() {
        return this._trackingActive;
    }

    public void setTrackingActivated(boolean bl) {
        this._trackingActive = bl;
    }
}

