/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.TrackingService;

public class TrackingServiceImpl
implements TrackingService {
    private String _serviceID;
    private boolean _serviceActiveInCurrentLifeCycle;
    private boolean _trackingActive;

    @Override
    public String getServiceID() {
        return this._serviceID;
    }

    @Override
    public void setServiceID(String string) {
        this._serviceID = string;
    }

    @Override
    public boolean isServiceActivatedInCurrentLifeCycle() {
        return this._serviceActiveInCurrentLifeCycle;
    }

    @Override
    public void setServiceToActivationInCurrentLifeCycle(boolean bl) {
        this._serviceActiveInCurrentLifeCycle = bl;
    }

    @Override
    public boolean isTrackingActivated() {
        return this._trackingActive;
    }

    @Override
    public void setTrackingActivated(boolean bl) {
        this._trackingActive = bl;
    }
}

