/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.LegacyServices;
import de.vw.mib.debugmanager.unifiedlogging.UnifiedLoggingCallbackListener;
import de.vw.mib.log4mib.debugspi.CallbackListener;

class LegacyServices$1
implements UnifiedLoggingCallbackListener {
    private final /* synthetic */ CallbackListener val$listener;
    private final /* synthetic */ LegacyServices this$0;

    LegacyServices$1(LegacyServices legacyServices, CallbackListener callbackListener) {
        this.this$0 = legacyServices;
        this.val$listener = callbackListener;
    }

    @Override
    public void onBinaryMessageReceived(short s, byte[] byArray, int n, int n2) {
        this.val$listener.receiveBinaryMessage(s, byArray, n, n2);
    }
}

