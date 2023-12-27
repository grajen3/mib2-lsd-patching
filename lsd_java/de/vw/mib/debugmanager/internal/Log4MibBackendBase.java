/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debugmanager.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.debugmanager.internal.CallbackMessageDecoder;
import de.vw.mib.debugmanager.internal.CallbackMessageDecoder$CallbackDecoderListener;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.log4mib.BinaryMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.backend.BinaryMessageFactory;
import de.vw.mib.log4mib.backend.MessageWriter;
import de.vw.mib.log4mib.backend.TimestampProvider;
import de.vw.mib.timer.spi.TimerSPI;

abstract class Log4MibBackendBase
implements BinaryLogger,
CallbackMessageDecoder,
MessageWriter,
TimestampProvider {
    private static final double MILLI;
    private static final double NANO;
    protected CallbackMessageDecoder$CallbackDecoderListener callbackDecoderListener;
    protected final double cycleFactor_millis;
    protected final double cycleFactor_nanos;
    protected final BinaryMessageFactory binaryMessageFactory;
    protected final Logger logger;
    protected final DebugSPI debugSpi;
    protected final TimerSPI timerSpi;

    protected Log4MibBackendBase(Logger logger, DebugSPI debugSPI, TimerSPI timerSPI, BinaryMessageFactory binaryMessageFactory) {
        this.logger = logger;
        this.debugSpi = debugSPI;
        this.timerSpi = timerSPI;
        this.binaryMessageFactory = binaryMessageFactory;
        long l = timerSPI.getSystemTimeFrequency();
        this.cycleFactor_millis = 1000.0 / (double)l;
        this.cycleFactor_nanos = 1.0E9 / (double)l;
    }

    @Override
    public final void decodeCallbackMessage(byte[] byArray) {
        if (this.callbackDecoderListener == null) {
            return;
        }
        this.decodeCallback(byArray);
    }

    @Override
    public BinaryMessage getBinaryMessage(short s) {
        return this.binaryMessageFactory.createBinaryMessage(s);
    }

    @Override
    public final void register(CallbackMessageDecoder$CallbackDecoderListener callbackMessageDecoder$CallbackDecoderListener) {
        this.callbackDecoderListener = callbackMessageDecoder$CallbackDecoderListener;
    }

    @Override
    public void writeTextLogMessage(long l, int n, int n2, int n3, int n4, byte[] byArray) {
    }

    abstract void decodeCallback(byte[] byArray) {
    }
}

