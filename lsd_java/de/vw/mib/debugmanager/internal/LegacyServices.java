/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.CallbackManager;
import de.vw.mib.debugmanager.internal.LegacyServices$1;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.log4mib.debugspi.BinaryMessageLogger;
import de.vw.mib.log4mib.debugspi.CallbackListener;

final class LegacyServices
implements BinaryMessageLogger {
    private final BinaryMessageFactory binaryMessageFactory;
    private final CallbackManager callbackHandlerService;

    LegacyServices(BinaryMessageFactory binaryMessageFactory, CallbackManager callbackManager) {
        this.binaryMessageFactory = binaryMessageFactory;
        this.callbackHandlerService = callbackManager;
    }

    @Override
    public BinaryMessage getBinaryMessage(short s, long l) {
        return this.binaryMessageFactory.createBinaryMessage(s);
    }

    @Override
    public void registerListener(short s, CallbackListener callbackListener) {
        this.callbackHandlerService.registerUnifiedLoggingCallbackListener(s, new LegacyServices$1(this, callbackListener));
    }

    @Override
    public void unregisterListener(short s, CallbackListener callbackListener) {
    }
}

