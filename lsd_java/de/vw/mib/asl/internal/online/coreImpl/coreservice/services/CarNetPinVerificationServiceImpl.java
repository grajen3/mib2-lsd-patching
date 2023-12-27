/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.services;

import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationService;
import de.vw.mib.asl.api.online.services.verification.CarNetPinVerificationServiceListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreImpl.coreservice.callback.CoreServiceCarNetPinVerificationListenerImpl;
import de.vw.mib.log4mib.LogMessage;

public class CarNetPinVerificationServiceImpl
implements CarNetPinVerificationService {
    private final String _classname = super.getClass().getName();

    @Override
    public void verifyCarNetPin(String string, CarNetPinVerificationServiceListener carNetPinVerificationServiceListener) {
        if (carNetPinVerificationServiceListener != null) {
            CoreServiceImplFactory.getCoreServiceController().handleCarNetPinVerification(string, new CoreServiceCarNetPinVerificationListenerImpl(carNetPinVerificationServiceListener));
        } else {
            LogMessage logMessage = ServiceManager.logger2.info(16384);
            logMessage.append(this._classname).append(".verifyCarNetPin( Listener is NULL)").log();
        }
    }
}

