/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.callback;

import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreInterfaces.service.CoreServiceCarNetPinVerificationListener;
import de.vw.mib.log4mib.LogMessage;

public class CoreServiceCarNetPinVerificationListenerImpl
implements CoreServiceCarNetPinVerificationListener {
    private final String _classname = super.getClass().getName();
    private final CarNetPinVerificationServiceListener _callback;

    public CoreServiceCarNetPinVerificationListenerImpl(CarNetPinVerificationServiceListener carNetPinVerificationServiceListener) {
        this._callback = carNetPinVerificationServiceListener;
    }

    @Override
    public void verifyCarNetPinResponse(int n) {
        if (ServiceManager.logger2.isTraceEnabled(16384)) {
            LogMessage logMessage = ServiceManager.logger2.trace(16384);
            logMessage.append(this._classname).append(".verifyCarNetPinResponse( ").append(n).append(")").log();
        }
        if (this._callback != null) {
            this._callback.verifyCarNetPinResponse(n);
        }
    }
}

