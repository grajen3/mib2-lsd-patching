/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.service.debuginterface.hmidump;

public interface HmiDumpTargetDecoderListener {
    default public void takingHmiDumpTrigger() {
    }

    default public void takingThreadDumpTrigger() {
    }

    default public void addTraceMarker(String string) {
    }
}

