/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.target.hmidump;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.hmidump.HmiDumpTargetDecoder;
import de.vw.mib.debug.service.debuginterface.hmidump.HmiDumpTargetDecoderListener;
import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.target.AbstractDebugTarget;
import java.io.IOException;

public class HmiDumpTarget
extends AbstractDebugTarget
implements HmiDumpTargetDecoderListener {
    private final HmiDumpTargetDecoder decoder = new HmiDumpTargetDecoder();

    public HmiDumpTarget() {
        super((short)108);
    }

    @Override
    public void messageDecoded(short s, ByteArrayReader byteArrayReader) {
        try {
            this.decoder.decode(byteArrayReader, this);
        }
        catch (IOException iOException) {
            this.logger.error(1, "[HmiDumpTarget] Error while reading message from datachannel!", iOException);
        }
    }

    @Override
    public void takingHmiDumpTrigger() {
        try {
            ServiceManager.errorHandler.dump();
        }
        catch (Exception exception) {
            this.logger.error(1, "[HmiDumpTarget] Error while writing hmi dump!", exception);
        }
    }

    @Override
    public void takingThreadDumpTrigger() {
        try {
            ServiceManager.threadManager.dump();
        }
        catch (Exception exception) {
            this.logger.error(1, "[HmiDumpTarget] Error while writing thread dump!", exception);
        }
    }

    @Override
    public void addTraceMarker(String string) {
        this.logger.info(8, new StringBuffer().append("Marker ").append(string).toString());
    }
}

