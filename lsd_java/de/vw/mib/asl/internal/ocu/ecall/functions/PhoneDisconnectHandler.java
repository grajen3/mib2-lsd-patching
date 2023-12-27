/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneServiceListener;
import de.vw.mib.log4mib.Logger;

class PhoneDisconnectHandler
implements PhoneServiceListener {
    private PhoneService phoneTerminateService;
    private boolean isPhoneCallActive;
    private final Logger logger;

    public PhoneDisconnectHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void phoneCallActive(boolean bl) {
        this.isPhoneCallActive = bl;
        if (this.phoneTerminateService != null && !this.isPhoneCallActive) {
            this.phoneTerminateService.phoneActivateDeactivatePhoneFunctionality(false);
            this.phoneTerminateService = null;
            if (this.logger.isTraceEnabled(512)) {
                this.logger.trace(512).append("PhoneDisconnectHandler: PhoneService: Perform deactivate phone functionality, after calls have been terminated").log();
            }
        }
        if (this.logger.isTraceEnabled(512)) {
            this.logger.trace(512).append("PhoneDisconnectHandler: isPhoneCallActive=").append(this.isPhoneCallActive).log();
        }
    }

    void terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate(boolean bl, PhoneService phoneService) {
        if (bl) {
            phoneService.phoneActivateDeactivatePhoneFunctionality(bl);
        } else if (this.isPhoneCallActive) {
            this.phoneTerminateService = phoneService;
            if (this.logger.isTraceEnabled(512)) {
                this.logger.trace(512).append("PhoneDisconnectHandler: PhoneService: Queue deactivate phone functionality").log();
            }
        } else {
            phoneService.phoneActivateDeactivatePhoneFunctionality(bl);
        }
        if (this.logger.isTraceEnabled(512)) {
            this.logger.trace(512).append("PhoneDisconnectHandler: terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate:").log();
        }
    }
}

