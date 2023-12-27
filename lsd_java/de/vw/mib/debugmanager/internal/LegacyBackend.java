/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.internal.LegacyBackend$1;
import de.vw.mib.debugmanager.internal.LegacyBinaryMessageHeaderCodec;
import de.vw.mib.debugmanager.internal.Log4MibBackendBase;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.timer.spi.TimerSPI;

final class LegacyBackend
extends Log4MibBackendBase {
    private static final int UNSPECIFIED;
    private short externalHeaderOffset = (short)-1;
    private final LegacyBinaryMessageHeaderCodec headerCodec = new LegacyBinaryMessageHeaderCodec(new LegacyBackend$1(this));

    LegacyBackend(Logger logger, DebugSPI debugSPI, TimerSPI timerSPI, BinaryMessageFactory binaryMessageFactory) {
        super(logger, debugSPI, timerSPI, binaryMessageFactory);
        debugSPI.activateLogSink(1);
    }

    @Override
    public long getTimestamp() {
        return (long)((double)this.timerSpi.getSystemTime() * this.cycleFactor_millis);
    }

    @Override
    public void writeBinaryMessage(long l, short s, byte[] byArray, int n) {
        this.headerCodec.writeBinaryMessage(l, s, byArray, n);
    }

    @Override
    void decodeCallback(byte[] byArray) {
        if (this.externalHeaderOffset == -1) {
            this.externalHeaderOffset = byArray.length > 5 && byArray[0] == 3 && byArray[1] == 4 && byArray[2] == 5 ? (short)24 : (short)0;
        }
        this.headerCodec.readBinaryMessage((short)1, byArray, this.externalHeaderOffset, byArray.length - this.externalHeaderOffset);
    }
}

