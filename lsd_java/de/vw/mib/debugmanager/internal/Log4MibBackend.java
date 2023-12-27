/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.internal.BinaryMessageHeaderCodec;
import de.vw.mib.debugmanager.internal.Log4MibBackend$1;
import de.vw.mib.debugmanager.internal.Log4MibBackendBase;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.timer.spi.TimerSPI;
import java.io.IOException;

class Log4MibBackend
extends Log4MibBackendBase {
    private final BinaryMessageHeaderCodec codec = new BinaryMessageHeaderCodec(new Log4MibBackend$1(this));

    Log4MibBackend(Logger logger, DebugSPI debugSPI, TimerSPI timerSPI, BinaryMessageFactory binaryMessageFactory) {
        super(logger, debugSPI, timerSPI, binaryMessageFactory);
    }

    @Override
    public long getTimestamp() {
        return (long)((double)this.timerSpi.getSystemTime() * this.cycleFactor_nanos);
    }

    @Override
    public void writeBinaryMessage(long l, short s, byte[] byArray, int n) {
        this.codec.writeBinaryMessage(l, s, byArray, n);
    }

    @Override
    void decodeCallback(byte[] byArray) {
        try {
            this.codec.readBinaryMessage(byArray);
        }
        catch (IOException iOException) {
            this.logger.warn(1).append("corrupted data received from DebugSPI - error: ").append(iOException.getMessage()).log();
        }
    }
}

