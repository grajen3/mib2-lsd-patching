/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.protocol;

import de.esolutions.fw.comm.core.protocol.IProtocolActions;

public interface IProtocolDecider {
    default public boolean reportProtocolRole(boolean bl, short s, Object object) {
    }

    default public boolean decideProtocolDrop(short s, Object object) {
    }

    default public IProtocolActions setupProtocolActions(short s, Object object) {
    }
}

