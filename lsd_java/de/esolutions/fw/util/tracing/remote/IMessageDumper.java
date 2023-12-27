/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;

public interface IMessageDumper {
    default public void dump(AbstractMessage abstractMessage) {
    }
}

