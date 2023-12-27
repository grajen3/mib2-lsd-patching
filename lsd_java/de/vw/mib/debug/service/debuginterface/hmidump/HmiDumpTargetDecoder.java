/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.hmidump;

import de.vw.mib.codec.ByteArrayReader;
import de.vw.mib.debug.service.debuginterface.hmidump.HmiDumpTargetDecoderListener;

public class HmiDumpTargetDecoder {
    private static final byte TAKE_HMIDUMP;
    private static final byte TAKE_THREADDUMP;
    private static final byte ADD_TRACEMARKER;

    public void decode(ByteArrayReader byteArrayReader, HmiDumpTargetDecoderListener hmiDumpTargetDecoderListener) {
        byte by = byteArrayReader.readByte();
        switch (by) {
            case 0: {
                hmiDumpTargetDecoderListener.takingHmiDumpTrigger();
                break;
            }
            case 1: {
                hmiDumpTargetDecoderListener.takingThreadDumpTrigger();
                break;
            }
            case 2: {
                hmiDumpTargetDecoderListener.addTraceMarker(byteArrayReader.readString());
                break;
            }
        }
    }
}

