/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.ASLOnlineServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceStatusListener;
import de.vw.mib.log4mib.LogMessage;

public class CoreServiceStatusListenerImpl
implements CoreServiceStatusListener {
    private final String _classname = super.getClass().getName();
    private final ASLOnlineServiceListener _callback;

    public CoreServiceStatusListenerImpl(ASLOnlineServiceListener aSLOnlineServiceListener) {
        this._callback = aSLOnlineServiceListener;
    }

    @Override
    public void updateServiceStatusOnChange(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateServiceStatusOnChange( ").append(n).append(")").log();
        }
        if (this._callback != null) {
            this._callback.updateServiceStatusOnChange(n);
        }
    }
}

