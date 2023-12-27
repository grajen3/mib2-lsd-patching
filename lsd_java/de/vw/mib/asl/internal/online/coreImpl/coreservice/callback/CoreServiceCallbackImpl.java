/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceCallbackImpl
implements CoreServiceCallback {
    private final String _classname = super.getClass().getName();
    private final ASLOnlineServiceCallback _callback;

    public CoreServiceCallbackImpl(ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        this._callback = aSLOnlineServiceCallback;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateImageInfo( ").append(resourceLocator != null ? resourceLocator.toString() : "null").append(")").log();
        }
        if (this._callback != null) {
            this._callback.updateImageInfo(resourceLocator);
        }
    }

    @Override
    public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
        if (this._callback != null) {
            this._callback.checkOnlineServiceStatusResponse(aSLOnlineServiceIdentifier, n);
        }
    }

    @Override
    public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
        if (this._callback != null) {
            this._callback.getServiceURLResponse(aSLOnlineServiceIdentifier, string);
        }
    }
}

