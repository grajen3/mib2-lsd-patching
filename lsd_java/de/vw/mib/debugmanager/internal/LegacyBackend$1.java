/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debugmanager.internal.LegacyBackend;
import de.vw.mib.debugmanager.internal.LegacyBinaryMessageHeaderCodec$LegacyCodecListener;

class LegacyBackend$1
implements LegacyBinaryMessageHeaderCodec$LegacyCodecListener {
    private final /* synthetic */ LegacyBackend this$0;

    LegacyBackend$1(LegacyBackend legacyBackend) {
        this.this$0 = legacyBackend;
    }

    @Override
    public void corruptedDataReceived(short s, String string) {
        this.this$0.logger.warn(1).append("corrupted data received from DebugSPI - type: ").append(s).append(", error: ").append(string).log();
    }

    @Override
    public void messageDecoded(short s, byte[] byArray, int n, int n2) {
        this.this$0.callbackDecoderListener.callbackMessageDecoded(s, byArray, n, n2);
    }

    @Override
    public void messageEncoded(short s, byte[] byArray, int n) {
        this.this$0.debugSpi.writeLogEntry(s, byArray, n);
    }
}

