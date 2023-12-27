/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.communication.teleprompter;

import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.internal.speechphone.utils.ServiceFunctions;
import de.vw.mib.asl.internal.speechphone.utils.SpeechPhoneLogger2;

public class TeleprompterStateHandler
implements TeleprompterStateConsumer {
    private final SpeechPhoneLogger2 logger;
    private final TeleprompterManager teleprompterManager;
    private final ServiceFunctions serviceFunctions;

    public TeleprompterStateHandler(ServiceFunctions serviceFunctions, TeleprompterManager teleprompterManager) {
        this.serviceFunctions = serviceFunctions;
        this.logger = serviceFunctions.createLogger("TeleprompterStateHandler");
        this.teleprompterManager = teleprompterManager;
        this.teleprompterManager.register(this);
    }

    public void teleprompterButtonPressed() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace("toggle teleprompter after button press");
        }
        this.teleprompterManager.toggle();
    }

    @Override
    public void onTeleprompterStateChanged(int n) {
        if (n == 0) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("show teleprompter");
            }
            this.serviceFunctions.writeIntegerToDatapool(2041133824, 1);
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("hide teleprompter");
            }
            this.serviceFunctions.writeIntegerToDatapool(2041133824, 2);
        }
    }
}

