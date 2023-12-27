/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public class NullBackend
extends AbstractTraceBackend {
    public NullBackend() {
        super("Null");
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        return true;
    }

    @Override
    public boolean droppedMessages(int n) {
        return true;
    }
}

