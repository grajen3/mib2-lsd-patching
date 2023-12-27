/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.message;

import de.esolutions.fw.comm.core.message.AbstractMessage;

public interface IOutgoingMessageListener {
    default public void outgoingMessage(AbstractMessage abstractMessage) {
    }
}

