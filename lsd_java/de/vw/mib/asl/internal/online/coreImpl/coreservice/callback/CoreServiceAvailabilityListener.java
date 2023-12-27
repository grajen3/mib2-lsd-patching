/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public class CoreServiceAvailabilityListener
implements ASLOnlineServiceAvailabilityListener {
    private final String _classname = super.getClass().getName();
    private ASLOnlineServiceAvailabilityListener _callback;

    public CoreServiceAvailabilityListener(ASLOnlineServiceAvailabilityListener aSLOnlineServiceAvailabilityListener) {
        this._callback = aSLOnlineServiceAvailabilityListener;
    }

    @Override
    public void updateOnlineServicesAvailabilityStatus(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateOnlineServicesAvailabilityStatus( ").append(n).toString()).append(")").log();
        }
        if (this._callback != null) {
            this._callback.updateOnlineServicesAvailabilityStatus(n);
        }
    }
}

