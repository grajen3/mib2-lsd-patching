/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.ASLOnlineServiceCallback;
import de.vw.mib.asl.api.online.ASLOnlineServiceCallback1;
import de.vw.mib.asl.api.online.ASLOnlineServiceIdentifier;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceCallback1Impl$1;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCallback1;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceCallback1Impl
implements CoreServiceCallback1,
CoreServiceCallback {
    private final String _classname = super.getClass().getName();
    private final ASLOnlineServiceCallback1 _callback;
    private final ASLOnlineServiceCallback _callbackNotUsed;

    public CoreServiceCallback1Impl(ASLOnlineServiceCallback1 aSLOnlineServiceCallback1) {
        this._callback = aSLOnlineServiceCallback1;
        this._callbackNotUsed = null;
    }

    public CoreServiceCallback1Impl(ASLOnlineServiceCallback aSLOnlineServiceCallback) {
        this._callback = null;
        this._callbackNotUsed = aSLOnlineServiceCallback;
    }

    @Override
    public void updateImageInfo(ResourceLocator resourceLocator) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".updateImageInfo( ").append(resourceLocator != null ? resourceLocator.toString() : "null").append(")").log();
        }
        if (this._callback != null) {
            this._callback.updateImageInfo(resourceLocator);
        } else if (this._callbackNotUsed != null) {
            this._callbackNotUsed.updateImageInfo(resourceLocator);
        }
    }

    @Override
    public void updateImageInfo(int n, ResourceLocator resourceLocator) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(new StringBuffer().append(".updateImageInfo( ").append(n).append(", ").toString()).append(resourceLocator != null ? resourceLocator.toString() : "null").append(")").log();
        }
        if (this._callback != null) {
            this._callback.updateImageInfo(n, resourceLocator);
        } else if (this._callbackNotUsed != null) {
            this._callbackNotUsed.updateImageInfo(resourceLocator);
        }
    }

    @Override
    public void getServiceURLResponse(String string, String string2) {
        if (this._callback != null) {
            this._callback.getServiceURLResponse(string, string2);
        } else if (this._callbackNotUsed != null) {
            this._callbackNotUsed.getServiceURLResponse(new CoreServiceCallback1Impl$1(this, string), string2);
        }
    }

    @Override
    public void checkOnlineServiceStatusResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, int n) {
        if (this._callbackNotUsed != null) {
            this._callbackNotUsed.checkOnlineServiceStatusResponse(aSLOnlineServiceIdentifier, n);
        }
    }

    @Override
    public void getServiceURLResponse(ASLOnlineServiceIdentifier aSLOnlineServiceIdentifier, String string) {
        if (this._callbackNotUsed != null) {
            this._callbackNotUsed.getServiceURLResponse(aSLOnlineServiceIdentifier, string);
        }
    }
}

